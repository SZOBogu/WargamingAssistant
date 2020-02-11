package scenarioGenerator;

import common.Dice;

import java.util.ArrayList;

public class DeploymentPackGenerator {
    public ArrayList<Deployment> generate(ArrayList<Deployment> deployments, int quantity){
        ArrayList<Deployment> generatedDeployments = new ArrayList<>();
        if(deployments.size() > quantity){
            //gieneruj normalnie
        }
        if(deployments.size() == quantity){
            //pomieszaj
        }
        else{
            //zworc gownoliste
        }
        return generatedDeployments;
    }

    public ArrayList<Deployment> generateWithAnyReps(ArrayList<Deployment> deployments, int quantity){
        ArrayList<Deployment> generatedDeployments = new ArrayList<>();
        RandomDeploymentGetter getter = new RandomDeploymentGetter();
        for(int i = 0; i < quantity; i++){
            generatedDeployments.add(getter.getDeployment(deployments));
        }
        return generatedDeployments;
    }
}
