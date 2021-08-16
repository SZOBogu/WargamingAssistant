package scenarioGenerator;

import common.ArrayElementsWithRepsCounter;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class ScenarioFormValidator {
    public static boolean canBeGenerated(List<Deployment> deployments, List<List<Mission>> missions,
                                  int deploymentReps, int missionReps,int scensToGenerate){
        if(scensToGenerate > 0) {
            List<Integer> deploymentRepList = new ArrayList<>();
            List<List<Integer>> missionRepList = new ArrayList<>();

            for (int i = 0; i < deployments.size(); i++) {
                deploymentRepList.add(deploymentReps);
            }

            for (int i = 0; i < missions.size(); i++) {
                missionRepList.add(new ArrayList<>());
                for (int j = 0; j < missions.get(i).size(); j++) {
                    missionRepList.get(i).add(missionReps);
                }
            }

            return ScenarioFormValidator.canBeGenerated(deployments, missions, deploymentRepList, missionRepList, scensToGenerate);
        }
        else return false;
    }
    public static boolean canBeGenerated(List<Deployment> deployments, List<List<Mission>> missions,
                                         List<Integer> deploymentReps, List<List<Integer>> missionReps,
                                  int scensToGenerate){
        if(scensToGenerate > 0) {
            int missionCount = 0;
            int deploymentCount = 0;

            missionCount = ArrayElementsWithRepsCounter.count2D(missions, missionReps);
            deploymentCount = ArrayElementsWithRepsCounter.count(deployments, deploymentReps);

            return missionCount >= scensToGenerate && deploymentCount >= scensToGenerate;
        }
        return false;
    }
}
