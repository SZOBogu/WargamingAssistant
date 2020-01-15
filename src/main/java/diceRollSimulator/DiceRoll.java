package diceRollSimulator;

import common.Dice;

import java.util.ArrayList;
import java.util.Objects;

public class DiceRoll {
    private int quantity;
    private int successValue;
    private boolean reroll;
    private int valueToReRoll;
    private boolean failures;
    private int diceSides;


    public DiceRoll(int quantity, int successValue, boolean reroll, boolean failures, int diceSides){
        this(quantity, successValue, reroll, failures, diceSides, -1);
    }

    public DiceRoll(int quantity, int successValue, boolean reroll, boolean failures, int diceSides, int valueToReRoll){
        this.quantity = quantity;
        this.successValue = successValue;
        this.reroll = reroll;
        this.valueToReRoll = valueToReRoll;
        this.failures = failures;
        this.diceSides = diceSides;
        if(this.valueToReRoll > 0 && this.isReroll() == true){
            this.reroll = false;
        }
    }

    public ArrayList<Integer> rollDices() {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < this.quantity; i++){
            Dice dice = new Dice(this.diceSides);
            Integer res = dice.roll();
            result.add(res);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> makeDiceRoll(){
        ArrayList<ArrayList<Integer>> bothResults = new ArrayList();
        ArrayList<Integer> result = new ArrayList();
        ArrayList<Integer> resultRerolled = new ArrayList();
        result = this.rollDices();
        bothResults.add(result);

        for (int i= 0; i<result.size(); i++){
            resultRerolled.add(new Integer(result.get(i)));      //deep copy substitute, fuck the police
        }

        if(this.reroll == true){
            //regular reroll of non passed dices
            for (int i= 0; i<result.size(); i++){
                if(resultRerolled.get(i) <= this.successValue) {
                    Dice dice = new Dice(this.diceSides);
                    resultRerolled.remove(i);
                    resultRerolled.add(i, dice.roll());
                }
//                else if(resultRerolled.get(i) >= this.successValue && this.failures == true){
//                    common.Dice dice = new common.Dice(this.diceSides);
//                    resultRerolled.remove(i);
//                    resultRerolled.add(i, dice.roll());
//                }
            }
            bothResults.add(resultRerolled);
        }

        //reroll of specific result
        else if(this.valueToReRoll > 0) {
            for (int i= 0; i<result.size(); i++) {
                if (resultRerolled.get(i) == this.valueToReRoll) {
                    resultRerolled.remove(i);
                    Dice dice = new Dice(this.diceSides);
                    resultRerolled.add(i, dice.roll());
                }
            }
            bothResults.add(resultRerolled);
        }

        return bothResults;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSuccessValue() {
        return successValue;
    }

    public void setSuccessValue(int successValue) {
        this.successValue = successValue;
    }

    public boolean isReroll() {
        return reroll;
    }

    public void setReroll(boolean reroll) {
        this.reroll = reroll;
    }

    public int getValueToReRoll() {
        return valueToReRoll;
    }

    public void setValueToReRoll(int valueToReRoll) {
        this.valueToReRoll = valueToReRoll;
    }

    public boolean isFailures() {
        return failures;
    }

    public void setFailures(boolean failures) {
        this.failures = failures;
    }

    public int getDiceSides() {
        return diceSides;
    }

    public void setDiceSides(int diceSides) {
        this.diceSides = diceSides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiceRoll)) return false;
        DiceRoll diceRoll = (DiceRoll) o;
        return getQuantity() == diceRoll.getQuantity() &&
                successValue == diceRoll.successValue &&
                reroll == diceRoll.reroll &&
                failures == diceRoll.failures &&
                diceSides == diceRoll.diceSides &&
                valueToReRoll == diceRoll.valueToReRoll;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuantity(), successValue, reroll, valueToReRoll, failures, diceSides);
    }

    @Override
    public String toString() {
        String description = "D" + diceSides + " roll on " + successValue;
        if(this.isFailures()) description += "-";
        else description +="+";

        if(this.reroll == true) description += " with reroll";
        if(this.valueToReRoll > 0) description += " with reroll of " + valueToReRoll + "s";

        return description;
    }
}