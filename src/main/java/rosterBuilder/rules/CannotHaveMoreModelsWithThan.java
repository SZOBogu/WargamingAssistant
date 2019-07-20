package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.ModelCounter;
import rosterBuilder.Roster;
import rosterBuilder.RuleViolationLog;

public class CannotHaveMoreModelsWithThan extends RosterBuildingRule {
    public CannotHaveMoreModelsWithThan(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Roster roster) {
        ModelCounter counter = new ModelCounter();
        if(counter.countModelsWith(roster, entity) > quantity){
            RuleViolationLog.appendRosterRuleViolationLog("Roster cannot contain more than " +
                    quantity + " models with " + entity.getName() + ".");
        }
    }
}
