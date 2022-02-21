package rosterBuilder.utility;

import rosterBuilder.rules.RosterBuildingRule;
import rosterBuilder.rules.UnitBuildingRule;

import java.util.List;

public class RuleMerger {
    private RuleMerger(){}

    public static List<RosterBuildingRule> mergeRosterRules(List<RosterBuildingRule> baseRules, List<RosterBuildingRule> eventRules){
        baseRules.addAll(eventRules);
        return baseRules;
    }

    public static List<UnitBuildingRule> mergeUnitRules(List<UnitBuildingRule> baseRules, List<UnitBuildingRule> eventRules){
        baseRules.addAll(eventRules);
        return baseRules;
    }
}
