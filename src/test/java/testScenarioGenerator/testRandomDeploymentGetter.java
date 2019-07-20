package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Deployment;
import scenarioGenerator.RandomDeploymentGetter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testRandomDeploymentGetter {
    RandomDeploymentGetter getter = new RandomDeploymentGetter();

    Deployment deployment0 = new Deployment("0", new ImageIcon());
    Deployment deployment1 = new Deployment("1", new ImageIcon());
    Deployment deployment2 = new Deployment("2", new ImageIcon());
    Deployment deployment3 = new Deployment("3", new ImageIcon());
    ArrayList<Deployment> deploymentPack = new ArrayList<>(Arrays.asList(deployment0, deployment1, deployment2, deployment3));
    ArrayList<Boolean> chosenDeploys = new ArrayList<>(Arrays.asList(true, false, false, true));

    @Test
    void testGetDeployment(){
        for(int i = 0; i < 100; i++){
            Deployment generatedDeployment = getter.getDeployment(deploymentPack, chosenDeploys);
            assertTrue(generatedDeployment == deployment0 || generatedDeployment == deployment3);
        }
    }
}
