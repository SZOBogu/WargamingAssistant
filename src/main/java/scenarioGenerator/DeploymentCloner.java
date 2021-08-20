package scenarioGenerator;

import java.util.ArrayList;

public class DeploymentCloner {
    public static ArrayList<Deployment> cloneDeployments(ArrayList<Deployment> deployments, int quantity){
        if(quantity < 2)
            return deployments;
        else {
            ArrayList<Deployment> result = new ArrayList<>();
            for (Deployment deployment : deployments) {
                for (int j = 0; j < quantity; j++) {
                    result.add(new Deployment(deployment));
                }
            }
            return result;
        }
    }
}
