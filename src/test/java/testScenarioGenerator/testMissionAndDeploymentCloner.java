package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scenarioGenerator.Deployment;
import scenarioGenerator.Mission;
import scenarioGenerator.MissionAndDeploymentCloner;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMissionAndDeploymentCloner {
    Mission mission0 = Mockito.mock(Mission.class);
    Mission mission1 = Mockito.mock(Mission.class);
    Mission mission2 = Mockito.mock(Mission.class);

    Deployment deployment0 = Mockito.mock(Deployment.class);
    Deployment deployment1 = Mockito.mock(Deployment.class);
    Deployment deployment2 = Mockito.mock(Deployment.class);

    ArrayList<Mission> missions = new ArrayList<>(Arrays.asList(mission0, mission1, mission2));
    ArrayList<Deployment> deployments = new ArrayList<>(Arrays.asList(deployment0, deployment1, deployment2));

    @Test
    void testCloneMissions(){
        ArrayList<Mission> resultMissions = new ArrayList<>(Arrays.asList(mission0, mission0, mission1, mission1, mission2, mission2));
        assertEquals(resultMissions, MissionAndDeploymentCloner.cloneMissions(missions, 2));
        assertEquals(missions, MissionAndDeploymentCloner.cloneMissions(missions, -1));
        assertEquals(missions, MissionAndDeploymentCloner.cloneMissions(missions, 0));
    }

    @Test
    void testCloneDeployments(){
        ArrayList<Deployment> resultDeployments = new ArrayList<>(Arrays.asList(deployment0, deployment0, deployment1, deployment1, deployment2, deployment2));
        assertEquals(resultDeployments, MissionAndDeploymentCloner.cloneDeployments(deployments, 2));
        assertEquals(deployments, MissionAndDeploymentCloner.cloneDeployments(deployments, -1));
        assertEquals(deployments, MissionAndDeploymentCloner.cloneDeployments(deployments, 0));
    }
}
