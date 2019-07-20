package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.BoolToListIndexConverter;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBoolToListIndexConverter {
    BoolToListIndexConverter converter = new BoolToListIndexConverter();
    ArrayList<Boolean> test0 = new ArrayList<>(Arrays.asList(true, true, true, true, true, true));
    ArrayList<Boolean> test1 = new ArrayList<>(Arrays.asList(true, true, true, false, false, true));
    ArrayList<Boolean> test2 = new ArrayList<>(Arrays.asList(false, false, false, false, false, false));
    ArrayList<ArrayList<Boolean>> testList = new ArrayList<>(Arrays.asList(test0, test1, test2));

    @Test
    void testConvert(){
        ArrayList<Integer> indexesTest0 = converter.convert(test0);
        ArrayList<Integer> indexesTest1 = converter.convert(test1);
        ArrayList<Integer> indexesTest2 = converter.convert(test2);

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
        ArrayList<ArrayList<Integer>> indexesTest = converter.convertList(testList);
        assertEquals(3, indexesTest.size());
        assertEquals(6,indexesTest.get(0).size());
        assertEquals(4,indexesTest.get(1).size());
        assertEquals(0,indexesTest.get(2).size());
    }
}
