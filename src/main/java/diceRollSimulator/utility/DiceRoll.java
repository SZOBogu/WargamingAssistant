package diceRollSimulator.utility;

import common.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiceRoll {
    private int quantity;
    private final int successValue;
    private final boolean reroll;
    private final int valueToReRoll;
    private final boolean failures;
    private final int diceSides;

    public DiceRoll(){
        this.quantity = 0;
        this.successValue = 0;
        this.reroll = false;
        this.valueToReRoll = -1;
        this.failures = false;
        this.diceSides = 6;
    }

    public DiceRoll(DiceRollBuilder builder){
        this.quantity = builder.quantity;
        this.successValue = builder.successValue;
        this.reroll = builder.reroll;
        this.valueToReRoll = builder.valueToReRoll;
        this.failures = builder.failures;
        this.diceSides = builder.diceSides;
    }

    public static class DiceRollBuilder{
        private final int quantity;
        private final int successValue;
        private boolean reroll;
        private int valueToReRoll;
        private boolean failures;
        private int diceSides;

        public DiceRollBuilder(int quantity, int successValue){
            this.quantity = quantity;
            this.successValue = successValue;

            this.reroll = false;
            this.valueToReRoll = -1;
            this.failures = false;
            this.diceSides = 6;
        }

        public DiceRollBuilder reroll(boolean reroll){
            this.reroll = reroll;
            return this;
        }

        public DiceRollBuilder valueToReRoll(int valueToReRoll){
            this.valueToReRoll = valueToReRoll;

            return this;
        }

        public DiceRollBuilder failures(boolean failures){
            this.failures = failures;
            return this;
        }

        public DiceRollBuilder diceSides(int diceSides){
            if(diceSides < 2)
                this.diceSides = 6;
            else
                this.diceSides = diceSides;
            return this;
        }

        public DiceRoll build(){
            return new DiceRoll(this);
        }
    }

    public List<Integer> rollDices() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < this.quantity; i++){
            Dice dice = new Dice(this.diceSides);
            Integer res = dice.roll();
            result.add(res);
        }
        return result;
    }

    public List<List<Integer>> makeDiceRoll(){
        List<List<Integer>> bothResults = new ArrayList<>();
        List<Integer> result = this.rollDices();
        bothResults.add(result);

        List<Integer> resultRerolled = new ArrayList<>(result);

        if(this.reroll){
            //regular reroll of non passed dices
            for (int i= 0; i< result.size(); i++){
                if(resultRerolled.get(i) < this.successValue) {
                    Dice dice = new Dice(this.diceSides);
                    resultRerolled.remove(i);
                    resultRerolled.add(i, dice.roll());
                }
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

        if(this.reroll) description += " with reroll";
        if(this.valueToReRoll > 0) description += " with reroll of " + valueToReRoll + "s";

        return description;
    }
}