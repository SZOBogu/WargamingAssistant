package testCommon;

import common.RandomArrayIndexesGetter;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testRandomArrayIndexesGetter {
    RandomArrayIndexesGetter getter = new RandomArrayIndexesGetter();
    List<Object> dummyList = Arrays.asList(1,2,3);

    @Test
    void testGetIndexesThatWereDuplicated(){
        List<Integer> repList0 = Arrays.asList(5,2,1);
        List<Integer> indexList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        List<Integer> resultList0 = getter.getIndexesThatWereDuplicated(dummyList, indexList, repList0, 3);

        assertEquals(Arrays.asList(0,1,2,0,0,0,0,1), resultList0);
    }

    @Test
    void testRandomArrayWithoutReps() {
        List<Integer> indexList = getter.randomArrayIndexesWithoutReps(dummyList, 2);

        assertEquals(indexList.size(), 2);
        assertTrue(indexList.get(0) == 0 || indexList.get(0) == 1 || indexList.get(0) == 2);
        assertTrue(indexList.get(1) == 0 || indexList.get(1) == 1 || indexList.get(1) == 2);
        assertNotSame(indexList.get(1), indexList.get(0));
    }

    @Test
    void testRandomArrayWithRepsArray() {
        List<Integer> repList = Arrays.asList(5,2,0);
        List<Integer> indexList = getter.randomArrayIndexesWithReps(dummyList, repList, 3);
        System.out.println("testRandomArrayWithRepsArray");
        for(int i = 0; i < indexList.size(); i++)
            System.out.println(indexList.get(i));

        assertEquals(indexList.size(), 3);
        assertTrue(indexList.get(0) == 0 || indexList.get(0) == 1 || indexList.get(0) == 2);
        assertTrue(indexList.get(1) == 0 || indexList.get(1) == 1 || indexList.get(1) == 2);
        assertTrue(indexList.get(2) == 0 || indexList.get(2) == 1 || indexList.get(2) == 2);
        assertNotSame(indexList.get(0), dummyList.get(2));
        assertNotSame(indexList.get(1), dummyList.get(2));
        assertNotSame(indexList.get(2), dummyList.get(2));
        int reps = 0;
        for (Integer integer : indexList) {
            if (integer == 2) {
                reps++;
            }
        }
        if(reps > 2){
            fail();
        }
    }

    @Test
    void testRandomArrayWithRepsInt() {
        List<Integer> indexList = getter.randomArrayIndexesWithReps(dummyList, 2, 3);
        assertEquals(indexList.size(), 3);
        System.out.println("testRandomArrayWithRepsInt");
        for(int i = 0; i < indexList.size(); i++)
            System.out.println(indexList.get(i));

        assertTrue(indexList.get(0) == 0 || indexList.get(0) == 1 || indexList.get(0) == 2);
        assertTrue(indexList.get(1) == 0 || indexList.get(1) == 1 || indexList.get(1) == 2);
        assertTrue(indexList.get(2) == 0 || indexList.get(2) == 1 || indexList.get(2) == 2);

        for (Object o : dummyList) {
            int reps = 0;
            for (Integer integer : indexList) {
                if (integer == o)
                    reps++;
            }
            if (reps > 2)
                fail();
        }
    }

    @Test
    void testRandomArrayWithAnyReps() {
        List<Integer> indexList = getter.randomArrayIndexesWithAnyReps(dummyList, 2);
        assertEquals(indexList.size(), 2);
        assertTrue(indexList.get(0) == 0 || indexList.get(0) == 1 || indexList.get(0) == 2);
        assertTrue(indexList.get(1) == 0 || indexList.get(1) == 1 || indexList.get(1) == 2);
    }
}
