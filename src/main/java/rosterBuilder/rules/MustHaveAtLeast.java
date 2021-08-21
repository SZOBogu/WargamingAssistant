package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.Roster;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.UnitCounter;

public class MustHaveAtLeast extends RosterBuildingRule implements Rule {
    public MustHaveAtLeast(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Roster roster) {
        if(UnitCounter.countUnitsWith(roster, entity) < quantity)
            RuleViolationLog.appendRosterRuleViolationLog("Roster must contain at least " + quantity +
                    " units with " + entity.getName() + ".");
    }
}
