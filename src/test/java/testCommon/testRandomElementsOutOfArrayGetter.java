package testCommon;

import common.RandomElementsOutOfArrayGetter;
import org.junit.jupiter.api.Test;
import scenarioGenerator.Deployment;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testRandomElementsOutOfArrayGetter {
    RandomElementsOutOfArrayGetter getter = new RandomElementsOutOfArrayGetter();
    List<Object> dummyList = Arrays.asList(1,2,3);

    Deployment deployment0 = new Deployment("Deployment 0", new ImageIcon("/home/bogu/IdeaProjects/GUI//src/main/img/T9A/deployments/0.png"));
    Deployment deployment1 = new Deployment("Deployment 1", new ImageIcon("/home/bogu/IdeaProjects/GUI//src/main/img/T9A/deployments/1.png"));
    Deployment deployment2 = new Deployment("Deployment 2", new ImageIcon("/home/bogu/IdeaProjects/GUI//src/main/img/T9A/deployments/2.png"));
    List<Object> deploymentList = Arrays.asList(deployment0, deployment1, deployment2);
    @Test
    void testRandomArrayWithoutReps() {
        List<Object> resultList = getter.randomArrayWithoutReps(dummyList, 2);
        assertEquals(resultList.size(), 2);
        assertTrue((Integer)resultList.get(0) > 0 && (Integer)resultList.get(0) < 4);
        assertTrue((Integer)resultList.get(1) > 0 && (Integer)resultList.get(1) < 4);
        assertNotSame(resultList.get(1), resultList.get(0));
    }

    @Test
    void testRandomArrayWithRepsArray() {
        List<Integer> repList = Arrays.asList(5,2,0);
        List<Object> resultList = getter.randomArrayWithReps(dummyList, repList, 3);
        assertEquals(resultList.size(), 3);
        assertTrue((Integer)resultList.get(0) > 0 && (Integer)resultList.get(0) < 4);
        assertTrue((Integer)resultList.get(1) > 0 && (Integer)resultList.get(1) < 4);
        assertTrue((Integer)resultList.get(2) > 0 && (Integer)resultList.get(2) < 4);
        assertNotSame(resultList.get(0), dummyList.get(2));
        assertNotSame(resultList.get(1), dummyList.get(2));
        assertNotSame(resultList.get(2), dummyList.get(2));
        int reps = 0;
        for(int i = 0 ; i < resultList.size(); i++){
            if((Integer)resultList.get(i) == 2) {
                reps++;
            }
        }
        if(reps > 2){
            fail();
        }
    }

    @Test
    void testRandomArrayWithRepsInt() {
        List<Object> resultList = getter.randomArrayWithReps(dummyList, 2, 3);
        assertEquals(resultList.size(), 3);
        assertTrue((Integer)resultList.get(0) > 0 && (Integer)resultList.get(0) < 4);
        assertTrue((Integer)resultList.get(1) > 0 && (Integer)resultList.get(1) < 4);
        assertTrue((Integer)resultList.get(2) > 0 && (Integer)resultList.get(2) < 4);

        for(int i = 0 ; i < dummyList.size(); i++){
            int reps = 0;
            for(int j = 0; j < resultList.size(); j++){
                if(resultList.get(j) == dummyList.get(i))
                    reps++;
            }
            if(reps > 2)
                fail();
        }
    }

    @Test
    void testRandomArrayWithAnyReps() {
        List<Object> resultList = getter.randomArrayWithAnyReps(dummyList, 2);
        assertEquals(resultList.size(), 2);
        assertTrue((Integer)resultList.get(0) > 0 && (Integer)resultList.get(0) < 4);
        assertTrue((Integer)resultList.get(1) > 0 && (Integer)resultList.get(1) < 4);
    }

    @Test
    void testOnDeployments(){
        List<Object> deploymentResultList = getter.randomArrayWithoutReps(deploymentList, 2);
        assertTrue(deploymentResultList.get(0).equals(deployment0) ||
                deploymentResultList.get(0).equals(deployment1) ||
                deploymentResultList.get(0).equals(deployment2));
        assertTrue(deploymentResultList.get(1).equals(deployment0) ||
                deploymentResultList.get(1).equals(deployment1) ||
                deploymentResultList.get(1).equals(deployment2));
    }
}
