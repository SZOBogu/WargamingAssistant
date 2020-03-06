package diceRollSimulator;

import java.util.ArrayList;

public class Controller {
    Database db = new Database();

    public ArrayList<DiceRoll> getDiceRolls(){
        return db.getDiceRolls();
    }

    public void addDiceRoll(FormEvent event){
        int quantity = event.getQuantity();
        int successValue = event.getSuccessValue();
        boolean reroll = event.isReroll();
        int valueToReRoll = event.getValueToReRoll();
        boolean failures = event.isFailures();
        int diceSides = event.getDiceSides();

        DiceRoll roll = new DiceRoll(quantity, successValue, reroll, failures, diceSides, valueToReRoll);
        db.addDiceRoll(roll);
    }

    public void removeDiceRoll(int row) {
        db.removeDiceRoll(row);
    }

    public void clear() {db.clear();}

    public String run(){
        StreamRunner runner = new StreamRunner();
        return runner.runAll(this.getDiceRolls());
    }

    public String runNonRandom(){
        NonRandomReportGenerator runner = new NonRandomReportGenerator();
        return runner.generateReport(this.getDiceRolls());
    }
}
