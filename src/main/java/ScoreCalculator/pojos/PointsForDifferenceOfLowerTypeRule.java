package ScoreCalculator.pojos;

import ScoreCalculator.helpers.ScorePointAdder;
import ScoreCalculator.helpers.ScoringPointOfHigherTypeGetter;
import common.ScorePoints;

import java.util.List;

public class PointsForDifferenceOfLowerTypeRule extends VictoryPointScoringRule {
    @Override
    public List<ScorePoints> implementRule(List<ScorePoints> points) {
        for(ScorePoints scorePoints : points) {
            if(scorePoints.getType() == this.getInputType())
                ScorePointAdder.addPoints(points, ScoringPointOfHigherTypeGetter.getPointOfHigherType(scorePoints.getType()), scorePoints.getPoints() / (this.getRuleValue() + 1));
        }
        return points;
    }
}
