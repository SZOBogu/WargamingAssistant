package diceRollSimulator;

import java.util.ArrayList;

public class NonRandomReportGenerator {
    public String generateReport(ArrayList<DiceRoll> diceRolls){
        String report = "";
        ArrayList<Double> probabilities = new ArrayList<>();
        ProbabilityCalculator calculator = new ProbabilityCalculator();
        double totalSuccessProbability = 1.0;
        if(diceRolls.size() > 0) {
            double successChance = 1;
            for (int i = 0; i < diceRolls.size(); i++) {
                double probability = calculator.calculateProbability(diceRolls.get(i));
                probabilities.add(probability);
                successChance *= probability;
            }
            report = "TOTAL RESULT: " + successChance * diceRolls.get(0).getQuantity() + " SUCCESSES\n"
                    + diceRolls.get(0).getQuantity() + " dices\n";
            for (int i = 0; i < diceRolls.size(); i++) {
                report += (i + 1) + "." + diceRolls.get(i).toString() + "\n";
            }
            for (int i = 0; i < diceRolls.size(); i++) {
                report += "common.Dice Roll " + (i + 1) + ": probability of single dice success: " + probabilities.get(i) + "\n";
                totalSuccessProbability *= probabilities.get(i);
            }


            report += "Probability of Total Success: " + totalSuccessProbability;
        }
        else{
            report = "TOTAL RESULT: 0 SUCCESSES\n"
                    + "0 dices\n";
        }
        return report;
    }
}
