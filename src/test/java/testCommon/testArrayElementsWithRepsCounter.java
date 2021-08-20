package testCommon;

import common.ArrayElementsWithRepsCounter;
import org.junit.jupiter.api.Test;
import scenarioGenerator.pojos.Mission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testArrayElementsWithRepsCounter {

    List<Mission> elementList0 = new ArrayList<>(Arrays.asList(
            new Mission(), new Mission(), new Mission(), new Mission(), new Mission()
    ));
    List<Mission> elementList1 = new ArrayList<>(Arrays.asList(
            new Mission(), new Mission(), new Mission(), new Mission(), new Mission()
    ));

    List<Integer> repList0 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    List<Integer> repList1 = new ArrayList<>(Arrays.asList(6,67,32,2,1));

    List<List<Mission>> elementTotalList = new ArrayList<>(Arrays.asList(elementList0, elementList1));
    List<List<Integer>> repTotalList = new ArrayList<>(Arrays.asList(repList0, repList1));

    @Test
    void testCount1DInt(){
        assertEquals(20, ArrayElementsWithRepsCounter.count(elementList0, 4));
        assertEquals(25, ArrayElementsWithRepsCounter.count(elementList1, 5));
    }

    @Test
    void testCount1dArray(){
        assertEquals(15, ArrayElementsWithRepsCounter.count(elementList0, repList0));
        assertEquals(108, ArrayElementsWithRepsCounter.count(elementList1, repList1));
    }

    @Test
    void testCount2DInt(){
        assertEquals(50, ArrayElementsWithRepsCounter.count2D(elementTotalList, 5));
    }

    @Test
    void testCount2DArray(){
        assertEquals(123, ArrayElementsWithRepsCounter.count2D(elementTotalList, repTotalList));
    }
}
