package ScoreCalculator.pojos;

import common.ScorePoints;

public interface VictoryPointScoringRule {
    public ScorePoints implementRule(ScorePoints points);
}
