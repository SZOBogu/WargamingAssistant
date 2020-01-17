package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.Unit;

public class MustBeTakenTogether extends UnitBuildingRule implements Rule {
    public MustBeTakenTogether(Entity entity1, Entity entity2){
        super(entity1, entity2);
    }

    @Override
    public void check(Unit unit) {
        RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();
        if(unit.getNonBaseEquipment().contains(entity1) && !unit.getNonBaseEquipment().contains(entity2))
            ruleViolationLog.appendUnitRuleViolationLog(entity1 + " cannot be taken without " + entity2.getName() + ".");
    }
}
