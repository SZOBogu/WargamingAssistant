package scoreCalculator.calculatingAlgorithms;

import tournamentHandler.enums.ScorePointType;
import common.ScorePoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyPrimaryPointsAlgorithm implements ScoringAlgorithm{
    @Override
    public List<ScorePoints> calculateGameScore(ScorePoints homePlayerScore, ScorePoints awayPlayerScore) {
        homePlayerScore.setType(ScorePointType.GAME_POINT);
        awayPlayerScore.setType(ScorePointType.GAME_POINT);
        return new ArrayList<>(Arrays.asList(homePlayerScore, awayPlayerScore));
    }
}
