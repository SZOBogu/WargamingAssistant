package ScoreCalculator.requests;

import scenarioGenerator.pojos.Scenario;

import java.util.ArrayList;
import java.util.List;

public class GetGameScoreWithChecklistRequest {
    private List<Boolean> listOfCheckedObjectivesForHomePlayer;
    private List<Boolean> listOfCheckedObjectivesForAwayPlayer;
    private Scenario scenario;

    public GetGameScoreWithChecklistRequest() {
        this.listOfCheckedObjectivesForAwayPlayer = new ArrayList<>();
        this.listOfCheckedObjectivesForHomePlayer = new ArrayList<>();
        this.scenario = new Scenario();
    }

    public List<Boolean> getListOfCheckedObjectivesForHomePlayer() {
        return listOfCheckedObjectivesForHomePlayer;
    }

    public void setListOfCheckedObjectivesForHomePlayer(List<Boolean> listOfCheckedObjectivesForHomePlayer) {
        this.listOfCheckedObjectivesForHomePlayer = listOfCheckedObjectivesForHomePlayer;
    }

    public List<Boolean> getListOfCheckedObjectivesForAwayPlayer() {
        return listOfCheckedObjectivesForAwayPlayer;
    }

    public void setListOfCheckedObjectivesForAwayPlayer(List<Boolean> listOfCheckedObjectivesForAwayPlayer) {
        this.listOfCheckedObjectivesForAwayPlayer = listOfCheckedObjectivesForAwayPlayer;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}
