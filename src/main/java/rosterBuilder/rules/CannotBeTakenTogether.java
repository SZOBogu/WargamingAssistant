package rosterBuilder.rules;

import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.entities.Entity;
import rosterBuilder.entities.Unit;

public class CannotBeTakenTogether extends UnitBuildingRule implements Rule {
    public CannotBeTakenTogether(Entity entity1, Entity entity2){
        super(entity1, entity2);
    }
    @Override
    public void check(Unit unit) {
        if(unit.getNonBaseEquipment().contains(entity1) && unit.getNonBaseEquipment().contains(entity2)){
            throw new UnitBuildingException(
                    entity1.getName() + " and " + entity2.getName() + " cannot be taken together");
        }
    }
}
