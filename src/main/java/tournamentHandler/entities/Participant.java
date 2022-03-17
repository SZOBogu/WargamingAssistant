package tournamentHandler.entities;

import tournamentHandler.pojos.ScoreList;
import rosterBuilder.pojos.Roster;

public class Participant implements Comparable{
    private int participantId;
    private String name;
    private Roster roster;
    private ScoreList scoreList;

    public Participant() {
    }

    public Participant(Submission submission){
        this.name = submission.getUserEntity().getUsername();
        this.roster = submission.getRoster();
        this.scoreList = new ScoreList();
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }

    public ScoreList getScoreList() {
        return scoreList;
    }

    public void setScoreList(ScoreList scoreList) {
        this.scoreList = scoreList;
    }

    @Override
    public int compareTo(Object o) {
        Participant participant = (Participant)o;
        return this.scoreList.compareTo(participant.getScoreList());
    }
}
