package testDiceRollSimulator;

import diceRollSimulator.SuccessChecker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class testSuccessChecker {
    public static ArrayList<Integer> results = new ArrayList<Integer>();

    @BeforeAll
    public static void setup(){
        results.add(1);
        results.add(2);
        results.add(3);
        results.add(4);
        results.add(5);
        results.add(6);
    }

    @Test
    public void testCountSuccesses(){
        SuccessChecker checker = new SuccessChecker();
        int successes = checker.countSuccesses(results, 3);
        assertEquals(successes, 4);
    }

    @Test
    public void testCountFailures(){
        SuccessChecker checker = new SuccessChecker();
        int successes = checker.countFailures(results, 3);
        assertEquals(successes, 2);
    }
}
