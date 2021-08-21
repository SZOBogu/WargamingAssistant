package rosterBuilder.rules;

import rosterBuilder.pojos.Entity;
import rosterBuilder.utility.RuleViolationLog;
import rosterBuilder.pojos.Unit;

import java.util.ArrayList;

public class CannotHaveTogether extends UnitBuildingRule implements Rule {
    public CannotHaveTogether(Entity entity1, Entity entity2){
        super(entity1, entity2);
    }

    @Override
    public void check(Unit unit) {
        ArrayList<Entity> allEntities = new ArrayList<>();
        allEntities.addAll(unit.getNonBaseEquipment());
        allEntities.addAll(unit.getBaseEquipmentAndRules());

        if(allEntities.contains(entity1) && allEntities.contains(entity2))
            RuleViolationLog.appendUnitRuleViolationLog("Unit cannot have " + entity1.getName() +
                    " and " + entity2.getName() + " together.");
    }
}
