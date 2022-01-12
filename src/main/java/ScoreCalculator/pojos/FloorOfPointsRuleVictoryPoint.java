package ScoreCalculator.pojos;

import common.ScorePoints;

public class FloorOfPointsRuleVictoryPoint implements VictoryPointScoringRule {
    private int pointFloor;

    @Override
    public ScorePoints implementRule(ScorePoints points) {
        if (points.getPoints() < pointFloor){
            points.setPoints(pointFloor);
        }
        return points;
    }

    public int getPointFloor() {
        return pointFloor;
    }

    public void setPointFloor(int pointFloor) {
        this.pointFloor = pointFloor;
    }
}
