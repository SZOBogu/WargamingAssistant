package ScoreCalculator.requests;

import ScoreCalculator.pojos.ScoringSystem;
import scenarioGenerator.pojos.Scenario;

import java.util.ArrayList;
import java.util.List;

public class GetGameScoreWithChecklistRequest {
    private List<List<Boolean>> listOfCheckedObjectivesForHomePlayer;
    private List<List<Boolean>> listOfCheckedObjectivesForAwayPlayer;
    private Scenario scenario;
    private ScoringSystem scoringSystem;

    public GetGameScoreWithChecklistRequest() {
        this.listOfCheckedObjectivesForAwayPlayer = new ArrayList<>();
        this.listOfCheckedObjectivesForHomePlayer = new ArrayList<>();
        this.scenario = new Scenario();
    }

    public List<List<Boolean>> getListOfCheckedObjectivesForHomePlayer() {
        return listOfCheckedObjectivesForHomePlayer;
    }

    public void setListOfCheckedObjectivesForHomePlayer(List<List<Boolean>> listOfCheckedObjectivesForHomePlayer) {
        this.listOfCheckedObjectivesForHomePlayer = listOfCheckedObjectivesForHomePlayer;
    }

    public List<List<Boolean>> getListOfCheckedObjectivesForAwayPlayer() {
        return listOfCheckedObjectivesForAwayPlayer;
    }

    public void setListOfCheckedObjectivesForAwayPlayer(List<List<Boolean>> listOfCheckedObjectivesForAwayPlayer) {
        this.listOfCheckedObjectivesForAwayPlayer = listOfCheckedObjectivesForAwayPlayer;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public ScoringSystem getScoringSystem() {
        return scoringSystem;
    }

    public void setScoringSystem(ScoringSystem scoringSystem) {
        this.scoringSystem = scoringSystem;
    }
}
