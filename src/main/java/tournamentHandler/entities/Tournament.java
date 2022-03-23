package tournamentHandler.entities;

import scoreCalculator.pojos.ScoringSystem;
import tournamentHandler.enums.TournamentType;
import tournamentHandler.pojos.TournamentStatute;
import rosterBuilder.entities.WargamingSystem;
import rosterBuilder.rules.ArmyPointCapRule;
import rosterBuilder.rules.RosterBuildingRule;
import rosterBuilder.rules.TeamCompositionRule;
import scenarioGenerator.entities.Scenario;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private String name;
    private TournamentStatute statute;
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
    private List<Submission> submissions;

    public Tournament() {
        name = "";
        statute = new TournamentStatute();
        participants  = new ArrayList<>();
        rounds  = new ArrayList<>();
        roundNumber = 0;
        participantLimit = 0;
        pointLimit = 0;
        teamSize = 0;
        gameScoringSystem = new ScoringSystem();
        eventScoringSystem = new ScoringSystem();
        pairingSystem = new PairingSystem();
        scenarios = new ArrayList<>();
        rosterRules = new ArrayList<>();
        armyPointCapRules = new ArrayList<>();
        teamCompositionRules = new ArrayList<>();
        submissions = new ArrayList<>();
    }

    public Tournament(TournamentBuilder builder) {
        name = builder.name;
        statute = builder.statute;
        participants  = builder.participants;
        rounds = builder.rounds;
        roundNumber = builder.roundNumber;
        participantLimit = builder.participantLimit;
        pointLimit = builder.pointLimit;
        teamSize = builder.teamSize;
        gameScoringSystem = builder.gameScoringSystem;
        eventScoringSystem = builder.eventScoringSystem;
        pairingSystem = builder.pairingSystem;
        scenarios = builder.scenarios;
        rosterRules = builder.rosterRules;
        armyPointCapRules = builder.armyPointCapRules;
        teamCompositionRules = builder.teamCompositionRules;
        submissions = builder.submissions;
    }

    public static class TournamentBuilder{
        private String name;
        private TournamentStatute statute;
        private List<Participant> participants = new ArrayList<>();
        private List<Round> rounds = new ArrayList<>();
        private WargamingSystem system;
        private TournamentType type = TournamentType.SINGLE;
        private int roundNumber;
        private int participantLimit;
        private int pointLimit;
        private int teamSize;
        private List<Scenario> scenarios = new ArrayList<>();
        private ScoringSystem gameScoringSystem;
        private ScoringSystem eventScoringSystem;
        private PairingSystem pairingSystem;
        private List<RosterBuildingRule> rosterRules = new ArrayList<>();
        private List<ArmyPointCapRule> armyPointCapRules = new ArrayList<>();
        private List<TeamCompositionRule> teamCompositionRules = new ArrayList<>();
        private List<Submission> submissions = new ArrayList<>();

        public TournamentBuilder(int roundNumber, int teamSize,
                                 ScoringSystem gameScoringSystem, ScoringSystem eventScoringSystem,
                                 PairingSystem pairingSystem){
            this.roundNumber = roundNumber;
            this.teamSize = teamSize;
            this.gameScoringSystem = gameScoringSystem;
            this.eventScoringSystem = eventScoringSystem;
            this.pairingSystem = pairingSystem;
        }

        public TournamentBuilder name(String name){
            this.name = name;
            return this;
        }
        public TournamentBuilder statute(TournamentStatute statute){
            this.statute = statute;
            return this;
        }
        public TournamentBuilder participants(List<Participant> participants){
            this.participants = participants;
            return this;
        }
        public TournamentBuilder rounds(List<Round> rounds){
            this.rounds = rounds;
            return this;
        }
        public TournamentBuilder system(WargamingSystem system){
            this.system = system;
            return this;
        }
        public TournamentBuilder participantLimit(int participantLimit){
            this.participantLimit = participantLimit;
            return this;
        }
        public TournamentBuilder pointLimit(int pointLimit){
            this.pointLimit = pointLimit;
            return this;
        }
        public TournamentBuilder scenarios(List<Scenario> scenarios){
            this.scenarios = scenarios;
            return this;
        }
        public TournamentBuilder rosterRules(List<RosterBuildingRule> rosterRules){
            this.rosterRules = rosterRules;
            return this;
        }
        public TournamentBuilder armyPointCapRules(List<ArmyPointCapRule> armyPointCapRules){
            this.armyPointCapRules = armyPointCapRules;
            return this;
        }
        public TournamentBuilder teamCompositionRules(List<TeamCompositionRule> teamCompositionRules){
            this.teamCompositionRules = teamCompositionRules;
            return this;
        }
        public TournamentBuilder submissions(List<Submission> submissions){
            this.submissions = submissions;
            return this;
        }
        public Tournament build(){
            return new Tournament(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TournamentStatute getStatute() {
        return statute;
    }

    public void setStatute(TournamentStatute statute) {
        this.statute = statute;
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

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
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
}
