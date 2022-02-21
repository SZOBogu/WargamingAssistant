package scenarioGenerator.requests;

import java.util.List;

public class ScenarioRequest {
    private List<Integer> deploymentPool;
    private List<List<Integer>> objectivePackPool;
    private int scenariosToGenerate;

    private boolean duplicateObjectivePacksFreely;
    private boolean duplicateDeploymentsFreely;

    public List<Integer> getDeploymentPool() {
        return deploymentPool;
    }

    public void setDeploymentPool(List<Integer> deploymentPool) {
        this.deploymentPool = deploymentPool;
    }

    public List<List<Integer>> getObjectivePackPool() {
        return objectivePackPool;
    }

    public void setObjectivePackPool(List<List<Integer>>objectivePackPool) {
        this.objectivePackPool = objectivePackPool;
    }

    public int getScenariosToGenerate() {
        return scenariosToGenerate;
    }

    public void setScenariosToGenerate(int scenariosToGenerate) {
        this.scenariosToGenerate = scenariosToGenerate;
    }

    public boolean isDuplicateObjectivePacksFreely() {
        return duplicateObjectivePacksFreely;
    }

    public void setDuplicateObjectivePacksFreely(boolean duplicateObjectivePacksFreely) {
        this.duplicateObjectivePacksFreely = duplicateObjectivePacksFreely;
    }

    public boolean isDuplicateDeploymentsFreely() {
        return duplicateDeploymentsFreely;
    }

    public void setDuplicateDeploymentsFreely(boolean duplicateDeploymentsFreely) {
        this.duplicateDeploymentsFreely = duplicateDeploymentsFreely;
    }

/*
{
	"deploymentBooleanPool": [false, true, false, true, false, true],
	"missionBooleanPool": [[false, true, false, true, false, true],[false, true, false, true, false, true]],
	"scenariosToGenerate": 3,
	"canDuplicateMissions": true,
	"getCanDuplicateDeployments": true,
	"duplicateMissionsFreely": false,
	"duplicateDeploymentsFreely": false,
	"duplicateDeploymentsQuantity": 2,
	"duplicateMissionsQuantity": 2
}
 */

    @Override
    public String toString() {
        return "ScenarioRequest{" +
                "deploymentPool=" + deploymentPool +
                ", objectivePackPool=" + objectivePackPool +
                ", scenariosToGenerate=" + scenariosToGenerate +
                ", duplicateObjectivePacksFreely=" + duplicateObjectivePacksFreely +
                ", duplicateDeploymentsFreely=" + duplicateDeploymentsFreely +
                '}';
    }
}
