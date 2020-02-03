package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Deployment;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class testDeployment {
    ImageIcon img = new ImageIcon("/home/bogu/IdeaProjects/WargamingAssistant//src/main/img/T9A/deployments/1.png");
    Deployment deployment = new Deployment("Deployment", img);
    Deployment deployment0 = new Deployment(deployment);
    @Test
    void getName(){
        assertEquals("Deployment", deployment.getName());
    }

    @Test
    void getImg(){
        assertEquals(img, deployment.getImg());
    }

    @Test
    void testCopyConstructor(){
        assertEquals(deployment.getName(), deployment0.getName());
        assertEquals(deployment.getImg(), deployment0.getImg());
    }

    @Test
    void testEquals(){
        assertEquals(deployment, deployment0);
        Deployment deploymentTest = new Deployment("Deployment", img);
        assertEquals(deploymentTest, deployment);
    }
}