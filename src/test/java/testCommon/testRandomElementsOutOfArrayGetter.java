package testCommon;

import common.RandomElementsOutOfArrayGetter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testRandomElementsOutOfArrayGetter {
    RandomElementsOutOfArrayGetter getter = new RandomElementsOutOfArrayGetter();
    List<Object> dummyList = Arrays.asList(1,2,3);

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
            else
                reps = 0;
        }
    }

    @Test
    void testRandomArrayWithAnyReps() {
        List<Object> resultList = getter.randomArrayWithAnyReps(dummyList, 2);
        assertEquals(resultList.size(), 2);
        assertTrue((Integer)resultList.get(0) > 0 && (Integer)resultList.get(0) < 4);
        assertTrue((Integer)resultList.get(1) > 0 && (Integer)resultList.get(1) < 4);
    }
}
