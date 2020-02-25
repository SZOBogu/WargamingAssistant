package testScenarioGenerator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scenarioGenerator.Deployment;
import scenarioGenerator.Mission;
import scenarioGenerator.ScenarioFormValidator;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testScenarioFormValidator {
    ScenarioFormValidator validator = new ScenarioFormValidator();

    Deployment d0 = new Deployment("D0");
    Deployment d1 = new Deployment("D1");
    Deployment d2 = new Deployment("D2");
    Deployment d3 = new Deployment("D3");

    ArrayList<Deployment> deployments = new ArrayList<>(Arrays.asList(d0,d1,d2,d3));

    Mission m00 = new Mission("M00", new ArrayList<>());
    Mission m01 = new Mission("M01", new ArrayList<>());
    Mission m02 = new Mission("M02", new ArrayList<>());
    Mission m03 = new Mission("M03", new ArrayList<>());
    ArrayList<Mission> missons0 = new ArrayList<>(Arrays.asList(m00,m01,m02,m03));

    Mission m10 = new Mission("M10", new ArrayList<>());
    Mission m11 = new Mission("M11", new ArrayList<>());
    Mission m12 = new Mission("M12", new ArrayList<>());
    Mission m13 = new Mission("M13", new ArrayList<>());
    ArrayList<Mission> missons1 = new ArrayList<>(Arrays.asList(m10,m11,m12,m13));

    ArrayList<ArrayList<Mission>> missions = new ArrayList<>();

    @BeforeEach
    void init(){
        missions.clear();
        missions.add(missons0);
        missions.add(missons1);
    }

    @Test
    void testCanBeGeneratedInts(){
        assertTrue(validator.canBeGenerated(
                deployments, missions, 1, 1, 2
        ));
        assertFalse(validator.canBeGenerated(
                deployments, missions, 1, 1, 2000
        ));
        assertTrue(validator.canBeGenerated(
                deployments, missions, 1, 1, 4
        ));
        assertFalse(validator.canBeGenerated(
                deployments, missions, 1, 1, 5
        ));
        assertFalse(validator.canBeGenerated(
                deployments, missions, 1, 1, -1
        ));
    }

    @Test
    void testCanBeGeneratedArrays() {
        ArrayList<Integer> depRepList0 = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        ArrayList<Integer> depRepList1 = new ArrayList<>(Arrays.asList(10, 10, 10, 10));
        ArrayList<Integer> missRepList00 = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        ArrayList<Integer> missRepList01 = new ArrayList<>(Arrays.asList(10, 10, 10, 10));

        ArrayList<ArrayList<Integer>> missRepTotalList0 = new ArrayList<>(Arrays.asList(
                missRepList00, missRepList01));
        ArrayList<Integer> missRepList10 = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        ArrayList<Integer> missRepList11 = new ArrayList<>(Arrays.asList(10, 10, 10, 10));

        ArrayList<ArrayList<Integer>> missRepTotalList1 = new ArrayList<>(Arrays.asList(
                missRepList10, missRepList11));

        assertTrue(validator.canBeGenerated(
                deployments, missions, depRepList0, missRepTotalList0, 2
        ));
        assertTrue(validator.canBeGenerated(
                deployments, missions, depRepList0, missRepTotalList1, 3
        ));
        assertTrue(validator.canBeGenerated(
                deployments, missions, depRepList1, missRepTotalList0, 4
        ));
        assertTrue(validator.canBeGenerated(
                deployments, missions, depRepList1, missRepTotalList1, 10
        ));


        assertFalse(validator.canBeGenerated(
                deployments, missions, depRepList0, missRepTotalList0, 200
        ));
        assertFalse(validator.canBeGenerated(
                deployments, missions, depRepList0, missRepTotalList1, 2000
        ));
        assertFalse(validator.canBeGenerated(
                deployments, missions, depRepList1, missRepTotalList0, 40000
        ));
        assertFalse(validator.canBeGenerated(
                deployments, missions, depRepList1, missRepTotalList1, 500000
        ));


        assertFalse(validator.canBeGenerated(
                deployments, missions, depRepList1, missRepTotalList1, -1
        ));
        assertFalse(validator.canBeGenerated(
                deployments, missions, depRepList1, missRepTotalList1, 0
        ));
    }
}
