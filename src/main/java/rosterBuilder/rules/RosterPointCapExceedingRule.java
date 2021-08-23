package rosterBuilder.rules;

import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.pojos.Roster;
import rosterBuilder.utility.RosterCostCalculator;
import rosterBuilder.utility.RuleViolationLog;

public class RosterPointCapExceedingRule implements Rule {
    public void check(Roster roster) {
        if(RosterCostCalculator.calculateRosterCost(roster) > roster.getPointCap()){
            throw new RosterBuildingException("Roster Point Limit Exceeded.");
        }
    }
}
