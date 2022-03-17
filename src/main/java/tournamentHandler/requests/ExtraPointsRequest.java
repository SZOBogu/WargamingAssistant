package tournamentHandler.requests;

import common.ScorePoints;

public class ExtraPointsRequest {
    private int participantId;
    private ScorePoints scorePoints;

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public ScorePoints getScorePoints() {
        return scorePoints;
    }

    public void setScorePoints(ScorePoints scorePoints) {
        this.scorePoints = scorePoints;
    }
}
