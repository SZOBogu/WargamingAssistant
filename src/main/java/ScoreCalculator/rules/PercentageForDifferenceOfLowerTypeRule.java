package ScoreCalculator.rules;

import common.ScorePoints;

import java.util.List;

public class PercentageForDifferenceOfLowerTypeRule extends ScoringRule {
    private int rosterPointCap;

    @Override
    public List<ScorePoints> implementRule(List<ScorePoints> points) {
        int scoreDifference = (rosterPointCap * this.getRuleValue())/100;

        PointsForDifferenceOfLowerTypeRule differenceRule = new PointsForDifferenceOfLowerTypeRule();
        differenceRule.setRuleValue(scoreDifference);
        differenceRule.implementRule(points);

        return points;
    }

    public int getRosterPointCap() {
        return rosterPointCap;
    }

    public void setRosterPointCap(int rosterPointCap) {
        this.rosterPointCap = rosterPointCap;
    }
}
