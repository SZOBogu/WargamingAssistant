package diceRollSimulator;

import java.util.ArrayList;

public class NonRandomReportGenerator {
    public String generateReport(ArrayList<DiceRoll> diceRolls){
        StringBuilder report = new StringBuilder();
        ArrayList<Double> probabilities = new ArrayList<>();
        ProbabilityCalculator calculator = new ProbabilityCalculator();
        double totalSuccessProbability = 1.0;
        if(diceRolls.size() > 0) {
            double successChance = 1;
            for (DiceRoll diceRoll : diceRolls) {
                double probability = calculator.calculateProbability(diceRoll);
                probabilities.add(probability);
                successChance *= probability;
            }
            report = new StringBuilder("TOTAL RESULT: " + successChance * diceRolls.get(0).getQuantity() + " SUCCESSES\n"
                    + diceRolls.get(0).getQuantity() + " dices\n");
            for (int i = 0; i < diceRolls.size(); i++) {
                report.append(i + 1).append(".").append(diceRolls.get(i).toString()).append("\n");
            }
            for (int i = 0; i < diceRolls.size(); i++) {
                report.append("common.Dice Roll ").append(i + 1).append(": probability of single dice success: ")
                        .append(probabilities.get(i)).append("\n");
                totalSuccessProbability *= probabilities.get(i);
            }


            report.append("Probability of Total Success: ").append(totalSuccessProbability);
        }
        else{
            report = new StringBuilder("TOTAL RESULT: 0 SUCCESSES\n"
                    + "0 dices\n");
        }
        return report.toString();
    }
}
