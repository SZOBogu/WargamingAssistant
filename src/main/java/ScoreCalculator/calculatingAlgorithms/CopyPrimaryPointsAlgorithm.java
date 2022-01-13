package ScoreCalculator.calculatingAlgorithms;

import common.ScorePoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyPrimaryPointsAlgorithm implements ScoringAlgorithm{
    @Override
    public List<ScorePoints> calculateGameScore(ScorePoints homePlayerScore, ScorePoints awayPlayerScore) {
        return new ArrayList<>(Arrays.asList(homePlayerScore, awayPlayerScore));
    }
}
