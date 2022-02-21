package scenarioGenerator.utility;

import java.util.List;

public class ObjectivePackQuantityChecker {
    private ObjectivePackQuantityChecker() {}

    public static boolean canObjectivePackBeGenerated(List<Integer> objectivePackSums, int scensToGenerate){
        boolean anyObjectivePack;
        boolean quantityOk;

        for(Integer i : objectivePackSums){
            if(i < scensToGenerate && i > 0)
                return false;
        }
        return true;
    }

}
