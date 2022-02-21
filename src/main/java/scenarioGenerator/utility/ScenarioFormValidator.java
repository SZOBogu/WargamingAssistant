package scenarioGenerator.utility;

import java.util.ArrayList;
import java.util.List;

public class ScenarioFormValidator {

    private ScenarioFormValidator(){}

    //TODO: make sure conditions are actually ok
    public static boolean canBeGenerated(List<Integer> deployments, List<List<Integer>> objectivePack,
                                         int scensToGenerate){
        if(scensToGenerate > 0) {
            int deploymentSum = 0;
            List<Integer> objectivePackSum = new ArrayList<>();

            for (int i = 0; i < deployments.size(); i++) {
                deploymentSum += deployments.get(i);
            }

            for (int i = 0; i < objectivePack.size(); i++) {
                int tempSum = 0;
                for (int j = 0; j < objectivePack.get(i).size(); i++) {
                    tempSum += objectivePack.get(i).get(j);
                }
            }

            if (deploymentSum >= scensToGenerate && ObjectivePackQuantityChecker.canObjectivePackBeGenerated(objectivePackSum, scensToGenerate))
                return true;
            else
                return false;

        }
        else return false;
    }
}
