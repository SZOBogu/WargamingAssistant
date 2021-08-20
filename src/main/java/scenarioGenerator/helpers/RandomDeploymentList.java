package scenarioGenerator.helpers;

import common.RandomArrayElementsGetter;
import scenarioGenerator.pojos.Deployment;
import scenarioGenerator.requests.ScenarioRequest;

import java.util.List;

public class RandomDeploymentList {
    public static List<Deployment> generate(ScenarioRequest request, List<Deployment> deploymentPool) {
        int scenariosToGenerate = request.getScenariosToGenerate();

        if (request.isGetCanDuplicateDeployments() && request.isDuplicateDeploymentsFreely()) {
            return generateWithAnyReps(deploymentPool, scenariosToGenerate);
        }
        else if(request.isGetCanDuplicateDeployments() && !request.isDuplicateDeploymentsFreely() && request.getDuplicateMissionsQuantity() > 1) {
            return generateWithReps(deploymentPool, scenariosToGenerate, request.getDuplicateDeploymentsQuantity());
        }
        else
            return generateWithoutReps(deploymentPool, scenariosToGenerate);
    }
    private static List<Deployment> generateWithoutReps(List<Deployment> deploymentPool, int scenariosToGenerate){
        return RandomArrayElementsGetter.randomArrayElementsWithoutReps(deploymentPool, scenariosToGenerate);
    }
    private static List<Deployment> generateWithReps(List<Deployment> deploymentPool, int scenariosToGenerate, int reps){
        return RandomArrayElementsGetter.randomArrayElementsWithReps(deploymentPool,
                reps,
                scenariosToGenerate);

    }
    private static List<Deployment> generateWithAnyReps(List<Deployment> deploymentPool, int scenariosToGenerate){
        return RandomArrayElementsGetter.randomArrayElementsWithAnyReps(deploymentPool,
                scenariosToGenerate);
    }
}


