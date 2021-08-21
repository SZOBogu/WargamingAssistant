package rosterBuilder.rules;

import rosterBuilder.pojos.Roster;
import rosterBuilder.utility.RosterCostCalculator;
import rosterBuilder.utility.RuleViolationLog;

public class CategoryPointCapExceedRule implements Rule {
    public void check(Roster roster, int detachmentNumber, int categoryNumber) {
        if(RosterCostCalculator.calculateCategoryCost(
                roster,detachmentNumber, categoryNumber) > roster.getDetachments().
                get(detachmentNumber).getArmy().getArmySubcategory(categoryNumber).getCategoryPointCap()){
            RuleViolationLog.appendRosterRuleViolationLog(
                    roster.getDetachments().get(detachmentNumber).getArmy().
                            getArmySubcategory(categoryNumber).getName() + " Category Point Limit Exceeded.");
        }
    }
}
