package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Deployment;
import scenarioGenerator.DeploymentCloner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDeploymentCloner {
    Deployment deployment0 = new Deployment("Deployment 0");
    Deployment deployment1 = new Deployment("Deployment 1");
    Deployment deployment2 = new Deployment("Deployment 2");

    ArrayList<Deployment> deployments = new ArrayList<>(Arrays.asList(deployment0, deployment1, deployment2));

    @Test
    void testCloneDeployments(){
        ArrayList<Deployment> resultDeployments = new ArrayList<>(Arrays.asList(deployment0, deployment0, deployment1, deployment1, deployment2, deployment2));
        assertEquals(resultDeployments, DeploymentCloner.cloneDeployments(deployments, 2));
        assertEquals(deployments, DeploymentCloner.cloneDeployments(deployments, -1));
        assertEquals(deployments, DeploymentCloner.cloneDeployments(deployments, 0));
    }
}
