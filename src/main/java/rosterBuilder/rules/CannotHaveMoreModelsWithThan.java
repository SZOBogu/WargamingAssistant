package rosterBuilder.rules;

import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.entities.Entity;
import rosterBuilder.utility.ModelCounter;
import rosterBuilder.entities.Roster;

public class CannotHaveMoreModelsWithThan extends RosterBuildingRule implements Rule {
    public CannotHaveMoreModelsWithThan(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Roster roster) {
        if(ModelCounter.countModelsWith(roster, entity) > quantity){
            throw new RosterBuildingException("Roster cannot contain more than " +
                    quantity + " models with " + entity.getName() + ".");
        }
    }
}
