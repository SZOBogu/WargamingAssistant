package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scenarioGenerator.Deployment;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class testDeployment {
    Deployment deployment = new Deployment("Deployment", "/static/1.jpg");
    Deployment deployment0 = new Deployment(deployment);
    Deployment deployment1 = new Deployment("Deploy");
    @Test
    void getName(){
        assertEquals("Deployment", deployment.getName());
        assertEquals("Deploy", deployment1.getName());
    }

    @Test
    void getImg(){
        assertEquals("/static/1.jpg", deployment.getEncodedImage());
    }

    @Test
    void testCopyConstructor(){
        assertEquals(deployment.getName(), deployment0.getName());
        assertEquals(deployment.getEncodedImage(), deployment0.getEncodedImage());
    }

    @Test
    void testEquals(){
        assertEquals(deployment, deployment0);
        Deployment deploymentTest = new Deployment("Deployment", "/static/1.jpg");
        assertEquals(deploymentTest, deployment);
    }
}