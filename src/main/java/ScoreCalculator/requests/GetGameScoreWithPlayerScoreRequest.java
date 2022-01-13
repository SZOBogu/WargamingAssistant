package ScoreCalculator.requests;

import TournamentHandler.pojos.GamePointList;

public class GetGameScoreWithPlayerScoreRequest {
    private GamePointList gamePointList;

    public GetGameScoreWithPlayerScoreRequest() {
        this.gamePointList = new GamePointList();
    }

    public GamePointList getGamePointList() {
        return gamePointList;
    }

    public void setGamePointList(GamePointList gamePointList) {
        this.gamePointList = gamePointList;
    }
}
