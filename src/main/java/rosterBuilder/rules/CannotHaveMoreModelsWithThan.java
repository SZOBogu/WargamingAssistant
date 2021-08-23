package rosterBuilder.rules;

import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.pojos.Entity;
import rosterBuilder.utility.ModelCounter;
import rosterBuilder.pojos.Roster;
import rosterBuilder.utility.RuleViolationLog;

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
