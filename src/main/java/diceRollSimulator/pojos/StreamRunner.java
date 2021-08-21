package diceRollSimulator.pojos;

import diceRollSimulator.utility.DiceRoll;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StreamRunner {
    private ReportGenerator reportGenerator = new ReportGenerator();

    public int runDiceRoll(DiceRoll diceRoll, int number){
        List<List<Integer>> results = diceRoll.makeDiceRoll();

        int successes;
        if(results.size() == 1 && !diceRoll.isFailures())
            successes = SuccessChecker.countSuccesses(results.get(0), diceRoll.getSuccessValue());
        else if(results.size() == 1 && diceRoll.isFailures())
            successes = SuccessChecker.countFailures(results.get(0), diceRoll.getSuccessValue());
        else if(results.size() == 2 && !diceRoll.isFailures())
            successes = SuccessChecker.countSuccesses(results.get(1), diceRoll.getSuccessValue());
        else
            successes = SuccessChecker.countFailures(results.get(1), diceRoll.getSuccessValue());

        if(diceRoll.getValueToReRoll() > 0)
            reportGenerator.addDiceRoll(results, number, successes,
                    diceRoll.getSuccessValue(), diceRoll.isFailures(), diceRoll.getValueToReRoll());
        else
            reportGenerator.addDiceRoll(results, number, successes,
                    diceRoll.getSuccessValue(), diceRoll.isFailures());

        return successes;
    }

    public String runAll(ArrayList<DiceRoll> diceRolls){
        int successes = 0;
        for(int i=0; i < diceRolls.size(); i++){
            successes = runDiceRoll(diceRolls.get(i), i);
            if(i < diceRolls.size() - 1)    diceRolls.get(i + 1).setQuantity(successes);
        }
        return reportGenerator.generateReport(diceRolls, successes);
    }

    public String getReport(){
        return reportGenerator.getReport();
    }
}
