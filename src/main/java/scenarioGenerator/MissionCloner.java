package scenarioGenerator;

import java.util.ArrayList;

public class MissionCloner {
    public static ArrayList<Mission> cloneMissions(ArrayList<Mission> missions, int quantity){
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
}
