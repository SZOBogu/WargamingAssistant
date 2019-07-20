package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.RandomIndexGenerator;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testRandomIndexGenerator {
    RandomIndexGenerator randomIndexGenerator = new RandomIndexGenerator();
    ArrayList<Integer> indexes0 = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 13));

    ArrayList<Integer> indexes1 = new ArrayList<>(Arrays.asList(1, 4, 9, 16, 25, 36));
    ArrayList<Integer> indexes2 = new ArrayList<>(Arrays.asList(1, 12, 32, 43, 54, 56));
    ArrayList<Integer> indexes3 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11));

    ArrayList<ArrayList<Integer>> indexList = new ArrayList<ArrayList<Integer>>(Arrays.asList(indexes1, indexes2, indexes3));
    @Test
    void testGetIndex(){
        int index = randomIndexGenerator.getIndex(indexes0);
        assertTrue(indexes0.contains(index));
    }

    @Test
    void testGetIndexes(){
        ArrayList<Integer> indexes = randomIndexGenerator.getIndexes(indexList);
        assertTrue(indexList.get(0).contains(indexes.get(0)));
        assertTrue(indexList.get(1).contains(indexes.get(1)));
        assertTrue(indexList.get(2).contains(indexes.get(2)));
    }
}
