package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.Unit;

public class CannotBeTakenWithMoreThanModels extends UnitBuildingRule implements Rule {
    public CannotBeTakenWithMoreThanModels(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Unit unit){
        if(unit.getNonBaseEquipment().contains(entity1) && unit.getModelsInUnit() > modelQuantity){
            RuleViolationLog.appendUnitRuleViolationLog(
                    entity1.getName() + " cannot be taken on units with more than " + modelQuantity + " models.");
        }
    }
}
