package rosterBuilder.rules;

import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.entities.Entity;
import rosterBuilder.entities.Unit;

import java.util.ArrayList;

public class MustHaveTogether extends UnitBuildingRule implements Rule {
    public MustHaveTogether(Entity entity1, Entity entity2){
        super(entity1, entity2);
    }

    @Override
    public void check(Unit unit){
        ArrayList<Entity> all = new ArrayList<>();
        all.addAll(unit.getBaseEquipmentAndRules());
        all.addAll(unit.getNonBaseEquipment());

        if(all.contains(entity1) && !all.contains(entity2))
            throw new UnitBuildingException("Unit must have " + entity1.getName() +
                    " and " + entity2.getName() + " together.");
    }
}
