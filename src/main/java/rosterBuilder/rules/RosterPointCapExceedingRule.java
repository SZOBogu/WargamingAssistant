package rosterBuilder.rules;

import rosterBuilder.pojos.Roster;
import rosterBuilder.utility.RosterCostCalculator;
import rosterBuilder.utility.RuleViolationLog;

public class RosterPointCapExceedingRule implements Rule {
    public void check(Roster roster) {
        if(RosterCostCalculator.calculateRosterCost(roster) > roster.getPointCap()){
            RuleViolationLog.appendRosterRuleViolationLog("Roster Point Limit Exceeded.");
        }
    }
}
