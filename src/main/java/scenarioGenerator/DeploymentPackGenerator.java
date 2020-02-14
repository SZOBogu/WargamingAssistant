package scenarioGenerator;

import common.RandomArrayIndexesGetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeploymentPackGenerator {
    public ArrayList<Deployment> generate(ArrayList<Deployment> deployments, int quantity){
        RandomArrayIndexesGetter getter = new RandomArrayIndexesGetter();
        List<Object> tempList = Arrays.asList(deployments);
        List<Integer> generatedDeploymentIndexes = getter.randomArrayIndexesWithoutReps(tempList, quantity);
        ArrayList<Deployment> generatedDeployments = new ArrayList<>();
        for(int i = 0; i < generatedDeploymentIndexes.size(); i++){
            generatedDeployments.add(deployments.get(generatedDeploymentIndexes.get(i)));
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
