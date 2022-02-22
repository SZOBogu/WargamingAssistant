package rosterBuilder.rules;

import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.pojos.Entity;
import rosterBuilder.pojos.Roster;
import rosterBuilder.utility.UnitCounter;

public class MustHaveAtLeast extends RosterBuildingRule implements Rule {
    public MustHaveAtLeast(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Roster roster) {
        if(UnitCounter.countUnitsWith(roster, entity) < quantity)
            throw new RosterBuildingException("Roster must contain at least " + quantity +
                    " units with " + entity.getName() + ".");
    }
}
