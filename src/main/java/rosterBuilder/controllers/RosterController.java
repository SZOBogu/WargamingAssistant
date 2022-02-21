package rosterBuilder.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.pojos.*;
import rosterBuilder.requests.*;
import rosterBuilder.rules.RosterBuildingRule;
import rosterBuilder.rules.UnitBuildingRule;
import rosterBuilder.services.RosterService;
import rosterBuilder.services.UnitService;
import rosterBuilder.utility.RuleMerger;
import rosterBuilder.utility.RuleViolationLog;
import rosterBuilder.utility.UnitAndProfileFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roster")
public class RosterController {
//    private WargamingSystem system;
    @Autowired
    private RosterService rosterService;
    @Autowired
    private UnitService unitService;

    @PostMapping
    public Roster createRoster(@RequestBody CreateRosterRequest request){
        return this.rosterService.createRoster(request);
    }

    @GetMapping("/unit/{unitIndex}")
    public UnitProfile getUnitProfile(@PathVariable int unitIndex){
        return this.unitService.getUnitProfile(unitIndex);
    }

    @GetMapping(value = "/unit", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<List<UnitProfile>> getUnitList(@RequestBody GetUnitListRequest request) throws JsonProcessingException {
        return this.unitService.getUnitList(request);
    }

    @PostMapping("/unit")
    public ResponseEntity<String> saveUnit(@RequestBody SaveUnitRequest request) throws JsonProcessingException {
        String ruleViolationLog = this.rosterService.saveUnit(request);

        if(ruleViolationLog.isEmpty()){
            ObjectMapper mapper = new ObjectMapper();
            String rosterJson = mapper.writeValueAsString(request.getRoster());
            return new ResponseEntity<>(rosterJson, HttpStatus.OK);
        }
        return new ResponseEntity<>(ruleViolationLog, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/unit")
    public Roster deleteUnit(@RequestBody DeleteUnitRequest request){
        return this.rosterService.deleteUnit(request);
    }

    @GetMapping("/detachment")
    public List<Detachment> getDetachmentList(@RequestBody GetDetachmentTypeListRequest request){
        return this.rosterService.getDetachmentList(request);
    }

    @PostMapping("/detachment")
    public Roster saveDetachment(@RequestBody SaveDetachmentRequest request){
        return this.rosterService.saveDetachment(request);
    }

    @DeleteMapping("/detachment")
    public Roster deleteDetachment(@RequestBody DeleteDetachmentRequest request){
        return this.rosterService.deleteDetachment(request);
    }

    @PostMapping("/check")
    public ResponseEntity<String> checkRoster(@RequestBody CheckRosterRequest request){
        String ruleViolationLog = this.rosterService.checkRoster(request);

        if(ruleViolationLog.isEmpty()) {
            return new ResponseEntity<>("Roster created correctly.", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ruleViolationLog, HttpStatus.BAD_REQUEST);
        }
    }
}