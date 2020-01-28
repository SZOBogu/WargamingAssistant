package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.Roster;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.UnitCounter;

public class MustHaveExactly extends RosterBuildingRule implements Rule {
    public MustHaveExactly(Entity entity, int quantity){
        super(entity, quantity);
    }


    @Override
    public void check(Roster roster) {
        UnitCounter counter = new UnitCounter();
        if(counter.countUnitsWith(roster, entity) != quantity)
            RuleViolationLog.appendRosterRuleViolationLog("Roster must contain exactly " + quantity +
                    " units with " + entity.getName() + ".");
    }
}
