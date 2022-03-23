package testCommon;

import common.RandomArrayElementsGetter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import rosterBuilder.entities.Entity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testRandomArrayElementsGetter {
    Entity entity1 = Mockito.mock(Entity.class);
    Entity entity2 = Mockito.mock(Entity.class);
    Entity entity3 = Mockito.mock(Entity.class);
    List<Entity> dummyList = Arrays.asList(entity1, entity2, entity3);

    @Test
    void testRandomArrayWithoutReps() {
        List<Entity> elementList = RandomArrayElementsGetter.randomArrayElementsWithoutReps(dummyList, 2);

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
        List<Entity> elementList0 = RandomArrayElementsGetter.randomArrayElementsWithReps(dummyList, repList, 3);
        List<Entity> elementList1 = RandomArrayElementsGetter.randomArrayElementsWithReps(dummyList, tooShortRepList, 3);
        List<Entity> elementList2 = RandomArrayElementsGetter.randomArrayElementsWithReps(dummyList, tooLongRepList, 3);

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
            for (Entity e : elementList0)
                System.out.print(e + " ");
            fail();
        }
        if(reps1 > 2){
            for (Entity e : elementList0)
                System.out.print(e + " ");
            fail();
        }

        assertEquals(elementList1.size(), 3);
        assertEquals(elementList1.size(), 3);
        assertEquals(elementList1.size(), 3);
        assertTrue(elementList1.get(0) == entity1 || elementList1.get(0) == entity2 || elementList1.get(0) == entity3);
        assertTrue(elementList1.get(1) == entity1 || elementList1.get(1) == entity2 || elementList1.get(1) == entity3);
        assertTrue(elementList1.get(2) == entity1 || elementList1.get(2) == entity2 || elementList1.get(2) == entity3);
        reps0 = 0;
        reps1 = 0;
        reps2 = 0;
        for (Entity e : elementList1) {
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
            for (Entity e : elementList1)
                System.out.print(e + " ");
            fail();
        }
        if(reps1 > 1){
            for (Entity e : elementList1)
                System.out.print(e + " ");
            fail();
        }
        if(reps2 > 1){
            for (Entity e : elementList1)
                System.out.print(e + " ");
            fail();
        }

        assertEquals(elementList2.size(), 3);
        assertEquals(elementList2.size(), 3);
        assertEquals(elementList2.size(), 3);
        assertTrue(elementList2.get(0) == entity1 || elementList2.get(0) == entity2 || elementList2.get(0) == entity3);
        assertTrue(elementList2.get(1) == entity1 || elementList2.get(1) == entity2 || elementList2.get(1) == entity3);
        assertTrue(elementList2.get(2) == entity1 || elementList2.get(2) == entity2 || elementList2.get(2) == entity3);
        reps0 = 0;
        reps1 = 0;
        reps2 = 0;
        for (Entity e : elementList2) {
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
            elementList2.forEach(System.out::println);
            fail();
        }
        if(reps1 > 1){
            elementList2.forEach(System.out::println);
            fail();
        }
        if(reps2 > 7){
            elementList2.forEach(System.out::println);
            fail();
        }
    }

    @Test
    void testRandomArrayWithRepsInt() {
        List<Entity> elementList = RandomArrayElementsGetter.randomArrayElementsWithReps(dummyList, 2, 3);
        assertEquals(elementList.size(), 3);

        assertTrue(elementList.get(0) == entity1 || elementList.get(0) == entity2 || elementList.get(0) == entity3);
        assertTrue(elementList.get(1) == entity1 || elementList.get(1) == entity2 || elementList.get(1) == entity3);
        assertTrue(elementList.get(2) == entity1 || elementList.get(2) == entity2 || elementList.get(2) == entity3);

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
        List<Entity> elementList = RandomArrayElementsGetter.randomArrayElementsWithAnyReps(dummyList, 2);
        assertEquals(elementList.size(), 2);
        assertTrue(elementList.get(0) == entity1 || elementList.get(0) == entity2 || elementList.get(0) == entity3);
        assertTrue(elementList.get(1) == entity1 || elementList.get(1) == entity2 || elementList.get(1) == entity3);
    }
}
