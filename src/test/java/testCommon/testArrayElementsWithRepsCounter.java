package testCommon;

import common.ArrayElementsWithRepsCounter;
import org.junit.jupiter.api.Test;
import scenarioGenerator.Mission;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testArrayElementsWithRepsCounter {
    ArrayElementsWithRepsCounter counter = new ArrayElementsWithRepsCounter();

    ArrayList<Mission> elementList = new ArrayList<>(Arrays.asList(
            new Mission(), new Mission(), new Mission(), new Mission(), new Mission()
    ));

    ArrayList<Integer> repList0 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    ArrayList<Integer> repList1 = new ArrayList<>(Arrays.asList(6,67,32,2,1));

    ArrayList<ArrayList<Integer>> totalList = new ArrayList<>(Arrays.asList(repList0, repList1));

    @Test
    void testCount1DInt(){
        assertEquals(20, counter.count(elementList, 4));
    }

    @Test
    void testCount1dArray(){
        assertEquals(15, counter.count(elementList, repList0));
    }

    @Test
    void testCount2DInt(){

    }

    @Test
    void testCount2DArray(){

    }
}
