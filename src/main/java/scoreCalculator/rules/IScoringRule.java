package scoreCalculator.rules;

import common.ScorePoints;

import java.util.List;

public interface IScoringRule {
    List<ScorePoints> implementRule(List<ScorePoints> points);
}
