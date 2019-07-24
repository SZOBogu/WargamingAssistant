package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.Roster;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.UnitCounter;

public class MustHaveExactly extends RosterBuildingRule {
    public MustHaveExactly(Entity entity, int quantity){
        super(entity, quantity);
    }


    @Override
    public void check(Roster roster) {
        UnitCounter counter = new UnitCounter();
        RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();
        if(counter.countUnitsWith(roster, entity) != quantity)
            ruleViolationLog.appendRosterRuleViolationLog("Roster must contain exactly " + quantity +
                    " units with " + entity.getName() + ".");
    }
}
