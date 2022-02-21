package TournamentHandler.requests;

import ScoreCalculator.pojos.ScoringSystem;
import TournamentHandler.entities.PairingSystem;
import TournamentHandler.entities.Participant;
import TournamentHandler.entities.Round;
import TournamentHandler.enums.TournamentType;
import TournamentHandler.pojos.TournamentStatute;
import rosterBuilder.pojos.WargamingSystem;
import rosterBuilder.rules.ArmyPointCapRule;
import rosterBuilder.rules.RosterBuildingRule;
import rosterBuilder.rules.TeamCompositionRule;
import scenarioGenerator.pojos.Scenario;

import java.util.List;

public class TournamentRequest {
    private int tournamentId;
    private TournamentStatute statute;
    private String name;
    private List<Participant> participants;
    private List<Round> rounds;
    private WargamingSystem system;
    private TournamentType type;
    private int roundNumber;
    private int participantLimit;
    private int pointLimit;
    private int teamSize;
    private List<Scenario> scenarios;
    private ScoringSystem gameScoringSystem;
    private ScoringSystem eventScoringSystem;
    private PairingSystem pairingSystem;
    private List<RosterBuildingRule> rosterRules;
    private List<ArmyPointCapRule> armyPointCapRules;
    private List<TeamCompositionRule> teamCompositionRules;

    public TournamentStatute getStatute() {
        return statute;
    }

    public void setStatute(TournamentStatute statute) {
        this.statute = statute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public WargamingSystem getSystem() {
        return system;
    }

    public void setSystem(WargamingSystem system) {
        this.system = system;
    }

    public TournamentType getType() {
        return type;
    }

    public void setType(TournamentType type) {
        this.type = type;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public int getParticipantLimit() {
        return participantLimit;
    }

    public void setParticipantLimit(int participantLimit) {
        this.participantLimit = participantLimit;
    }

    public int getPointLimit() {
        return pointLimit;
    }

    public void setPointLimit(int pointLimit) {
        this.pointLimit = pointLimit;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    public ScoringSystem getGameScoringSystem() {
        return gameScoringSystem;
    }

    public void setGameScoringSystem(ScoringSystem gameScoringSystem) {
        this.gameScoringSystem = gameScoringSystem;
    }

    public ScoringSystem getEventScoringSystem() {
        return eventScoringSystem;
    }

    public void setEventScoringSystem(ScoringSystem eventScoringSystem) {
        this.eventScoringSystem = eventScoringSystem;
    }

    public PairingSystem getPairingSystem() {
        return pairingSystem;
    }

    public void setPairingSystem(PairingSystem pairingSystem) {
        this.pairingSystem = pairingSystem;
    }

    public List<RosterBuildingRule> getRosterRules() {
        return rosterRules;
    }

    public void setRosterRules(List<RosterBuildingRule> rosterRules) {
        this.rosterRules = rosterRules;
    }

    public List<ArmyPointCapRule> getArmyPointCapRules() {
        return armyPointCapRules;
    }

    public void setArmyPointCapRules(List<ArmyPointCapRule> armyPointCapRules) {
        this.armyPointCapRules = armyPointCapRules;
    }

    public List<TeamCompositionRule> getTeamCompositionRules() {
        return teamCompositionRules;
    }

    public void setTeamCompositionRules(List<TeamCompositionRule> teamCompositionRules) {
        this.teamCompositionRules = teamCompositionRules;
    }
}
