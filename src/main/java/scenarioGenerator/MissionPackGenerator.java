package scenarioGenerator;

import common.Dice;

import java.util.ArrayList;

public class MissionPackGenerator {
    public ArrayList<Mission> generate(ArrayList<Mission> missions, int quantity){
        ArrayList<Mission> generatedMissions = new ArrayList<>();
        if(missions.size() > quantity){

        }
        if(missions.size() == quantity){

        }
        else{

        }
        return generatedMissions;
    }

    public ArrayList<Mission> generateWithAnyReps(ArrayList<Mission> missions, int quantity){
        ArrayList<Mission> generatedMissions = new ArrayList<>();

        RandomMissionGetter getter = new RandomMissionGetter();
        for(int i = 0; i < quantity; i++){
            generatedMissions.add(getter.getMission(missions));
        }
        return generatedMissions;
    }
}
