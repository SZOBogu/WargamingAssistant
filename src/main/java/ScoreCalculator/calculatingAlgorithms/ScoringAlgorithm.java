package ScoreCalculator.calculatingAlgorithms;

import common.ScorePoints;

import java.util.List;

public interface ScoringAlgorithm {
    List<ScorePoints> calculateGameScore(ScorePoints homePlayerScore, ScorePoints awayPlayerScore);
}
