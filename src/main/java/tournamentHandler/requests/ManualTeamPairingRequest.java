package tournamentHandler.requests;

import tournamentHandler.entities.Participant;

public class ManualTeamPairingRequest {
    private Participant homeParticipant;
    private Participant awayParticipant;
    private int tournamentId;
    private int homeTeamId;
    private int awayTeamId;
    private int matchId;

    public Participant getHomeParticipant() {
        return homeParticipant;
    }

    public void setHomeParticipant(Participant homeParticipant) {
        this.homeParticipant = homeParticipant;
    }

    public Participant getAwayParticipant() {
        return awayParticipant;
    }

    public void setAwayParticipant(Participant awayParticipant) {
        this.awayParticipant = awayParticipant;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }
}
