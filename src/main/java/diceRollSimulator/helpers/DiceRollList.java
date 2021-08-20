package diceRollSimulator.helpers;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DiceRollList {
    private final ArrayList<DiceRoll> diceRolls;

    public DiceRollList(){
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
