package scenarioGenerator;

import java.util.ArrayList;

public class ScenarioFormValidator {
    public boolean canBeGenerated(ArrayList<Deployment> deployments, ArrayList<ArrayList<Mission>> missions,
                                  int deploymentReps, int missionReps,int scensToGenerate){
       return false;
    }
    public boolean canBeGenerated(ArrayList<Deployment> deployments, ArrayList<ArrayList<Mission>> missions,
                                  ArrayList<Integer> deploymentReps, ArrayList<Integer> missionReps,
                                  int scensToGenerate){
        return false;
    }
}
