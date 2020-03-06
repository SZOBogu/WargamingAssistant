package diceRollSimulator;

import java.util.ArrayList;

public class SuccessChecker {

    public int countSuccesses(ArrayList<Integer> results, int successValue){
        int successes = 0;
        for (Integer result : results) {
            if (result >= successValue) {
                successes += 1;
            }
        }
        return successes;
    }

    public int countFailures(ArrayList<Integer> results, int successValue){
        return results.size() - this.countSuccesses(results, successValue);
    }
}
