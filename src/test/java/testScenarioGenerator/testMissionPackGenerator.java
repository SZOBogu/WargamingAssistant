package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Deployment;
import scenarioGenerator.DeploymentPackGenerator;
import scenarioGenerator.Mission;
import scenarioGenerator.MissionPackGenerator;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testMissionPackGenerator {
    Mission mission0 = new Mission("Mission 0", new ArrayList<>());
    Mission mission1 = new Mission("Mission 1", new ArrayList<>());
    Mission mission2 = new Mission("Mission 2", new ArrayList<>());

    ArrayList<Mission> missions = new ArrayList<>(Arrays.asList(mission0, mission1, mission2));

    MissionPackGenerator generator = new MissionPackGenerator();

    @Test
    void testGenerate(){
        ArrayList<Mission> generatedMissions = generator.generate(missions, 2);
        assertEquals(2, generatedMissions.size());
        assertTrue(missions.contains(generatedMissions.get(0)));
        assertTrue(missions.contains(generatedMissions.get(1)));
    }

    @Test
    void testGenerateWithReps(){
        ArrayList<Mission> generatedMissions = generator.generateWithAnyReps(missions, 2);
        assertEquals(2, generatedMissions.size());
        assertTrue(missions.contains(generatedMissions.get(0)));
        assertTrue(missions.contains(generatedMissions.get(1)));
    }
}
