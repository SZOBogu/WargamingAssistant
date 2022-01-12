package ScoreCalculator.pojos;

import ScoreCalculator.helpers.ScoringPointOfHigherTypeGetter;
import common.ScorePoints;

public class PointsForDifferenceOfLowerTypeRule implements VictoryPointScoringRule{
    private int pointDifferenceToChangeScore;

    @Override
    public ScorePoints implementRule(ScorePoints points) {
        ScorePoints scorePointsToReturn = new ScorePoints();
        scorePointsToReturn.setType(ScoringPointOfHigherTypeGetter.getPointOfHigherType(points.getType()));
        scorePointsToReturn.setPoints(points.getPoints()/(pointDifferenceToChangeScore + 1));

        return scorePointsToReturn;
    }

    public int getPointDifferenceToChangeScore() {
        return pointDifferenceToChangeScore;
    }

    public void setPointDifferenceToChangeScore(int pointDifferenceToChangeScore) {
        this.pointDifferenceToChangeScore = pointDifferenceToChangeScore;
    }
}
