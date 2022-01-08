package scenarioGenerator.responses;

import rosterBuilder.pojos.WargamingSystem;
import scenarioGenerator.pojos.Deployment;
import scenarioGenerator.pojos.MissionList;

import java.util.ArrayList;
import java.util.List;

public class ScenarioInfoResponse {
    private String gameName;
    private List<Deployment> deploymentList;
    private List<MissionList> missionList;

    public ScenarioInfoResponse(){
        this.gameName = "";
        this.deploymentList = new ArrayList<>();
        this.missionList = new ArrayList<>();
    }

    public ScenarioInfoResponse(WargamingSystem wargamingSystem) {
        this.gameName = wargamingSystem.getName();
        this.deploymentList = wargamingSystem.getDeployments();
        this.missionList = wargamingSystem.getMissions();
    }


    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public List<Deployment> getDeploymentList() {
        return deploymentList;
    }

    public void setDeploymentList(List<Deployment> deploymentList) {
        this.deploymentList = deploymentList;
    }

    public List<MissionList> getMissionList() {
        return missionList;
    }

    public void setMissionList(List<MissionList> missionList) {
        this.missionList = missionList;
    }
}
