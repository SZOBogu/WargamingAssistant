package testCommon;

import common.RandomArrayElementsGetter;
import org.junit.jupiter.api.Test;
import rosterBuilder.Entity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testRandomArrayElementsGetter {
    RandomArrayElementsGetter getter = new RandomArrayElementsGetter();
    Entity entity1 = new Entity("1", "");
    Entity entity2 = new Entity("2", "");
    Entity entity3 = new Entity("3", "");
    List<Entity> dummyList = Arrays.asList(entity1, entity2, entity3);

    @Test
    void testGetIndexesThatWereDuplicated(){
        List<Integer> repList0 = Arrays.asList(5,2,1);
        List<Integer> elementList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        List<Integer> resultList0 = getter.getIndexesThatWereDuplicated(dummyList, elementList, repList0, 3);

        assertEquals(Arrays.asList(0,1,2,0,0,0,0,1), resultList0);
    }

    @Test
    void testRandomArrayWithoutReps() {
        List<Entity> elementList = getter.randomArrayElementsWithoutReps(dummyList, 2);

        assertEquals(elementList.size(), 2);
        assertTrue(elementList.get(0) == entity1 || elementList.get(0) == entity2 || elementList.get(0) == entity3);
        assertTrue(elementList.get(1) == entity1 || elementList.get(1) == entity2 || elementList.get(1) == entity3);
        assertNotSame(elementList.get(1), elementList.get(0));
    }

    @Test
    void testRandomArrayWithRepsArray() {
        List<Integer> repList = Arrays.asList(5,2,0);
        List<Integer> tooShortRepList = Arrays.asList(2, 1);
        List<Integer> tooLongRepList = Arrays.asList(2, 1, 7, 23, 2);
        List<Entity> elementList0 = getter.randomArrayElementsWithReps(dummyList, repList, 3);
        List<Entity> elementList1 = getter.randomArrayElementsWithReps(dummyList, tooShortRepList, 3);
        List<Entity> elementList2 = getter.randomArrayElementsWithReps(dummyList, tooLongRepList, 3);

        assertEquals(elementList0.size(), 3);
        assertEquals(elementList1.size(), 3);
        assertEquals(elementList2.size(), 3);

        assertTrue(elementList0.get(0) == entity1 || elementList0.get(0) == entity2);
        assertTrue(elementList0.get(1) == entity1 || elementList0.get(1) == entity2);
        assertTrue(elementList0.get(2) == entity1 || elementList0.get(2) == entity2);
        assertNotSame(elementList0.get(0), dummyList.get(2));
        assertNotSame(elementList0.get(1), dummyList.get(2));
        assertNotSame(elementList0.get(2), dummyList.get(2));
        int reps0 = 0;
        int reps1 = 0;
        int reps2 = 0;
        for (Entity e : elementList0) {
            if (e == entity1) {
                reps0++;
            }
            else if (e == entity2) {
                reps1++;
            }
            else if (e == entity3) {
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

        assertEquals(elementList1.size(), 3);
        assertEquals(elementList1.size(), 3);
        assertEquals(elementList1.size(), 3);
        assertTrue(elementList1.get(0) == entity1 || elementList1.get(0) == entity2 || elementList1.get(0) == entity3);
        assertTrue(elementList1.get(1) == entity1 || elementList1.get(1) == entity2 || elementList1.get(0) == entity3);
        assertTrue(elementList1.get(2) == entity1 || elementList1.get(2) == entity2 || elementList1.get(0) == entity3);
        assertNotSame(elementList1.get(0), dummyList.get(2));
        assertNotSame(elementList1.get(1), dummyList.get(2));
        assertNotSame(elementList1.get(2), dummyList.get(2));
        reps0 = 0;
        reps1 = 0;
        reps2 = 0;
        for (Entity e : elementList0) {
            if (e == entity1) {
                reps0++;
            }
            else if (e == entity2) {
                reps1++;
            }
            else if (e == entity3) {
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


        assertEquals(elementList2.size(), 3);
        assertEquals(elementList2.size(), 3);
        assertEquals(elementList2.size(), 3);
        assertTrue(elementList2.get(0) == entity1 || elementList2.get(0) == entity2 || elementList2.get(0) == entity3);
        assertTrue(elementList2.get(1) == entity1 || elementList2.get(1) == entity2 || elementList2.get(0) == entity3);
        assertTrue(elementList2.get(2) == entity1 || elementList2.get(2) == entity2 || elementList2.get(0) == entity3);
        assertNotSame(elementList2.get(0), dummyList.get(2));
        assertNotSame(elementList2.get(1), dummyList.get(2));
        assertNotSame(elementList2.get(2), dummyList.get(2));
        reps0 = 0;
        reps1 = 0;
        reps2 = 0;
        for (Entity e : elementList0) {
            if (e == entity1) {
                reps0++;
            }
            else if (e == entity2) {
                reps1++;
            }
            else if (e == entity3) {
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
        List<Entity> elementList = getter.randomArrayElementsWithReps(dummyList, 2, 3);
        assertEquals(elementList.size(), 3);

        assertTrue(elementList.get(0) == entity1 || elementList.get(0) == entity2 || elementList.get(0) == entity3);
        assertTrue(elementList.get(1) == entity1 || elementList.get(1) == entity2 || elementList.get(0) == entity3);
        assertTrue(elementList.get(2) == entity1 || elementList.get(2) == entity2 || elementList.get(0) == entity3);

        for (Entity o : dummyList) {
            int reps = 0;
            for (Entity e : elementList) {
                if (e == o)
                    reps++;
            }
            if (reps > 2)
                fail();
        }
    }

    @Test
    void testRandomArrayWithAnyReps() {
        List<Entity> elementList = getter.randomArrayElementsWithAnyReps(dummyList, 2);
        assertEquals(elementList.size(), 2);
        assertTrue(elementList.get(0) == entity1 || elementList.get(0) == entity2 || elementList.get(0) == entity3);
        assertTrue(elementList.get(1) == entity1 || elementList.get(1) == entity2 || elementList.get(0) == entity3);
    }
}
