package tournamentHandler.entities;

import scoreCalculator.pojos.ScoreList;

public class Game {
    private int gameId;
    private Team homeTeam;
    private Team awayTeam;
    private Participant homePlayer;
    private Participant awayPlayer;

    private ScoreList homeScore;
    private ScoreList awayScore;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public ScoreList getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(ScoreList homeScore) {
        this.homeScore = homeScore;
    }

    public ScoreList getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(ScoreList awayScore) {
        this.awayScore = awayScore;
    }

    public Participant getHomePlayer() {
        return homePlayer;
    }

    public void setHomePlayer(Participant homePlayer) {
        this.homePlayer = homePlayer;
    }

    public Participant getAwayPlayer() {
        return awayPlayer;
    }

    public void setAwayPlayer(Participant awayPlayer) {
        this.awayPlayer = awayPlayer;
    }
}
