package common;

import TournamentHandler.enums.ScorePointType;

public class ScorePoints {
    private int points;
    private ScorePointType type;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ScorePointType getType() {
        return type;
    }

    public void setType(ScorePointType type) {
        this.type = type;
    }
}
