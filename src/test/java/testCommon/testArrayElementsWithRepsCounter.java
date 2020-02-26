package testCommon;

import common.ArrayElementsWithRepsCounter;
import org.junit.jupiter.api.Test;
import scenarioGenerator.Mission;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testArrayElementsWithRepsCounter {
    ArrayElementsWithRepsCounter counter = new ArrayElementsWithRepsCounter();

    ArrayList<Mission> elementList0 = new ArrayList<>(Arrays.asList(
            new Mission(), new Mission(), new Mission(), new Mission(), new Mission()
    ));
    ArrayList<Mission> elementList1 = new ArrayList<>(Arrays.asList(
            new Mission(), new Mission(), new Mission(), new Mission(), new Mission()
    ));

    ArrayList<Integer> repList0 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    ArrayList<Integer> repList1 = new ArrayList<>(Arrays.asList(6,67,32,2,1));

    ArrayList<ArrayList<Mission>> elementTotalList = new ArrayList<>(Arrays.asList(elementList0, elementList1));
    ArrayList<ArrayList<Integer>> repTotalList = new ArrayList<>(Arrays.asList(repList0, repList1));

    @Test
    void testCount1DInt(){
        assertEquals(20, counter.count(elementList0, 4));
        assertEquals(25, counter.count(elementList1, 5));
    }

    @Test
    void testCount1dArray(){
        assertEquals(15, counter.count(elementList0, repList0));
        assertEquals(108, counter.count(elementList1, repList1));
    }

    @Test
    void testCount2DInt(){
        assertEquals(50, counter.count2D(elementTotalList, 5));
    }

    @Test
    void testCount2DArray(){
        assertEquals(123, counter.count2D(elementTotalList, repTotalList));
    }
}
