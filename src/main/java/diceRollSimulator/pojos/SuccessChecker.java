package diceRollSimulator.pojos;

import java.util.ArrayList;
import java.util.List;

public class SuccessChecker {
    public static int countSuccesses(List<Integer> results, int successValue){
        int successes = 0;
        for (Integer result : results) {
            if (result >= successValue) {
                successes += 1;
            }
        }
        return successes;
    }

    public static int countFailures(List<Integer> results, int successValue){
        return results.size() - SuccessChecker.countSuccesses(results, successValue);
    }
}
