package rosterBuilder.rules;

import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.entities.Entity;
import rosterBuilder.entities.Unit;

public class CannotBeTakenWithLessThanModels extends UnitBuildingRule implements Rule {
    public CannotBeTakenWithLessThanModels(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Unit unit){
        if(unit.getNonBaseEquipment().contains(entity1) && unit.getModelsInUnit() < modelQuantity){
            throw new UnitBuildingException(
                    entity1.getName() + " cannot be taken on units with less than " + modelQuantity + " models.");
        }
    }
}
