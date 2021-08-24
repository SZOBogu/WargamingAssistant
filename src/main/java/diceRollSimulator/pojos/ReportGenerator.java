package diceRollSimulator.pojos;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportGenerator {
    private String report;

    public ReportGenerator(){
        report = "";
    }

    public String getReport() {
        return report;
    }
    public void setReport(String report){
        this.report = report;
    }

    //TODO: DRY
    public void addDiceRoll(List<List<Integer>> results,
                                   int number, int successes, int successValue, boolean failures){

        for (int i = 0; i<results.size(); i++) {
            report += "Dice Roll " + number + ": " + successes + " successes (" + successValue;

            if (failures)   report += "-";
            else                    report += "+";

            if(results.size() == 1)   report += "). ";
            else                    report += " rerolled). ";

            if (i==0 && results.size() == 1) report += "Results:\n";
            else if(i == 0)              report += "Results non rerolled:\n";
            else                    report += "Results rerolled:\n";

            for (int j = 0; j < results.get(i).size(); j++) {
                report += results.get(i).get(j) + " ";
            }
            report += "\n";
        }
    }

    public void addDiceRoll(List<List<Integer>> results, int number, int successes, int successValue, boolean failures, int valueToReRoll) {
        for (int i = 0; i<results.size(); i++) {
            report += "Dice Roll " + number + ": " + successes + " successes (" + successValue;

            if (failures)   report += "-";
            else                    report += "+";


            if(valueToReRoll > 0 && results.size() == 2)   report += " with " + valueToReRoll + "s rerolled). ";
            else if(results.size() == 2)                    report += " rerolled). ";
            else                                            report += "). ";

            if (i==0 && results.size() == 1) report += "Results:\n";
            else if(i == 0)              report += "Results non rerolled:\n";
            else                    report += "Results rerolled:\n";

            for (int j = 0; j < results.get(i).size(); j++) {
                report += results.get(i).get(j) + " ";
            }
            report += "\n";
        }
    }

    public String generateReport(List<DiceRoll> diceRolls, int successes){
        StringBuilder finalRep = new StringBuilder("TOTAL RESULT: " + successes + " SUCCESSES\n");
        if(diceRolls.size() > 0) {
            finalRep.append(diceRolls.get(0).getQuantity()).append(" dices\n");
            for (int i = 0; i < diceRolls.size(); i++) {
                finalRep.append(i + 1).append(".").append(diceRolls.get(i).toString()).append("\n");
            }
            finalRep.append(report);
        }
        return finalRep.toString();
    }
}
