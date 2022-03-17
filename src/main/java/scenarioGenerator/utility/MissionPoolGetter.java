package scenarioGenerator.utility;

import scenarioGenerator.entities.Mission;
import scenarioGenerator.requests.ScenarioRequest;

import java.util.ArrayList;
import java.util.List;

public class MissionPoolGetter {

    private MissionPoolGetter(){}

    public static List<List<Mission>> getMissionPoolList(ScenarioRequest request, List<List<Mission>> allMissionLists){
        List<List<Integer>> missionDupeList = request.getMissionPool();

        List<List<Mission>> missionPool= new ArrayList<>();

        for(int i = 0; i < allMissionLists.size(); i++){
            missionPool.add(new ArrayList<>());
            for(int j = 0; j < allMissionLists.get(i).size(); j++) {
                if (missionDupeList.get(i).get(j) > 0) {
                    missionPool.get(i).add(new Mission(allMissionLists.get(i).get(j)));
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
        return missionPool;
    }
}
