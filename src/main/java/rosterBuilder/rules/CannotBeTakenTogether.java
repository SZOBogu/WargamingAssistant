package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.Unit;

public class CannotBeTakenTogether extends UnitBuildingRule {
    public CannotBeTakenTogether(Entity entity1, Entity entity2){
        super(entity1, entity2);
    }
    @Override
    public void check(Unit unit) {
        if(unit.getNonBaseEquipment().contains(entity1) && unit.getNonBaseEquipment().contains(entity2)){
            RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();
            ruleViolationLog.appendUnitRuleViolationLog(entity1.getName() + " and " + entity2.getName() + " cannot be taken together");
        }
    }
}
