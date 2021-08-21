package testScenarioGenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scenarioGenerator.pojos.Deployment;
import scenarioGenerator.pojos.Mission;
import scenarioGenerator.utility.ScenarioFormValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testScenarioFormValidator {
    Deployment d0 = Mockito.mock(Deployment.class);
    Deployment d1 = Mockito.mock(Deployment.class);
    Deployment d2 = Mockito.mock(Deployment.class);
    Deployment d3 = Mockito.mock(Deployment.class);

    List<Deployment> deployments = new ArrayList<>(Arrays.asList(d0,d1,d2,d3));

    Mission m00 = Mockito.mock(Mission.class);
    Mission m01 = Mockito.mock(Mission.class);
    Mission m02 = Mockito.mock(Mission.class);
    Mission m03 = Mockito.mock(Mission.class);
    List<Mission> missions0 = new ArrayList<>(Arrays.asList(m00,m01,m02,m03));

    Mission m10 = Mockito.mock(Mission.class);
    Mission m11 = Mockito.mock(Mission.class);
    Mission m12 = Mockito.mock(Mission.class);
    Mission m13 = Mockito.mock(Mission.class);
    List<Mission> missions1 = new ArrayList<>(Arrays.asList(m10,m11,m12,m13));

    List<List<Mission>> missions = new ArrayList<>();

    @BeforeEach
    void init(){
        missions.clear();
        missions.add(missions0);
        missions.add(missions1);
    }

    @Test
    void testCanBeGeneratedInts(){
        assertTrue(ScenarioFormValidator.canBeGenerated(
                deployments, missions, 1, 1, 2
        ));
        assertFalse(ScenarioFormValidator.canBeGenerated(
                deployments, missions, 1, 1, 2000
        ));
        assertTrue(ScenarioFormValidator.canBeGenerated(
                deployments, missions, 1, 1, 4
        ));
        assertFalse(ScenarioFormValidator.canBeGenerated(
                deployments, missions, 1, 1, 5
        ));
        assertFalse(ScenarioFormValidator.canBeGenerated(
                deployments, missions, 1, 1, -1
        ));
    }

    @Test
    void testCanBeGeneratedArrays() {
        List<Integer> depRepList0 = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        List<Integer> depRepList1 = new ArrayList<>(Arrays.asList(10, 10, 10, 10));
        List<Integer> missRepList00 = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        List<Integer> missRepList01 = new ArrayList<>(Arrays.asList(10, 10, 10, 10));

        List<List<Integer>> missRepTotalList0 = new ArrayList<>(Arrays.asList(
                missRepList00, missRepList01));
        List<Integer> missRepList10 = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        List<Integer> missRepList11 = new ArrayList<>(Arrays.asList(10, 10, 10, 10));

        List<List<Integer>> missRepTotalList1 = new ArrayList<>(Arrays.asList(
                missRepList10, missRepList11));

        assertTrue(ScenarioFormValidator.canBeGenerated(
                deployments, missions, depRepList0, missRepTotalList0, 2
        ));
        assertTrue(ScenarioFormValidator.canBeGenerated(
                deployments, missions, depRepList0, missRepTotalList1, 3
        ));
        assertTrue(ScenarioFormValidator.canBeGenerated(
                deployments, missions, depRepList1, missRepTotalList0, 4
        ));
        assertTrue(ScenarioFormValidator.canBeGenerated(
                deployments, missions, depRepList1, missRepTotalList1, 10
        ));


        assertFalse(ScenarioFormValidator.canBeGenerated(
                deployments, missions, depRepList0, missRepTotalList0, 200
        ));
        assertFalse(ScenarioFormValidator.canBeGenerated(
                deployments, missions, depRepList0, missRepTotalList1, 2000
        ));
        assertFalse(ScenarioFormValidator.canBeGenerated(
                deployments, missions, depRepList1, missRepTotalList0, 40000
        ));
        assertFalse(ScenarioFormValidator.canBeGenerated(
                deployments, missions, depRepList1, missRepTotalList1, 500000
        ));


        assertFalse(ScenarioFormValidator.canBeGenerated(
                deployments, missions, depRepList1, missRepTotalList1, -1
        ));
        assertFalse(ScenarioFormValidator.canBeGenerated(
                deployments, missions, depRepList1, missRepTotalList1, 0
        ));
    }
}
