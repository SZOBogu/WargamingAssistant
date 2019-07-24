package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.Roster;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.UnitCounter;

public class CannotBeMoreUnitsWithThan extends RosterBuildingRule {
    public CannotBeMoreUnitsWithThan(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Roster roster) {
        UnitCounter counter = new UnitCounter();
        if(counter.countUnitsWith(roster, entity) > quantity){
            RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();
            ruleViolationLog.appendRosterRuleViolationLog("Roster cannot have more than " + quantity + " units with " + entity.getName() + ".");
        }
    }
}
