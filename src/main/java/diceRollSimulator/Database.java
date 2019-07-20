package diceRollSimulator;

import java.util.ArrayList;

public class Database {
    private ArrayList<DiceRoll> diceRolls;

    public Database(){
        this.diceRolls = new ArrayList<>();
    }

    public ArrayList<DiceRoll> getDiceRolls(){
        return this.diceRolls;
    }

    public void addDiceRoll(DiceRoll diceRoll){
        this.diceRolls.add(diceRoll);
    }

    public void removeDiceRoll(int index) { this.diceRolls.remove(index); }

    public void clear() { this.diceRolls.clear(); }
}
