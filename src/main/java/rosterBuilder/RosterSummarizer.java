package rosterBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class RosterSummarizer {
    public static String summarize(Roster roster){
        int cost = RosterCostCalculator.calculateRosterCost(roster);
        int models = ModelCounter.countModels(roster);

        return "TOTAL: " + cost + "/" + roster.getPointCap() + "\tMODELS: " + models;
    }
}
