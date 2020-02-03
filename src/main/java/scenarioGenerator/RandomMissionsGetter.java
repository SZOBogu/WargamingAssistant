package scenarioGenerator;

import java.util.ArrayList;

public class RandomMissionsGetter {
    public ArrayList<Mission> getMissions(ArrayList<MissionList> missionLists, ArrayList<ArrayList<Boolean>> chosenScenarios){
        BoolToListIndexConverter converter = new BoolToListIndexConverter();
        RandomIndexGenerator generator = new RandomIndexGenerator();
        ArrayList<ArrayList<Integer>> chosenScenarioIndexes = converter.convertList(chosenScenarios);

        ArrayList<Integer> scenarioIndexes = generator.getIndexes(chosenScenarioIndexes);
        ArrayList<Mission> randomMissions = new ArrayList<>();
        for (int i = 0; i < scenarioIndexes.size(); i++) {
            randomMissions.add(missionLists.get(i).get(scenarioIndexes.get(i)));
        }
        return randomMissions;
    }
}