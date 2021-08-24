package diceRollSimulator.pojos;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DiceRollList {
    private final List<DiceRoll> diceRolls;

    public DiceRollList(){
        this.diceRolls = new ArrayList<>();
    }

    public List<DiceRoll> getDiceRolls(){
        return this.diceRolls;
    }

    public void addDiceRoll(DiceRoll diceRoll){
        this.diceRolls.add(diceRoll);
    }

    public void removeDiceRoll(int index) { this.diceRolls.remove(index); }

    public void clear() { this.diceRolls.clear(); }
}
