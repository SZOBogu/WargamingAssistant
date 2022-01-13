package TournamentHandler.pojos;

import common.ScorePoints;

import java.util.ArrayList;
import java.util.List;

public class PlayerScore {
    private List<ScorePoints> points;

    public PlayerScore() {
        this.points = new ArrayList<>();
    }

    public List<ScorePoints> getPoints() {
        return points;
    }

    public void setPoints(List<ScorePoints> points) {
        this.points = points;
    }
}
