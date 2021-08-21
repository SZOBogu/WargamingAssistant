package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.Roster;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.UnitCounter;

public class CannotBeMoreUnitsWithThan extends RosterBuildingRule implements Rule {
    public CannotBeMoreUnitsWithThan(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Roster roster) {
        if(UnitCounter.countUnitsWith(roster, entity) > quantity){
            RuleViolationLog.appendRosterRuleViolationLog(
                    "Roster cannot have more than " + quantity + " units with " + entity.getName() + ".");
        }
    }
}
