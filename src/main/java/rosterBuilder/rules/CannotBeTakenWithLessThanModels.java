package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.Unit;

public class CannotBeTakenWithLessThanModels extends UnitBuildingRule{
    public CannotBeTakenWithLessThanModels(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Unit unit){
        if(unit.getNonBaseEquipment().contains(entity1) && unit.getModelsInUnit() < modelQuantity){
            RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();
            ruleViolationLog.appendUnitRuleViolationLog(entity1.getName() + " cannot be taken on units with less than " + modelQuantity + " models.");
        }
    }
}
