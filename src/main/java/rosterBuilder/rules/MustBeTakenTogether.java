package rosterBuilder.rules;

import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.pojos.Entity;
import rosterBuilder.utility.RuleViolationLog;
import rosterBuilder.pojos.Unit;

public class MustBeTakenTogether extends UnitBuildingRule implements Rule {
    public MustBeTakenTogether(Entity entity1, Entity entity2){
        super(entity1, entity2);
    }

    @Override
    public void check(Unit unit) {
        if(unit.getNonBaseEquipment().contains(entity1) && !unit.getNonBaseEquipment().contains(entity2))
            throw new UnitBuildingException(entity1 + " cannot be taken without " + entity2.getName() + ".");
    }
}
