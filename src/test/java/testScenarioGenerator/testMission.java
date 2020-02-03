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
    Mission miss0 = new Mission();
    Deployment deployment = new Deployment("test Deployment", new ImageIcon());
    ArrayList<Objective> objectives = new ArrayList<>(Arrays.asList(
            new Objective("W ogóle"),
            new Objective("Centralnie", 2),
            new Objective("Kamieniem go bez kitu", 3)
            ));
    Mission miss1 = new Mission("Zrobić porządek", objectives, deployment);
    Mission miss2 = new Mission("miss 2", new ArrayList<>(), "opis miss 2");
    Mission miss3 = new Mission(miss1);

    @Test
    void testGetName(){
        assertEquals("Mission", miss0.getName());
        assertEquals("Zrobić porządek",miss1.getName());
        assertEquals("miss 2", miss2.getName());
        assertEquals(miss1.getName(),miss3.getName());
    }

    @Test
    void testGetObjectives(){
        assertEquals(0, miss0.getObjectives().size());
        assertEquals(3, miss1.getObjectives().size());
        assertEquals("W ogóle", miss1.getObjectives().get(0).getName());
        assertEquals("Centralnie", miss1.getObjectives().get(1).getName());
        assertEquals("Kamieniem go bez kitu", miss1.getObjectives().get(2).getName());
        assertEquals(1, miss1.getObjectives().get(0).getVictoryPoints());
        assertEquals(2, miss1.getObjectives().get(1).getVictoryPoints());
        assertEquals(3, miss1.getObjectives().get(2).getVictoryPoints());

        assertEquals(miss3.getObjectives(), miss1.getObjectives());
    }

    @Test
    void testGetDeployment(){
        assertEquals(deployment, miss1.getDeployment());
        assertNull(miss0.getDeployment());
        assertEquals(miss1.getDeployment(), miss3.getDeployment());
    }

    @Test
    void testGetDescription(){
        assertEquals("", miss1.getDescription());
        assertEquals("opis miss 2", miss2.getDescription());
        assertEquals(miss1.getDescription(), miss3.getDescription());
    }

    @Test
    void testEquals(){
        assertEquals(miss1, miss3);
        Mission miss4 = new Mission("miss 2", new ArrayList<>(), "opis miss 2");
        assertEquals(miss4, miss2);
    }
}
