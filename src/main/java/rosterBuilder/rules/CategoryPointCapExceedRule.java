package rosterBuilder.rules;

import rosterBuilder.Roster;
import rosterBuilder.RosterCostCalculator;
import rosterBuilder.RuleViolationLog;

public class CategoryPointCapExceedRule implements Rule {
    public void check(Roster roster, int detachmentNumber, int categoryNumber) {
        RosterCostCalculator rosterCostCalculator = new RosterCostCalculator();
        if(rosterCostCalculator.calculateCategoryCost(roster,detachmentNumber, categoryNumber) > roster.getDetachments().get(detachmentNumber).getArmy().getArmySubcategory(categoryNumber).getCategoryPointCap()){
            RuleViolationLog.appendRosterRuleViolationLog(roster.getDetachments().get(detachmentNumber).getArmy().getArmySubcategory(categoryNumber).getName() + " Category Point Limit Exceeded.");
        }
    }
}
