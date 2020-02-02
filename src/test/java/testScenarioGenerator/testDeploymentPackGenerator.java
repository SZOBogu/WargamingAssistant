package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Deployment;
import scenarioGenerator.DeploymentPackGenerator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.fail;

public class testDeploymentPackGenerator {
    Deployment deployment0 = new Deployment("Deployment 0", new ImageIcon());
    Deployment deployment1 = new Deployment("Deployment 1", new ImageIcon());
    Deployment deployment2 = new Deployment("Deployment 2", new ImageIcon());

    ArrayList<Deployment> deployments = new ArrayList<>(Arrays.asList(deployment0, deployment1, deployment2));

    DeploymentPackGenerator generator = new DeploymentPackGenerator();

    @Test
    void testGenerate(){
        fail();
    }

    @Test
    void testGenerateWithReps(){
        fail();
    }
}
