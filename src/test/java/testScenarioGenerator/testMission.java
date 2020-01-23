package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Deployment;
import scenarioGenerator.Mission;
import scenarioGenerator.Objective;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class testMission {
    Mission scen0 = new Mission();
    Deployment deployment = new Deployment("test Deployment", new ImageIcon());
    ArrayList<Objective> objectives = new ArrayList<>(Arrays.asList(
            new Objective("W ogóle"),
            new Objective("Centralnie", 2),
            new Objective("Kamieniem go bez kitu", 3)
            ));
    Mission scen1 = new Mission("Zrobić porządek", objectives, deployment);
    Mission scen2 = new Mission("scen 2", new ArrayList<>(), "opis scen 2");

    @Test
    void testGetName(){
        assertEquals("Scenario", scen0.getName());
        assertEquals("Zrobić porządek",scen1.getName());
    }

    @Test
    void testGetObjectives(){
        assertEquals(0, scen0.getObjectives().size());
        assertEquals(3, scen1.getObjectives().size());
        assertEquals("W ogóle", scen1.getObjectives().get(0).getName());
        assertEquals("Centralnie", scen1.getObjectives().get(1).getName());
        assertEquals("Kamieniem go bez kitu", scen1.getObjectives().get(2).getName());
        assertEquals(1, scen1.getObjectives().get(0).getVictoryPoints());
        assertEquals(2, scen1.getObjectives().get(1).getVictoryPoints());
        assertEquals(3, scen1.getObjectives().get(2).getVictoryPoints());

    }

    @Test
    void testGetDeployment(){
        assertEquals(deployment, scen1.getDeployment());
        assertNull(scen0.getDeployment());
    }

    @Test
    void testGetDescription(){
        assertEquals("", scen1.getDescription());
        assertEquals("opis scen 2", scen2.getDescription());
    }
}
