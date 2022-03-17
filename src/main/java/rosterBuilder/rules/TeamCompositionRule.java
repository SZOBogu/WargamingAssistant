package rosterBuilder.rules;

import tournamentHandler.entities.Team;
import rosterBuilder.pojos.Army;

public class TeamCompositionRule implements Rule{
    private int ruleId;
    private Army army;
    private int quantity;
    private boolean primaryArmyRule;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isPrimaryArmyRule() {
        return primaryArmyRule;
    }

    public void setPrimaryArmyRule(boolean primaryArmyRule) {
        this.primaryArmyRule = primaryArmyRule;
    }

    public void check(Team team) {
        assert true;
    }
}
