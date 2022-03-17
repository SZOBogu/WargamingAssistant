package scenarioGenerator.utility;

import scenarioGenerator.entities.Deployment;
import scenarioGenerator.requests.ScenarioRequest;

import java.util.ArrayList;
import java.util.List;

public class DeploymentPoolGetter {

    private DeploymentPoolGetter(){}

    public static List<Deployment> getDeploymentPoolList(ScenarioRequest request, List<Deployment> allDeployments) {
        List<Deployment> deploymentPool = new ArrayList<>();

        for(int i=0; i < allDeployments.size(); i++){
            if(request.getDeploymentPool().get(i) > 0){
                for(int j = 0; j < request.getDeploymentPool().get(i); j++)
                deploymentPool.add(new Deployment(allDeployments.get(i)));
            }
        }

        return deploymentPool;
    }
}
