package TournamentHandler.pojos;

import TournamentHandler.pojos.PlayerScore;

public class GameScore {
    private PlayerScore homePlayerScore;
    private PlayerScore awayPlayersScore;

    public PlayerScore getHomePlayerScore() {
        return homePlayerScore;
    }

    public void setHomePlayerScore(PlayerScore homePlayerScore) {
        this.homePlayerScore = homePlayerScore;
    }

    public PlayerScore getAwayPlayersScore() {
        return awayPlayersScore;
    }

    public void setAwayPlayersScore(PlayerScore awayPlayersScore) {
        this.awayPlayersScore = awayPlayersScore;
    }
}
