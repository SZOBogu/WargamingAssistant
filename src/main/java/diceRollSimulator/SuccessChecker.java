package diceRollSimulator;

import java.util.ArrayList;

public class SuccessChecker {

    public int countSuccesses(ArrayList<Integer> results, int successValue){
        int successes = 0;
        for(int i =0; i<results.size(); i++){
            if(results.get(i) >= successValue){
                successes += 1;
            }
        }
        return successes;
    }

    public int countFailures(ArrayList<Integer> results, int successValue){
        int failures = results.size() - this.countSuccesses(results, successValue);
        return failures;
    }
}
