package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Deployment;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDeployment {
    ImageIcon img = new ImageIcon("/home/bogu/IdeaProjects/WargamingAssistant//src/main/img/T9A/deployments/1.png");
    Deployment deployment = new Deployment("Deployment", img);

    @Test
    void getName(){
        assertEquals("Deployment", deployment.getName());
    }

    @Test
    void getImg(){
        assertEquals(img, deployment.getImg());
    }
}
