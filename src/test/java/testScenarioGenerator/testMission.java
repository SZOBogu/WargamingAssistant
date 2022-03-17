package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scenarioGenerator.entities.Deployment;
import scenarioGenerator.entities.Mission;
import scenarioGenerator.entities.Objective;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class testMission {
    Mission miss0 = new Mission();
    Deployment deployment = new Deployment("test Deployment", "asdfa");
    Objective objective0 = Mockito.mock(Objective.class);
    Objective objective1 = Mockito.mock(Objective.class);
    Objective objective2 = Mockito.mock(Objective.class);

    ArrayList<Objective> objectives = new ArrayList<>(Arrays.asList(
            objective0, objective1, objective2
            ));
    Mission miss1 = new Mission("Zrobić porządek", objectives);
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
        assertEquals(objective0, miss1.getObjectives().get(0));
        assertEquals(objective1, miss1.getObjectives().get(1));
        assertEquals(objective2, miss1.getObjectives().get(2));

        assertEquals(miss3.getObjectives(), miss1.getObjectives());
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
