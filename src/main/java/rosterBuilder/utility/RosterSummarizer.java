package rosterBuilder.utility;

import rosterBuilder.pojos.Roster;

public class RosterSummarizer {

    private RosterSummarizer(){}

    public static String summarize(Roster roster){
        int cost = RosterCostCalculator.calculateRosterCost(roster);
        int models = ModelCounter.countModels(roster);

        return "TOTAL: " + cost + "/" + roster.getPointCap() + "\tMODELS: " + models;
    }
}
