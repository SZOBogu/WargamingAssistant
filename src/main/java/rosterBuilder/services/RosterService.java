package rosterBuilder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rosterBuilder.daos.IRosterDAO;
import rosterBuilder.daos.IWargameDAO;
import rosterBuilder.entities.*;
import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.requests.*;
import rosterBuilder.rules.CategoryPointCapExceedRule;
import rosterBuilder.rules.RosterBuildingRule;
import rosterBuilder.rules.RosterPointCapExceedingRule;
import rosterBuilder.rules.UnitBuildingRule;
import rosterBuilder.utility.DetachmentRuleChecker;
import rosterBuilder.utility.RuleMerger;
import java.util.List;

@Service
public class RosterService {
    @Autowired
    private IRosterDAO rosterDAO;
    @Autowired
    private IWargameDAO wargameDAO;

    public String checkRoster(CheckRosterRequest request){
        StringBuilder ruleViolationLog = new StringBuilder();
        WargamingSystem system = this.wargameDAO.getWargamingSystem(request.getWargameId());

        for(Detachment det : request.getRoster().getDetachments()){
            DetachmentRuleChecker.checkDetachment(det);
        }

        List<RosterBuildingRule> rules = RuleMerger.mergeRosterRules(system.getRules(), request.getEventRules());

        RosterPointCapExceedingRule pointCapRule = new RosterPointCapExceedingRule();
        pointCapRule.check(request.getRoster());

        for(int i = 0; i < request.getRoster().getDetachments().size(); i++){
            for(int j = 0; j < request.getRoster().getDetachments().get(i).getBoughtUnitsCategorized().size(); j++){
                CategoryPointCapExceedRule categoryCapRule = new CategoryPointCapExceedRule();
                categoryCapRule.check(request.getRoster(), i, j);
            }
        }
        for (RosterBuildingRule rule : rules) {
            try {
                rule.check(request.getRoster());
            }
            catch(RosterBuildingException ex){
                ruleViolationLog.append(ex.getMessage()).append("\n");
            }
        }
        return ruleViolationLog.toString();
    }

    public List<Detachment> getDetachmentList(GetDetachmentTypeListRequest request){
        return this.rosterDAO.getDetachmentList(request);
    }

    public Roster saveDetachment(SaveDetachmentRequest request){
        return this.rosterDAO.saveDetachment(request);
    }

    public Roster deleteDetachment(DeleteDetachmentRequest request){
        return this.rosterDAO.deleteDetachment(request);
    }

    public String saveUnit(SaveUnitRequest request) {
        Roster roster = request.getRoster();
        Unit unit = request.getUnit();
        StringBuilder ruleViolationLog = new StringBuilder();

        UnitProfile unitProfile = this.rosterDAO.getUnitProfile(request.getUnitProfileId());
        List<UnitBuildingRule> allRules = RuleMerger.mergeUnitRules(unitProfile.getRules(),
                request.getUnitBuildingRuleList());

        for (UnitBuildingRule rule : allRules) {
           try {
               rule.check(unit);
           } catch (UnitBuildingException | RosterBuildingException unitBuildingException) {
               ruleViolationLog.append(unitBuildingException.getMessage());
           }
        }

        if(ruleViolationLog.toString().isEmpty()){
            roster.getDetachments().get(request.getDetachmentIndex()).addUnit(unit, request.getCategoryIndex(),
                    roster.getUniqueEntitiesPool());
            this.rosterDAO.saveUnit(unit);
            this.rosterDAO.updateRoster(roster);
        }
        return ruleViolationLog.toString();
    }

    public Roster deleteUnit(DeleteUnitRequest request){
        return this.rosterDAO.deleteUnit(request);
    }

    public Roster createRoster(CreateRosterRequest request) {
        return this.rosterDAO.createRoster(request);
    }
}
