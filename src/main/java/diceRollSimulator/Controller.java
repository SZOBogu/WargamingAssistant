package diceRollSimulator;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class Controller {
    private Database db;

    public ArrayList<DiceRoll> getDiceRolls(){
        return db.getDiceRolls();
    }

    public void addDiceRoll(FormEvent event){
        int quantity = event.getDiceRoll().getQuantity();
        int successValue = event.getDiceRoll().getSuccessValue();
        boolean reroll = event.getDiceRoll().isReroll();
        int valueToReRoll = event.getDiceRoll().getValueToReRoll();
        boolean failures = event.getDiceRoll().isFailures();
        int diceSides = event.getDiceRoll().getDiceSides();

        DiceRoll roll = new DiceRoll.DiceRollBuilder(quantity, successValue)
                        .reroll(reroll)
                        .valueToReRoll(valueToReRoll)
                        .failures(failures)
                        .diceSides(diceSides)
                        .build();

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
        return NonRandomReportGenerator.generateReport(this.getDiceRolls());
    }

    public Database getDb() {
        return db;
    }

    @Autowired
    public void setDb(Database db) {
        this.db = db;
    }
}
