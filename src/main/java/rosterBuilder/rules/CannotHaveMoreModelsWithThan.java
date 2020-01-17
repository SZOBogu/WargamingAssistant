package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.ModelCounter;
import rosterBuilder.Roster;
import rosterBuilder.RuleViolationLog;

public class CannotHaveMoreModelsWithThan extends RosterBuildingRule implements Rule {
    public CannotHaveMoreModelsWithThan(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Roster roster) {
        RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();
        ModelCounter counter = new ModelCounter();
        if(counter.countModelsWith(roster, entity) > quantity){
            ruleViolationLog.appendRosterRuleViolationLog("Roster cannot contain more than " +
                    quantity + " models with " + entity.getName() + ".");
        }
    }
}
