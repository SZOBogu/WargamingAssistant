package scenarioGenerator;

import java.util.ArrayList;

public class MissionAndDeploymentCloner {
    public ArrayList<Mission> cloneMissions(ArrayList<Mission> missions, int quantity){
        if(quantity < 2)
            return missions;
        else {
            ArrayList<Mission> result = new ArrayList<>();
            for (Mission mission : missions) {
                for (int j = 0; j < quantity; j++) {
                    result.add(new Mission(mission));
                }
            }
            return result;
        }
    }

    public ArrayList<Deployment> cloneDeployments(ArrayList<Deployment> deployments, int quantity){
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
