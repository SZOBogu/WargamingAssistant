package rosterBuilder.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.pojos.*;
import rosterBuilder.requests.*;
import rosterBuilder.rules.CategoryPointCapExceedRule;
import rosterBuilder.rules.RosterBuildingRule;
import rosterBuilder.rules.RosterPointCapExceedingRule;
import rosterBuilder.rules.UnitBuildingRule;
import rosterBuilder.utility.RuleMerger;
import rosterBuilder.utility.RuleViolationLog;
import rosterBuilder.utility.UnitAndProfileFinder;

import java.util.ArrayList;
import java.util.List;

@Service
public class RosterService {
    private SessionFactory sessionFactory;

    public String checkRoster(CheckRosterRequest request){
        StringBuilder ruleViolationLog = new StringBuilder();
        try{
            Session session = sessionFactory.openSession();
            WargamingSystem system = session.get(WargamingSystem.class, request.getWargameId());

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
            session.close();
            return ruleViolationLog.toString();
        }
        finally{
            assert true;
        }
    }

    public List<Detachment> getDetachmentList(GetDetachmentTypeListRequest request){
        List<Detachment> detachments = new ArrayList<>();
        try {
            Session session = sessionFactory.openSession();
            WargamingSystem system = session.get(WargamingSystem.class, request.getWargameId());
            detachments.addAll(system.getDetachments());
            session.close();
        }
        finally{
            assert true;
        }
        return detachments;
    }

    public Roster saveDetachment(SaveDetachmentRequest request){
        Roster roster;
        try {
            Session session = sessionFactory.openSession();
            WargamingSystem system = session.get(WargamingSystem.class, request.getWargameId());
            roster = request.getRoster();
            roster.addDetachment(system.getDetachments().get(request.getDetachmentIndex()));
            session.saveOrUpdate(roster);
            session.close();
        }
        finally{
            assert true;
        }
        return roster;
    }

    public Roster deleteDetachment(DeleteDetachmentRequest request){
        Roster roster;
        try {
            Session session = sessionFactory.openSession();
            roster = request.getRoster();
            roster.removeDetachment(request.getDetachmentIndex());
            session.saveOrUpdate(roster);
            session.close();
        }
        finally{
            assert true;
        }
        return roster;
    }

    public String saveUnit(SaveUnitRequest request) {
        Roster roster = request.getRoster();
        Unit unit = request.getUnit();
        StringBuilder ruleViolationLog = new StringBuilder();

        try {
            Session session = sessionFactory.openSession();
            UnitProfile unitProfile = session.get(UnitProfile.class, request.getUnitProfileId());
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
                session.save(unit);
                roster.getDetachments().get(request.getDetachmentIndex()).addUnit(unit, request.getCategoryIndex(),
                        roster.getUniqueEntitiesPool());
                session.saveOrUpdate(roster);
            }
        }
        catch(Exception ex){
            ruleViolationLog.append(ex.getMessage());
        }
        return ruleViolationLog.toString();
    }

    public Roster deleteUnit(DeleteUnitRequest request){
        Roster roster;
        try {
            Session session = sessionFactory.openSession();
            roster = request.getRoster();
            roster.getDetachments().get(request.getDetachmentIndex()).deleteUnit(request.getCategoryIndex(), request.getUnitIndex(), roster.getUniqueEntitiesPool());
            session.delete(request.getUnit());
            session.saveOrUpdate(roster);
            session.close();
        }
        finally{
            assert true;
        }
        return roster;
    }

    public Roster createRoster(CreateRosterRequest request) {
        Roster roster = new Roster();
        try{
            Session session = sessionFactory.openSession();
            WargamingSystem system = session.get(WargamingSystem.class, request.getWargameId());
            Army army = session.get(Army.class, request.getArmyId());
            Detachment detachment = session.get(Detachment.class, request.getDetachmentId());

            roster.addDetachment(detachment);
            roster.setPrimaryArmy(army);
            roster.setUniqueEntitiesPool(system.getPool());
            roster.setPointCap(request.getPointLimit());
            session.save(roster);
            session.close();
        }
        finally{
            assert true;
        }
        return roster;
    }
}
