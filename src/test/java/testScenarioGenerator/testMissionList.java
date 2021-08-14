package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scenarioGenerator.Mission;
import scenarioGenerator.MissionList;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMissionList {
    Mission mission0 = Mockito.mock(Mission.class);
    Mission mission1 = Mockito.mock(Mission.class);
    ArrayList<Mission> missions = new ArrayList<>(Arrays.asList(mission0, mission1));
    MissionList missionList = new MissionList("Type");
    MissionList missionList1 = new MissionList("Type", missions);

    @Test
    void testGetName(){
        assertEquals("Type", missionList.getName());
    }

    @Test
    void testSize() {
        assertEquals(0, missionList.size());
        assertEquals(2, missionList1.size());
    }
    @Test
    void testAdd(){
        assertEquals(0, missionList.size());
        missionList.add(mission0);
        assertEquals(1, missionList.size());
        missionList.add(mission1);
        assertEquals(2, missionList.size());
    }

    @Test
    void testGet(){
        assertEquals(mission0, missionList1.get(0));
        assertEquals(mission1, missionList1.get(1));
    }

}

