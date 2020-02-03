package scenarioGenerator;

import common.Dice;

import java.util.ArrayList;

public class MissionPackGenerator {
    public ArrayList<Mission> generate(ArrayList<Mission> missions, int quantity){
        return missions;
    }

    public ArrayList<Mission> generateWithAnyReps(ArrayList<Mission> missions, int quantity){
        ArrayList<Mission> generatedMissions = new ArrayList<>();
        Dice dice = new Dice(missions.size());
        RandomDeploymentGetter getter = new RandomDeploymentGetter();
        for(int i = 0; i < quantity; i++){

            generatedMissions.add(missions.get(dice.roll()-1));
        }
        return generatedMissions;
    }
}
