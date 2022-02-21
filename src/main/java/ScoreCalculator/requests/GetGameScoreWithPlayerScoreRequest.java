package ScoreCalculator.requests;

import ScoreCalculator.pojos.ScoringSystem;
import TournamentHandler.pojos.GamePointList;
import common.ScorePoints;

import java.util.List;

public class GetGameScoreWithPlayerScoreRequest {
    private List<ScorePoints> homeScoreList;
    private List<ScorePoints> awayScoreList;
    private ScoringSystem scoringSystem;

    public List<ScorePoints> getHomeScoreList() {
        return homeScoreList;
    }

    public void setHomeScoreList(List<ScorePoints> homeScoreList) {
        this.homeScoreList = homeScoreList;
    }

    public List<ScorePoints> getAwayScoreList() {
        return awayScoreList;
    }

    public void setAwayScoreList(List<ScorePoints> awayScoreList) {
        this.awayScoreList = awayScoreList;
    }

    public ScoringSystem getScoringSystem() {
        return scoringSystem;
    }

    public void setScoringSystem(ScoringSystem scoringSystem) {
        this.scoringSystem = scoringSystem;
    }
}
