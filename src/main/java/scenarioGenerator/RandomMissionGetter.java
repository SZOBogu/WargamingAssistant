package scenarioGenerator;

import common.Dice;

import java.util.ArrayList;

public class RandomMissionGetter {
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

    public Mission getMission (MissionList missionList){
        Dice dice = new Dice(missionList.size() - 1);
        return missionList.get(dice.roll());
    }

    public Mission getMission(ArrayList<Mission> missions){
        Dice dice = new Dice(missions.size() - 1);
        return missions.get(dice.roll());
    }
}