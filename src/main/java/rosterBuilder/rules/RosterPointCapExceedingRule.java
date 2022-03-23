package rosterBuilder.rules;

import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.entities.Roster;
import rosterBuilder.utility.RosterCostCalculator;

public class RosterPointCapExceedingRule implements Rule {
    public void check(Roster roster) {
        if(RosterCostCalculator.calculateRosterCost(roster) > roster.getPointCap()){
            throw new RosterBuildingException("Roster Point Limit Exceeded.");
        }
    }
}
