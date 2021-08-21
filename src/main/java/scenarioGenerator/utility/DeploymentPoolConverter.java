package scenarioGenerator.utility;

import rosterBuilder.pojos.WargamingSystem;
import scenarioGenerator.pojos.Deployment;
import scenarioGenerator.requests.ScenarioRequest;

import java.util.ArrayList;
import java.util.List;

public class DeploymentPoolConverter {

    private DeploymentPoolConverter(){}

    public static List<Deployment> getDeploymentPoolList(ScenarioRequest request, WargamingSystem system){
        List<Integer> deploymentPoolIndexes = BoolListToIndexListConverter.convertList(request.getDeploymentBooleanPool());
        List<Deployment> deploymentPool = new ArrayList<>();
        List<Deployment> allDeployments = system.getDeployments();

        for(int i=0; i < allDeployments.size(); i++){
            if(deploymentPoolIndexes.contains(i)){
                deploymentPool.add(allDeployments.get(i));
            }
        }

        return deploymentPool;
    }
}
