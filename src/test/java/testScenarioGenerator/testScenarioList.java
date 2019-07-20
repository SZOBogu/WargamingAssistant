package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Scenario;
import scenarioGenerator.ScenarioList;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testScenarioList {
    Scenario scen0 = new Scenario();
    Scenario scen1 =  new Scenario("test1", new ArrayList<>());
    ArrayList<Scenario> scenarios = new ArrayList<>(Arrays.asList(scen0, scen1));
    ScenarioList scenList = new ScenarioList("Type");
    ScenarioList scenList1 = new ScenarioList("Type", scenarios);

    @Test
    void testGetName(){
        assertEquals("Type", scenList.getName());
    }

    @Test
    void testSize() {
        assertEquals(0, scenList.size());
        assertEquals(2, scenList1.size());
    }
    @Test
    void testAdd(){
        assertEquals(0, scenList.size());
        scenList.add(scen0);
        assertEquals(1, scenList.size());
        scenList.add(scen1);
        assertEquals(2, scenList.size());
    }

    @Test
    void testGet(){
        assertEquals(scen0, scenList1.get(0));
        assertEquals(scen1, scenList1.get(1));
    }

}

