package diceRollSimulator;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private DiceRoll diceRoll;

    public FormEvent(Object source, DiceRoll diceRoll){
        super(source);
        this.diceRoll = diceRoll;
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public DiceRoll getDiceRoll() {
        return diceRoll;
    }
}
