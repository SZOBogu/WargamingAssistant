package diceRollSimulator;

import java.util.ArrayList;

public class StreamRunner {
    private ReportGenerator reportGenerator = new ReportGenerator();

    public int runDiceRoll(DiceRoll diceRoll, int number){
        ArrayList<ArrayList<Integer>> results = diceRoll.makeDiceRoll();
        SuccessChecker checker = new SuccessChecker();
        int successes;
        if(results.size() == 1 && diceRoll.isFailures() == false)
            successes = checker.countSuccesses(results.get(0), diceRoll.getSuccessValue());
        else if(results.size() == 1 && diceRoll.isFailures() == true)
            successes = checker.countFailures(results.get(0), diceRoll.getSuccessValue());
        else if(results.size() == 2 && diceRoll.isFailures() == false)
            successes = checker.countSuccesses(results.get(1), diceRoll.getSuccessValue());
        else
            successes = checker.countFailures(results.get(1), diceRoll.getSuccessValue());

        if(diceRoll.getValueToReRoll() > 0)
            reportGenerator.addDiceRoll(results, number, successes, diceRoll.getSuccessValue(), diceRoll.isFailures(), diceRoll.getValueToReRoll());
        else
            reportGenerator.addDiceRoll(results, number, successes, diceRoll.getSuccessValue(), diceRoll.isFailures());

        return successes;
    }

    public String runAll(ArrayList<DiceRoll> diceRolls){
        int successes = 0;
        for(int i=0; i < diceRolls.size(); i++){
            successes = runDiceRoll(diceRolls.get(i), i);
            if(i < diceRolls.size() - 1)    diceRolls.get(i + 1).setQuantity(successes);
        }
        return this.reportGenerator.generateReport(diceRolls, successes);
    }

    public String getReport(){
        return this.reportGenerator.getReport();
    }
}
