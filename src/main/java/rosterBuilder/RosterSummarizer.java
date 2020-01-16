package rosterBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class RosterSummarizer {
    public String summarize(Roster roster){
        RosterCostCalculator rosterCostCalculator = new RosterCostCalculator();
        ModelCounter modelCounter = new ModelCounter();

        int cost = rosterCostCalculator.calculateRosterCost(roster);
        int models = modelCounter.countModels(roster);

        return "TOTAL: " + cost + "/" + roster.getPointCap() + "\tMODELS: " + models;
    }
}
