package ScoreCalculator.helpers;

import TournamentHandler.enums.ScorePointType;
import common.ScorePoints;

import java.util.List;

public class SumOfScorePointsOfTypeGetter {
    private SumOfScorePointsOfTypeGetter(){}

    public static ScorePoints getSumOfPointsOfType(List<ScorePoints> scorePoints, ScorePointType type){
        scorePoints = ScorePointAdder.addPointsTogether(scorePoints);
        ScorePoints tempScorePoints = new ScorePoints();
        tempScorePoints.setType(type);
        for(ScorePoints points : scorePoints){
            if(points.getType() == type){
                return points;
            }
        }
        return tempScorePoints;
    }
}
