package rosterBuilder.rules;

import rosterBuilder.pojos.Entity;
import rosterBuilder.utility.RuleViolationLog;
import rosterBuilder.pojos.Unit;

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
