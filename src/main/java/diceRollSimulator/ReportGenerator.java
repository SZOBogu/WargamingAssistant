package diceRollSimulator;

import java.util.ArrayList;

public class ReportGenerator {
    private String report;

    public ReportGenerator(){
        this.report = "";
    }

    public String getReport() {
        return report;
    }
    public void setReport(String report){
        this.report = report;
    }

    //TODO: DRY
    public void addDiceRoll(ArrayList<ArrayList<Integer>> results, int number, int successes, int successValue, boolean failures){
        for (int i = 0; i<results.size(); i++) {
            this.report += "Dice Roll " + number + ": " + successes + " successes (" + successValue;

            if (failures == true)   this.report += "-";
            else                    this.report += "+";

            if(results.size() == 1)   this.report += "). ";
            else                    this.report += " rerolled). ";

            if (i==0 && results.size() == 1) this.report += "Results:\n";
            else if(i == 0)              this.report += "Results non rerolled:\n";
            else                    this.report += "Results rerolled:\n";

            for (int j = 0; j < results.get(i).size(); j++) {
                this.report += results.get(i).get(j) + " ";
            }
            this.report += "\n";
        }
    }

    public void addDiceRoll(ArrayList<ArrayList<Integer>> results, int number, int successes, int successValue, boolean failures, int valueToReRoll) {
        for (int i = 0; i<results.size(); i++) {
            this.report += "Dice Roll " + number + ": " + successes + " successes (" + successValue;

            if (failures == true)   this.report += "-";
            else                    this.report += "+";


            if(valueToReRoll > 0 && results.size() == 2)   this.report += " with " + valueToReRoll + "s rerolled). ";
            else if(results.size() == 2)                    this.report += " rerolled). ";
            else                                            this.report += "). ";

            if (i==0 && results.size() == 1) this.report += "Results:\n";
            else if(i == 0)              this.report += "Results non rerolled:\n";
            else                    this.report += "Results rerolled:\n";

            for (int j = 0; j < results.get(i).size(); j++) {
                this.report += results.get(i).get(j) + " ";
            }
            this.report += "\n";
        }
    }

    public String generateReport(ArrayList<DiceRoll> diceRolls, int successes){
        String finalRep = "TOTAL RESULT: " + successes + " SUCCESSES\n";
        if(diceRolls.size() > 0) {
            finalRep += diceRolls.get(0).getQuantity() + " dices\n";
            for (int i = 0; i < diceRolls.size(); i++) {
                finalRep += (i + 1) + "." + diceRolls.get(i).toString() + "\n";
            }
            finalRep += this.report;
        }
        return finalRep;
    }
}
