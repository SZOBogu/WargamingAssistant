package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Mission;
import scenarioGenerator.MissionList;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMissionList {
    Mission scen0 = new Mission();
    Mission scen1 =  new Mission("test1", new ArrayList<>());
    ArrayList<Mission> missions = new ArrayList<>(Arrays.asList(scen0, scen1));
    MissionList scenList = new MissionList("Type");
    MissionList scenList1 = new MissionList("Type", missions);

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

