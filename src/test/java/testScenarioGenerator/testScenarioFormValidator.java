package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.requests.ScenarioRequest;
import scenarioGenerator.utility.ScenarioFormValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testScenarioFormValidator {
    ScenarioRequest request = new ScenarioRequest();

    @Test
    void testCanBeGeneratedInts(){
        request.setDeploymentPool(Arrays.asList(3));
        request.setMissionPool(Arrays.asList(Arrays.asList(2, 1)));
        request.setScenariosToGenerate(3);
        assertTrue(ScenarioFormValidator.canBeGenerated(request));

        request.setDeploymentPool(Arrays.asList(1));
        request.setMissionPool(Arrays.asList(Arrays.asList(1)));
        request.setScenariosToGenerate(300);
        assertFalse(ScenarioFormValidator.canBeGenerated(request));

        request.setDeploymentPool(Arrays.asList(4));
        request.setMissionPool(Arrays.asList(Arrays.asList(2, 3), Arrays.asList(11, 11)));
        request.setScenariosToGenerate(4);
        assertTrue(ScenarioFormValidator.canBeGenerated(request));

        request.setDeploymentPool(Arrays.asList(50));
        request.setMissionPool(Arrays.asList(Arrays.asList(2, 3), Arrays.asList(1, 4)));
        request.setScenariosToGenerate(5);
        assertTrue(ScenarioFormValidator.canBeGenerated(request));

        request.setDeploymentPool(Arrays.asList(3));
        request.setMissionPool(Arrays.asList(Arrays.asList(2, 1)));
        request.setScenariosToGenerate(-1);
        assertFalse(ScenarioFormValidator.canBeGenerated(request));
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

        request.setDeploymentPool(depRepList0);
        request.setMissionPool(missRepTotalList0);
        request.setScenariosToGenerate(2);
        assertTrue(ScenarioFormValidator.canBeGenerated(request));

        request.setDeploymentPool(depRepList0);
        request.setMissionPool(missRepTotalList1);
        request.setScenariosToGenerate(3);
        assertTrue(ScenarioFormValidator.canBeGenerated(request));

        request.setDeploymentPool(depRepList1);
        request.setMissionPool(missRepTotalList0);
        request.setScenariosToGenerate(4);
        assertTrue(ScenarioFormValidator.canBeGenerated(request));

        request.setDeploymentPool(depRepList1);
        request.setMissionPool(missRepTotalList1);
        request.setScenariosToGenerate(10);
        assertFalse(ScenarioFormValidator.canBeGenerated(request));

        request.setDeploymentPool(depRepList0);
        request.setMissionPool(missRepTotalList0);
        request.setScenariosToGenerate(200);
        assertFalse(ScenarioFormValidator.canBeGenerated(request));

        request.setDeploymentPool(depRepList0);
        request.setMissionPool(missRepTotalList1);
        request.setScenariosToGenerate(3);
        assertTrue(ScenarioFormValidator.canBeGenerated(request));

        request.setDeploymentPool(depRepList1);
        request.setMissionPool(missRepTotalList0);
        request.setScenariosToGenerate(4);
        assertTrue(ScenarioFormValidator.canBeGenerated(request));

        request.setDeploymentPool(depRepList1);
        request.setMissionPool(missRepTotalList1);
        request.setScenariosToGenerate(5);
        assertFalse(ScenarioFormValidator.canBeGenerated(request));


        request.setDeploymentPool(depRepList1);
        request.setMissionPool(missRepTotalList1);
        request.setScenariosToGenerate(-1);
        assertFalse(ScenarioFormValidator.canBeGenerated(request));

        request.setDeploymentPool(depRepList1);
        request.setMissionPool(missRepTotalList1);
        request.setScenariosToGenerate(0);
        assertFalse(ScenarioFormValidator.canBeGenerated(request));

    }
}
