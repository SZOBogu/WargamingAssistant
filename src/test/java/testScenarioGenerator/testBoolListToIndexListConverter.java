package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.BoolListToIndexListConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBoolListToIndexListConverter {
    List<Boolean> test0 = new ArrayList<>(Arrays.asList(true, true, true, true, true, true));
    List<Boolean> test1 = new ArrayList<>(Arrays.asList(true, true, true, false, false, true));
    List<Boolean> test2 = new ArrayList<>(Arrays.asList(false, false, false, false, false, false));
    List<List<Boolean>> testList = new ArrayList<>(Arrays.asList(test0, test1, test2));

    @Test
    void testConvert(){
        List<Integer> indexesTest0 = BoolListToIndexListConverter.convertList(test0);
        List<Integer> indexesTest1 = BoolListToIndexListConverter.convertList(test1);
        List<Integer> indexesTest2 = BoolListToIndexListConverter.convertList(test2);

        assertEquals(6, indexesTest0.size());
        assertEquals(0, (int)indexesTest0.get(0));
        assertEquals(1, (int)indexesTest0.get(1));
        assertEquals(2, (int)indexesTest0.get(2));
        assertEquals(3, (int)indexesTest0.get(3));
        assertEquals(4, (int)indexesTest0.get(4));
        assertEquals(5, (int)indexesTest0.get(5));

        assertEquals(4, indexesTest1.size());
        assertEquals(0, (int)indexesTest1.get(0));
        assertEquals(1, (int)indexesTest1.get(1));
        assertEquals(2, (int)indexesTest1.get(2));
        assertEquals(5, (int)indexesTest1.get(3));

        assertEquals(0, indexesTest2.size());
    }

    @Test
    void testList(){
        List<List<Integer>> indexesTest = BoolListToIndexListConverter.convert2dList(testList);
        assertEquals(3, indexesTest.size());
        assertEquals(6,indexesTest.get(0).size());
        assertEquals(4,indexesTest.get(1).size());
        assertEquals(0,indexesTest.get(2).size());
    }
}
