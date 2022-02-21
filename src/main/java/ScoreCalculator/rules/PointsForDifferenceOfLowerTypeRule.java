package ScoreCalculator.rules;

import ScoreCalculator.helpers.ScorePointAdder;
import ScoreCalculator.helpers.ScoringPointOfHigherTypeGetter;
import common.ScorePoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointsForDifferenceOfLowerTypeRule extends ScoringRule {
    @Override
    public List<ScorePoints> implementRule(List<ScorePoints> points) {
        ScorePoints pointsToAdd = new ScorePoints();
        pointsToAdd.setType(ScoringPointOfHigherTypeGetter.getPointOfHigherType(this.getInputType()));

        if(!points.isEmpty()){
            for(ScorePoints scorePoints : points) {
                if(scorePoints.getType() == this.getInputType())
                    pointsToAdd.setPoints(pointsToAdd.getPoints() + scorePoints.getPoints());
            }

            ScorePointAdder.addPoints(points, pointsToAdd.getType(), pointsToAdd.getPoints());

            return points;
        }
        else{
            return new ArrayList<>(Arrays.asList(pointsToAdd));
        }
    }
}
