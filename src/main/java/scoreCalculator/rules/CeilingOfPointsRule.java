package scoreCalculator.rules;

import common.ScorePoints;

import java.util.List;

public class CeilingOfPointsRule extends ScoringRule {
    @Override
    public List<ScorePoints> implementRule(List<ScorePoints> points) {
        for(ScorePoints scorePoints : points) {
            if (scorePoints.getType() == this.getInputType()) {
                if (scorePoints.getPoints() > this.getRuleValue()) {
                    scorePoints.setPoints(this.getRuleValue());
                    break;
                }
            }
        }
        return points;
    }
}
