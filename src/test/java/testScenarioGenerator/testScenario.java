package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scenarioGenerator.Deployment;
import scenarioGenerator.Mission;
import scenarioGenerator.Scenario;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testScenario {
    Deployment deployment = Mockito.mock(Deployment.class);
    Mission mission0 = Mockito.mock(Mission.class);
    Mission mission1 = Mockito.mock(Mission.class);
    ArrayList<Mission> missionList = new ArrayList<>(new ArrayList<>(Arrays.asList(mission0, mission1)));

    Scenario scenario0 = new Scenario("Scenario 0", deployment, missionList);
    Scenario scenario1 = new Scenario();


    @Test
    public void testGetName(){
        assertEquals("Scenario 0", scenario0.getName());
        assertEquals("Scenario", scenario1.getName());
    }

    @Test
    public void testSetName(){
        scenario0.setName("Scen0");
        scenario1.setName("Scen1");

        assertEquals("Scen0", scenario0.getName());
        assertEquals("Scen1", scenario1.getName());
    }

    @Test
    public void testGetDeployment(){
        assertEquals(deployment, scenario0.getDeployment());
        assertEquals(new Deployment("Deployment"), scenario1.getDeployment());
    }

    @Test
    public void testSetDeployment(){
        Deployment deploymentTemp = new Deployment("Deploy");
        scenario0.setDeployment(deploymentTemp);
        assertEquals(deploymentTemp, scenario0.getDeployment());
    }

    @Test
    public void testGetMissions(){
        assertEquals(missionList, scenario0.getMissions());
        assertEquals(new ArrayList<>(), scenario1.getMissions());
    }

    @Test
    public void testSetMissions(){
        Mission mission2 = new Mission("Mission 2", new ArrayList<>());
        Mission mission3 = new Mission("Mission 3", new ArrayList<>());
        ArrayList<Mission> missionList0 = new ArrayList<>(new ArrayList<>(Arrays.asList(mission2, mission3)));

        scenario0.setMissions(missionList0);

        assertEquals(missionList0, scenario0.getMissions());
    }
}
