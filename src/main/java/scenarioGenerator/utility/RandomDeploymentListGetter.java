package scenarioGenerator.utility;

import common.RandomArrayElementsGetter;
import scenarioGenerator.entities.Deployment;
import scenarioGenerator.requests.ScenarioRequest;

import java.util.List;

public class RandomDeploymentListGetter {

    private RandomDeploymentListGetter(){}

    public static List<Deployment> generate(ScenarioRequest request, List<Deployment> deploymentPool) {
        int scenariosToGenerate = request.getScenariosToGenerate();

        if (request.isDuplicateDeploymentsFreely()) {
            return generateWithAnyReps(deploymentPool, scenariosToGenerate);
        }
        else
            return generateWithoutReps(deploymentPool, scenariosToGenerate);
    }
    private static List<Deployment> generateWithoutReps(List<Deployment> deploymentPool, int scenariosToGenerate){
        return RandomArrayElementsGetter.randomArrayElementsWithoutReps(deploymentPool, scenariosToGenerate);
    }
    private static List<Deployment> generateWithAnyReps(List<Deployment> deploymentPool, int scenariosToGenerate){
        return RandomArrayElementsGetter.randomArrayElementsWithAnyReps(deploymentPool,
                scenariosToGenerate);
    }
}




