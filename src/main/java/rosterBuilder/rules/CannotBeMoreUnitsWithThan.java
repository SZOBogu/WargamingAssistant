package rosterBuilder.rules;

import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.entities.Entity;
import rosterBuilder.entities.Roster;
import rosterBuilder.utility.UnitCounter;

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
