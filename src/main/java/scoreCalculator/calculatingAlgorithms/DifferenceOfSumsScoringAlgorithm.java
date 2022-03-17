package scoreCalculator.calculatingAlgorithms;

import tournamentHandler.enums.ScorePointType;
import common.ScorePoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifferenceOfSumsScoringAlgorithm implements ScoringAlgorithm {
    @Override
    public List<ScorePoints> calculateGameScore(ScorePoints homePlayerScore, ScorePoints awayPlayerScore) {
        ScorePoints homePlayerEndScore = new ScorePoints();
        ScorePoints awayPlayerEndScore = new ScorePoints();

        homePlayerEndScore.setType(ScorePointType.GAME_POINT);
        awayPlayerEndScore.setType(ScorePointType.GAME_POINT);

        int difference = homePlayerScore.getPoints() - awayPlayerScore.getPoints();

        if(difference > 0){
            homePlayerEndScore.setPoints(difference);
            awayPlayerEndScore.setPoints(0);
        }
        else{
            homePlayerEndScore.setPoints(0);
            awayPlayerEndScore.setPoints(Math.abs(difference));
        }

        return new ArrayList<>(Arrays.asList(homePlayerEndScore, awayPlayerEndScore));
    }
}
