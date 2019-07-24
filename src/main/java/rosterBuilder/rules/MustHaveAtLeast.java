package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.Roster;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.UnitCounter;

public class MustHaveAtLeast extends RosterBuildingRule {
    public MustHaveAtLeast(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Roster roster) {
        UnitCounter counter = new UnitCounter();
        RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();
        if(counter.countUnitsWith(roster, entity) < quantity)
            ruleViolationLog.appendRosterRuleViolationLog("Roster must contain at least " + quantity +
                    " units with " + entity.getName() + ".");
    }
}
