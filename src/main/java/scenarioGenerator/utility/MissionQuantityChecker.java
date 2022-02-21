package scenarioGenerator.utility;

import java.util.List;

public class MissionQuantityChecker {
    private MissionQuantityChecker() {}

    public static boolean canMissionsBeGenerated(List<Integer> missionSums, int scensToGenerate){
        for(Integer i : missionSums){
            if(i < scensToGenerate || i < 0)
                return false;
        }
        return true;
    }

}
