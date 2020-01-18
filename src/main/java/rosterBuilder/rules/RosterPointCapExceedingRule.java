package rosterBuilder.rules;

import rosterBuilder.Roster;
import rosterBuilder.RosterCostCalculator;
import rosterBuilder.RuleViolationLog;

public class RosterPointCapExceedingRule implements Rule {
    //TODO:test
    public void check(Roster roster) {
        RosterCostCalculator rosterCostCalculator = new RosterCostCalculator();
        if(rosterCostCalculator.calculateRosterCost(roster) > roster.getPointCap()){
            RuleViolationLog.appendUnitRuleViolationLog("");
        }
    }
}
