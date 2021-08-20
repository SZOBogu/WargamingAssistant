package rosterBuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rosterBuilder.*;
import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.requests.AddUnitRequest;
import rosterBuilder.requests.CreateRosterRequest;
import rosterBuilder.requests.DeleteUnitRequest;
import rosterBuilder.rules.RosterBuildingRule;
import rosterBuilder.swingGUI.RosterDisplayMenu;

import java.util.List;

@RestController
@RequestMapping("/roster")
public class RosterController {
    private WargamingSystem system;
    private Roster roster = new Roster();

    @GetMapping("/unit/{armyIndex}/{categoryIndex}/{unitIndex}")
    public UnitProfile getUnitProfile(@PathVariable int armyIndex, @PathVariable int categoryIndex, @PathVariable int unitIndex){
        return system.getArmy(armyIndex).getArmySubcategory(categoryIndex).getUnitProfile(unitIndex);
    }

    @PostMapping("/unit")
    public Unit addUnit(@RequestBody AddUnitRequest request){
        try{
            this.roster.getDetachments().get(request.getDetachmentId()).addUnit(request.getUnit(), request.getCategoryId());
            return request.getUnit();
        }
        catch(UnitBuildingException unitBuildingException){
            System.out.println("Unit building rule violated");
        }
        catch(RosterBuildingException rosterBuildingException){
            System.out.println("Roster building rule violated");
        }
        return new Unit();
    }

    @DeleteMapping("/unit")
    public String deleteUnit(@RequestBody DeleteUnitRequest request){
        this.roster.getDetachments().get(request.getDetachmentId()).deleteUnit(request.getCategoryId(), request.getUnitId());
        return "Unit Deleted";
    }

    @GetMapping("/detachment/{detachmentId}")
    public Detachment getDetachment(@PathVariable int detachmentId){
        return this.roster.getDetachments().get(detachmentId);
    }

    @PostMapping("/detachment")
    public Detachment addDetachment(@RequestBody Detachment detachment){
        this.roster.addDetachment(detachment);
        return detachment;
    }

    @DeleteMapping("/detachment/{detachmentId}")
    public Detachment deleteDetachment(@PathVariable int detachmentId){
        Detachment detachment = this.roster.getDetachments().get(detachmentId);
        this.roster.removeDetachment(detachmentId);
        return detachment;
    }

    @GetMapping("/roster")
    public Roster getRoster(){
        return roster;
    }

    @PostMapping("/roster/create")
    public Roster createRoster(@RequestBody CreateRosterRequest request){
        roster.setPointCap(request.getPointCap());
        roster.setPrimaryArmy(this.system.getArmy(request.getPrimaryArmyIndex()));
        Detachment detachment = this.system.getEmptyDetachment(request.getDetachmentTypeIndex());
        detachment.setPool(this.system.getPool());
        roster.addDetachment(detachment);
        roster.getDetachments().get(0).setArmy(roster.getPrimaryArmy());
        roster.getDetachments().get(0).setDetachmentNumber(0);

        return roster;
    }

    @PostMapping("/roster/check")
    public ResponseEntity<String> checkRoster(@RequestBody Roster roster){
        List<RosterBuildingRule> rules = this.system.getRules();

        if(roster.getTotalCost() > roster.getPointCap())
            RuleViolationLog.appendRosterRuleViolationLog("Point Limit Exceeded.");
        for (RosterBuildingRule rule : rules) {
            rule.check(roster);
        }

        if(RuleViolationLog.getRosterRuleViolationLog().isEmpty()) {
            new RosterDisplayMenu(this.roster);
            return new ResponseEntity<>("Roster created successfully.", HttpStatus.OK);
        }
        else {
            String ruleViolations = RuleViolationLog.getRosterRuleViolationLog();
            RuleViolationLog.clear();
            return new ResponseEntity<>(ruleViolations, HttpStatus.BAD_REQUEST);
        }
    }

    @Autowired
    public void setSystem(WargamingSystem system) {
        this.system = system;
    }
}
