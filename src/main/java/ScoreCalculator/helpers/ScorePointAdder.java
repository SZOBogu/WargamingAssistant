package ScoreCalculator.helpers;

import TournamentHandler.enums.ScorePointType;
import common.ScorePoints;

import java.util.ArrayList;
import java.util.List;

public class ScorePointAdder {
    private ScorePointAdder(){}

    public static List<ScorePoints> addPointsTogether(List<ScorePoints> scoreList){
        ScorePointType[] types = ScorePointType.values();
        List<ScorePoints> totalScores = new ArrayList<>();

        for(ScorePointType type : types){
            ScorePoints tempPoints = new ScorePoints();
            tempPoints.setType(type);
            totalScores.add(tempPoints);
        }

        for(ScorePoints scorePoints : scoreList) {
            for (ScorePoints scorePointsOfType : totalScores) {
                if (scorePointsOfType.getType() == scorePoints.getType()) {
                    scorePointsOfType.setPoints(scorePointsOfType.getPoints() + scorePoints.getPoints());
                }
            }
        }

        return totalScores;
    }

    public static List<ScorePoints> addPoints(List<ScorePoints> scorePoints, ScorePointType type, int quantity){
        ScorePoints temp = new ScorePoints();
        temp.setPoints(quantity);
        temp.setType(type);
        scorePoints.add(temp);

        return ScorePointAdder.addPointsTogether(scorePoints);
    }
}
