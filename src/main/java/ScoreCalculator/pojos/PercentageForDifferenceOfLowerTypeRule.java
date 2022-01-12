package ScoreCalculator.pojos;

import common.ScorePoints;

public class PercentageForDifferenceOfLowerTypeRule implements VictoryPointScoringRule{
    private int percentage;
    private int rosterPointCap;

    @Override
    public ScorePoints implementRule(ScorePoints points) {
        int scoreDifference = (rosterPointCap * percentage)/100;
        System.out.println("scoreDifference: " + scoreDifference + "\n");

        PointsForDifferenceOfLowerTypeRule differenceRule = new PointsForDifferenceOfLowerTypeRule();
        differenceRule.setPointDifferenceToChangeScore(scoreDifference);

        ScorePoints scorePointsToReturn = differenceRule.implementRule(points);

        return scorePointsToReturn;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getRosterPointCap() {
        return rosterPointCap;
    }

    public void setRosterPointCap(int rosterPointCap) {
        this.rosterPointCap = rosterPointCap;
    }
}
