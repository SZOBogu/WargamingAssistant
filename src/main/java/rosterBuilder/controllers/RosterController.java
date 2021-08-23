package rosterBuilder.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.pojos.*;
import rosterBuilder.requests.*;
import rosterBuilder.rules.RosterBuildingRule;
import rosterBuilder.rules.UnitBuildingRule;
import rosterBuilder.swingGUI.RosterDisplayMenu;
import rosterBuilder.utility.RuleViolationLog;
import rosterBuilder.utility.UnitAndProfileFinder;

import java.util.List;

@RestController
@RequestMapping("/roster")
public class RosterController {
    private WargamingSystem system;

    @GetMapping("/unit/{armyIndex}/{categoryIndex}/{unitIndex}")
    public UnitProfile getUnitProfile(@PathVariable int armyIndex, @PathVariable int categoryIndex, @PathVariable int unitIndex){
        return system.getArmy(armyIndex).getArmySubcategory(categoryIndex).getUnitProfile(unitIndex);
    }

    @PostMapping("/unit")
    public ResponseEntity<String> addUnit(@RequestBody AddUnitRequest request) throws JsonProcessingException {
        Roster roster = request.getRoster();
        Unit unit = request.getUnit();
        UnitProfile unitProfile = UnitAndProfileFinder.getProfile(system.getArmy(request.getArmyIndex()), unit);

        for(UnitBuildingRule rule : unitProfile.getRules()) {
            try {
                rule.check(unit);
            } catch (UnitBuildingException unitBuildingException) {
                RuleViolationLog.appendUnitRuleViolationLog(unitBuildingException.getMessage());
            } catch (RosterBuildingException rosterBuildingException) {
                RuleViolationLog.appendRosterRuleViolationLog(rosterBuildingException.getMessage());
            }
        }

        if(RuleViolationLog.getRosterRuleViolationLog().isEmpty() && RuleViolationLog.getUnitRuleViolationLog().isEmpty()){
            roster.getDetachments().get(request.getDetachmentIndex()).addUnit(unit, request.getCategoryIndex());
            ObjectMapper mapper = new ObjectMapper();
            String rosterJson = mapper.writeValueAsString(roster);
            return new ResponseEntity<>(rosterJson, HttpStatus.OK);
        }

        String ruleViolations = RuleViolationLog.getRosterRuleViolationLog() + "\n" + RuleViolationLog.getUnitRuleViolationLog();
        RuleViolationLog.clear();
        return new ResponseEntity<>(ruleViolations, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/unit")
    public Roster deleteUnit(@RequestBody DeleteUnitRequest request){
        Roster roster = request.getRoster();
        roster.getDetachments().get(request.getDetachmentId()).deleteUnit(request.getCategoryId(), request.getUnitId());

        return roster;
    }

    @PostMapping("/detachment")
    public Roster addDetachment(@RequestBody AddDetachmentRequest request){
        Roster roster = request.getRoster();
        roster.addDetachment(this.system.getDetachments().get(request.getDetachmentIndex()));
        return roster;
    }

    @DeleteMapping("/detachment")
    public Roster deleteDetachment(@RequestBody DeleteDetachmentRequest request){
        Roster roster = request.getRoster();
        roster.removeDetachment(request.getDetachmentIndex());

        return roster;
    }

    @PostMapping("/check")
    public ResponseEntity<String> checkRoster(@RequestBody Roster roster){
        List<RosterBuildingRule> rules = this.system.getRules();

        if(roster.getTotalCost() > roster.getPointCap())
            RuleViolationLog.appendRosterRuleViolationLog("Point Limit Exceeded.");

        for (RosterBuildingRule rule : rules) {
            rule.check(roster);
        }

        if(RuleViolationLog.getRosterRuleViolationLog().isEmpty()) {
            return new ResponseEntity<>("Roster created correctly.", HttpStatus.OK);
        }
        else {
            String ruleViolations = RuleViolationLog.getRosterRuleViolationLog();
            RuleViolationLog.clear();
            return new ResponseEntity<>(ruleViolations, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/file")
    public ResponseEntity<FileSystemResource> getFile(@RequestBody Roster roster){
//        String fullPath = stuffService.figureOutFileNameFor(stuffId);
//        File file = new File(fullPath);
//        long fileLength = file.length();
        return null;
    }

    @Autowired
    public void setSystem(WargamingSystem system) {
        this.system = system;
    }
}