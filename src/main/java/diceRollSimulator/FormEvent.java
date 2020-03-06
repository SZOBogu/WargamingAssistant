package diceRollSimulator;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private int quantity;
    private int successValue;
    private boolean reroll;
    private int valueToReRoll;
    private boolean failures;
    private int diceSides;

    public FormEvent(Object source, DiceRoll diceRoll){
        super(source);
        this.quantity = diceRoll.getQuantity();
        this.successValue = diceRoll.getSuccessValue();
        this.reroll = diceRoll.isReroll();
        this.valueToReRoll = diceRoll.getValueToReRoll();
        this.failures = diceRoll.isFailures();
        this.diceSides = diceRoll.getDiceSides();
    }

    public FormEvent(Object source, int quantity, int successValue,
                     boolean reroll, boolean failures, int diceSides, int valueToReRoll){
        super(source);
        this.quantity = quantity;
        this.successValue = successValue;
        this.reroll = reroll;
        this.failures = failures;
        this.diceSides = diceSides;
        this.valueToReRoll = valueToReRoll;
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSuccessValue() {
        return successValue;
    }

    public boolean isReroll() {
        return reroll;
    }

    public int getValueToReRoll() {
        return valueToReRoll;
    }

    public boolean isFailures() {
        return failures;
    }

    public int getDiceSides() {
        return diceSides;
    }

}
