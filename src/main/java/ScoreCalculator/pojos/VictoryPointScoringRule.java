package ScoreCalculator.pojos;

import TournamentHandler.enums.ScorePointType;
import common.ScorePoints;

import java.util.List;

public abstract class VictoryPointScoringRule implements IVictoryPointScoringRule{
    protected int ruleValue;
    private ScorePointType inputType;

    @Override
    public List<ScorePoints> implementRule(List<ScorePoints> points) {
        return null;
    }

    public int getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(int ruleValue) {
        this.ruleValue = ruleValue;
    }

    public ScorePointType getInputType() {
        return inputType;
    }

    public void setInputType(ScorePointType inputType) {
        this.inputType = inputType;
    }
}
