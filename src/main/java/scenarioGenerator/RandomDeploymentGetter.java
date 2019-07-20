package scenarioGenerator;

import javax.swing.*;
import java.util.ArrayList;

public class RandomDeploymentGetter {
    public Deployment getDeployment(ArrayList<Deployment> deployments, ArrayList<Boolean> chosenDeployments){
        BoolToListIndexConverter converter = new BoolToListIndexConverter();
        RandomIndexGenerator generator = new RandomIndexGenerator();

        ArrayList<Integer> chosenDeploymentIndexes = converter.convert(chosenDeployments);
        int deploymentIndex = generator.getIndex(chosenDeploymentIndexes);

        return deployments.get(deploymentIndex);
    }
}
