package scenarioGenerator;

import common.ArrayElementsWithRepsCounter;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class ScenarioFormValidator {
    public static boolean canBeGenerated(ArrayList<Deployment> deployments, ArrayList<ArrayList<Mission>> missions,
                                  int deploymentReps, int missionReps,int scensToGenerate){
        if(scensToGenerate > 0) {
            ArrayList<Integer> deploymentRepList = new ArrayList<>();
            ArrayList<ArrayList<Integer>> missionRepList = new ArrayList<>();

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
    public static boolean canBeGenerated(ArrayList<Deployment> deployments, ArrayList<ArrayList<Mission>> missions,
                                  ArrayList<Integer> deploymentReps, ArrayList<ArrayList<Integer>> missionReps,
                                  int scensToGenerate){
        if(scensToGenerate > 0) {
            int missionCount = 0;
            int deploymentCount = 0;
            ArrayElementsWithRepsCounter counter = new ArrayElementsWithRepsCounter();

            missionCount = counter.count2D(missions, missionReps);
            deploymentCount = counter.count(deployments, deploymentReps);

            return missionCount >= scensToGenerate && deploymentCount >= scensToGenerate;
        }
        return false;
    }
}
