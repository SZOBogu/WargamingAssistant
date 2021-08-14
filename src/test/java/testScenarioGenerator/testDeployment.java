package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scenarioGenerator.Deployment;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class testDeployment {
    ImageIcon img = Mockito.mock(ImageIcon.class);
    Deployment deployment = new Deployment("Deployment", img);
    Deployment deployment0 = new Deployment(deployment);
    Deployment deployment1 = new Deployment("Deploy");
    @Test
    void getName(){
        assertEquals("Deployment", deployment.getName());
        assertEquals("Deploy", deployment1.getName());
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