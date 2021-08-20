package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Mission;
import scenarioGenerator.MissionCloner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMissionCloner {
    Mission mission0 = new Mission("Mission 0", new ArrayList<>());
    Mission mission1 = new Mission("Mission 1", new ArrayList<>());
    Mission mission2 = new Mission("Mission 2", new ArrayList<>());

    ArrayList<Mission> missions = new ArrayList<>(Arrays.asList(mission0, mission1, mission2));

    @Test
    void testCloneMissions(){
        ArrayList<Mission> resultMissions = new ArrayList<>(Arrays.asList(mission0, mission0, mission1, mission1, mission2, mission2));
        assertEquals(resultMissions, MissionCloner.cloneMissions(missions, 2));
        assertEquals(missions, MissionCloner.cloneMissions(missions, -1));
        assertEquals(missions, MissionCloner.cloneMissions(missions, 0));
    }
}
