package scenarioGenerator.utility;

import rosterBuilder.pojos.WargamingSystem;
import scenarioGenerator.pojos.Mission;
import scenarioGenerator.pojos.MissionList;
import scenarioGenerator.requests.ScenarioRequest;

import java.util.ArrayList;
import java.util.List;

public class MissionPoolConverter {

    private MissionPoolConverter(){}

    public static List<List<Mission>> getMissionPoolList(ScenarioRequest request, WargamingSystem system){
        List<List<Integer>> missionPoolIndexes = BoolListToIndexListConverter.convert2dList(request.getMissionBooleanPool());

        List<List<Mission>> missionPool= new ArrayList<>();

        List<MissionList> allMissions = system.getMissions();

        for(int i=0; i < allMissions.size(); i++){
            missionPool.add(new ArrayList<>());
            for(int j=0; j < allMissions.get(i).size(); j++) {
                if (missionPoolIndexes.get(i).contains(j)) {
                    missionPool.get(i).add(allMissions.get(i).get(j));
                }
            }
        }

        return missionPool;
    }
}
