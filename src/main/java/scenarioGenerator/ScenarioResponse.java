package scenarioGenerator;

import common.ArrayOrderMixer;

import java.util.List;

public class ScenarioResponse {
    private List<Deployment> deploymentList;
    private List<List<Mission>> missionList;

    public void setDeploymentList(List<Deployment> deploymentList) {
        this.deploymentList = deploymentList;
    }

    public void setMissionList(List<List<Mission>> missionList) {
        this.missionList = missionList;
    }
}
