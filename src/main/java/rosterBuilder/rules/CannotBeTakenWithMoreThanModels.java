package rosterBuilder.rules;

import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.entities.Entity;
import rosterBuilder.entities.Unit;

public class CannotBeTakenWithMoreThanModels extends UnitBuildingRule implements Rule {
    public CannotBeTakenWithMoreThanModels(Entity entity, int quantity){
        super(entity, quantity);
    }

    @Override
    public void check(Unit unit){
        if(unit.getNonBaseEquipment().contains(entity1) && unit.getModelsInUnit() > modelQuantity){
            throw new UnitBuildingException(
                    entity1.getName() + " cannot be taken on units with more than " + modelQuantity + " models.");
        }
    }
}
