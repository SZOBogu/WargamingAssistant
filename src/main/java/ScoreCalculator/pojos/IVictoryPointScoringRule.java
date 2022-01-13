package ScoreCalculator.pojos;

import common.ScorePoints;

import java.util.List;

public interface IVictoryPointScoringRule {
    List<ScorePoints> implementRule(List<ScorePoints> points);
}
