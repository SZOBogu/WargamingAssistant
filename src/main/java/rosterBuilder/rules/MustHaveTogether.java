package rosterBuilder.rules;

import rosterBuilder.Entity;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.Unit;

import java.util.ArrayList;

public class MustHaveTogether extends UnitBuildingRule implements Rule {
    public MustHaveTogether(Entity entity1, Entity entity2){
        super(entity1, entity2);
    }

    @Override
    public void check(Unit unit){
        RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();
        ArrayList<Entity> all = new ArrayList<>();
        all.addAll(unit.getBaseEquipmentAndRules());
        all.addAll(unit.getNonBaseEquipment());

        if(all.contains(entity1) && !all.contains(entity2))
            ruleViolationLog.appendUnitRuleViolationLog("Unit must have " + entity1.getName() +
                    " and " + entity2.getName() + " together.");
    }
}
