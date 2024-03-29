package scenarioGenerator.responses;

import scenarioGenerator.entities.Deployment;
import scenarioGenerator.entities.MissionList;

import java.util.ArrayList;
import java.util.List;

public class ScenarioInfoResponse {
    private List<Deployment> deploymentList;
    private List<MissionList> missionList;

    public ScenarioInfoResponse(){
        this.deploymentList = new ArrayList<>();
        this.missionList = new ArrayList<>();
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
