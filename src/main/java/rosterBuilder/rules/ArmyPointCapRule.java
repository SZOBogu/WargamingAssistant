package rosterBuilder.rules;

import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.pojos.Army;
import rosterBuilder.pojos.Roster;
import rosterBuilder.utility.UnitCounter;

public class ArmyPointCapRule implements Rule{
    private int ruleId;
    private Army army;
    private int pointCap;

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public int getPointCap() {
        return pointCap;
    }

    public void setPointCap(int pointCap) {
        this.pointCap = pointCap;
    }

    public void check(Roster roster) {
        if(roster.getPrimaryArmy().getName().equals(this.army) && roster.getTotalCost() > pointCap){
            throw new RosterBuildingException("Roster Point Limit Exceeded.");
        }
    }
}
