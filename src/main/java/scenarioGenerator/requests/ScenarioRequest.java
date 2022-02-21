package scenarioGenerator.requests;

import java.util.List;

public class ScenarioRequest {
    private List<Integer> deploymentPool;
    private List<List<Integer>> missionPool;
    private int scenariosToGenerate;

    private boolean duplicateMissionsFreely;
    private boolean duplicateDeploymentsFreely;
    private boolean oneMissionPool;

    public List<Integer> getDeploymentPool() {
        return deploymentPool;
    }

    public void setDeploymentPool(List<Integer> deploymentPool) {
        this.deploymentPool = deploymentPool;
    }

    public List<List<Integer>> getMissionPool() {
        return missionPool;
    }

    public void setMissionPool(List<List<Integer>> missionPool) {
        this.missionPool = missionPool;
    }

    public int getScenariosToGenerate() {
        return scenariosToGenerate;
    }

    public void setScenariosToGenerate(int scenariosToGenerate) {
        this.scenariosToGenerate = scenariosToGenerate;
    }

    public boolean isDuplicateMissionsFreely() {
        return duplicateMissionsFreely;
    }

    public void setDuplicateMissionsFreely(boolean duplicateMissionsFreely) {
        this.duplicateMissionsFreely = duplicateMissionsFreely;
    }

    public boolean isDuplicateDeploymentsFreely() {
        return duplicateDeploymentsFreely;
    }

    public void setDuplicateDeploymentsFreely(boolean duplicateDeploymentsFreely) {
        this.duplicateDeploymentsFreely = duplicateDeploymentsFreely;
    }

    public boolean isOneMissionPool() {
        return oneMissionPool;
    }

    public void setOneMissionPool(boolean oneMissionPool) {
        this.oneMissionPool = oneMissionPool;
    }

    @Override
    public String toString() {
        return "ScenarioRequest{" +
                "deploymentPool=" + deploymentPool +
                ", missionPool=" + missionPool +
                ", scenariosToGenerate=" + scenariosToGenerate +
                ", duplicateMissionsFreely=" + duplicateMissionsFreely +
                ", duplicateDeploymentsFreely=" + duplicateDeploymentsFreely +
                ", oneMissionPool=" + oneMissionPool +
                '}';
    }
}
