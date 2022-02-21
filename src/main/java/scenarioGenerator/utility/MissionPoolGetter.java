package scenarioGenerator.utility;

import scenarioGenerator.pojos.Mission;
import scenarioGenerator.requests.ScenarioRequest;

import java.util.ArrayList;
import java.util.List;

public class MissionPoolGetter {

    private MissionPoolGetter(){}

    public static List<List<Mission>> getObjectivePackPoolList(ScenarioRequest request, List<List<Mission>> allObjectivePacks){
        List<List<Integer>> objectivePackDupeList = request.getMissionPool();

        List<List<Mission>> objectivePackPool= new ArrayList<>();

        for(int i = 0; i < allObjectivePacks.size(); i++){
            objectivePackPool.add(new ArrayList<>());
            for(int j = 0; j < allObjectivePacks.get(i).size(); j++) {
                if (objectivePackDupeList.get(i).get(j) > 0) {
                    objectivePackPool.get(i).add(new Mission(allObjectivePacks.get(i).get(j)));
                }
            }
        }
        /*
        for(int i=0; i < allDeployments.size(); i++){
            if(request.getDeploymentPool().get(i) > 0){
                for(int j = 0; j < request.getDeploymentPool().get(i); j++)
                deploymentPool.add(new Deployment(allDeployments.get(i)));
            }
        }
        */
        return objectivePackPool;
    }
}
