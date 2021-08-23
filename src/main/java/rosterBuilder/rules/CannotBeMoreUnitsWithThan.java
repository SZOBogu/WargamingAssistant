package rosterBuilder.rules;

import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.pojos.Entity;
import rosterBuilder.pojos.Roster;
import rosterBuilder.utility.RuleViolationLog;
import rosterBuilder.utility.UnitCounter;

import java.io.Serializable;

public class CannotBeMoreUnitsWithThan extends RosterBuildingRule implements Rule {
    public CannotBeMoreUnitsWithThan(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Roster roster) {
        if(UnitCounter.countUnitsWith(roster, entity) > quantity){
            throw new RosterBuildingException(
                    "Roster cannot have more than " + quantity + " units with " + entity.getName() + ".");
        }
    }
}
