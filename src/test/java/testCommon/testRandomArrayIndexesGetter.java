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
        List<Integer> tooShortRepList = Arrays.asList(2, 1);
        List<Integer> tooLongRepList = Arrays.asList(2, 1, 7, 23, 2);
        List<Integer> indexList0 = getter.randomArrayIndexesWithReps(dummyList, repList, 3);
        List<Integer> indexList1 = getter.randomArrayIndexesWithReps(dummyList, tooShortRepList, 3);
        List<Integer> indexList2 = getter.randomArrayIndexesWithReps(dummyList, tooLongRepList, 3);

        assertEquals(indexList0.size(), 3);
        assertEquals(indexList1.size(), 3);
        assertEquals(indexList2.size(), 3);

        assertTrue(indexList0.get(0) == 0 || indexList0.get(0) == 1 || indexList0.get(0) == 2);
        assertTrue(indexList0.get(1) == 0 || indexList0.get(1) == 1 || indexList0.get(1) == 2);
        assertTrue(indexList0.get(2) == 0 || indexList0.get(2) == 1 || indexList0.get(2) == 2);
        assertNotSame(indexList0.get(0), dummyList.get(2));
        assertNotSame(indexList0.get(1), dummyList.get(2));
        assertNotSame(indexList0.get(2), dummyList.get(2));
        int reps0 = 0;
        int reps1 = 0;
        int reps2 = 0;
        for (Integer integer : indexList0) {
            if (integer == 0) {
                reps0++;
            }
            else if (integer == 1) {
                reps1++;
            }
            else if (integer == 2) {
                reps2++;
            }
        }
        if(reps0 > 5){
            fail();
        }
        if(reps1 > 2){
            fail();
        }
        if(reps2 > 0){
            fail();
        }

        assertEquals(indexList1.size(), 3);
        assertEquals(indexList1.size(), 3);
        assertEquals(indexList1.size(), 3);
        assertTrue(indexList1.get(0) == 0 || indexList1.get(0) == 1 || indexList1.get(0) == 2);
        assertTrue(indexList1.get(1) == 0 || indexList1.get(1) == 1 || indexList1.get(1) == 2);
        assertTrue(indexList1.get(2) == 0 || indexList1.get(2) == 1 || indexList1.get(2) == 2);
        assertNotSame(indexList1.get(0), dummyList.get(2));
        assertNotSame(indexList1.get(1), dummyList.get(2));
        assertNotSame(indexList1.get(2), dummyList.get(2));
        reps0 = 0;
        reps1 = 0;
        reps2 = 0;
        for (Integer integer : indexList1) {
            if (integer == 0) {
                reps0++;
            }
            else if (integer == 1) {
                reps1++;
            }
            else if (integer == 2) {
                reps2++;
            }
        }
        if(reps0 > 2){
            fail();
        }
        if(reps1 > 1){
            fail();
        }
        if(reps2 > 1){
            fail();
        }


        assertEquals(indexList2.size(), 3);
        assertEquals(indexList2.size(), 3);
        assertEquals(indexList2.size(), 3);
        assertTrue(indexList2.get(0) == 0 || indexList2.get(0) == 1 || indexList2.get(0) == 2);
        assertTrue(indexList2.get(1) == 0 || indexList2.get(1) == 1 || indexList2.get(1) == 2);
        assertTrue(indexList2.get(2) == 0 || indexList2.get(2) == 1 || indexList2.get(2) == 2);
        assertNotSame(indexList2.get(0), dummyList.get(2));
        assertNotSame(indexList2.get(1), dummyList.get(2));
        assertNotSame(indexList2.get(2), dummyList.get(2));
        reps0 = 0;
        reps1 = 0;
        reps2 = 0;
        for (Integer integer : indexList2) {
            if (integer == 0) {
                reps0++;
            }
            else if (integer == 1) {
                reps1++;
            }
            else if (integer == 2) {
                reps2++;
            }
        }
        if(reps0 > 2){
            fail();
        }
        if(reps1 > 1){
            fail();
        }
        if(reps2 > 7){
            fail();
        }
    }

    @Test
    void testRandomArrayWithRepsInt() {
        List<Integer> indexList = getter.randomArrayIndexesWithReps(dummyList, 2, 3);
        assertEquals(indexList.size(), 3);

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
