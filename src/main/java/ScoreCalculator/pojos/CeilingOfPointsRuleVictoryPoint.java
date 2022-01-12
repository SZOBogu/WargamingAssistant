package ScoreCalculator.pojos;

import common.ScorePoints;

public class CeilingOfPointsRuleVictoryPoint implements VictoryPointScoringRule {
    private int pointCeiling;

    @Override
    public ScorePoints implementRule(ScorePoints points) {
        if (points.getPoints() > this.pointCeiling){
            points.setPoints(this.pointCeiling);
        }
        return points;
    }

    public int getPointCeiling() {
        return pointCeiling;
    }

    public void setPointCeiling(int pointCeiling) {
        this.pointCeiling = pointCeiling;
    }
}
