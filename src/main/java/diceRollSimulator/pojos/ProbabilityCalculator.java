package diceRollSimulator.pojos;

import diceRollSimulator.helpers.DiceRoll;

public class ProbabilityCalculator {
    public double calculateChanceOfNonRerolledSuccess(DiceRoll diceRoll){
        return ((double)diceRoll.getDiceSides() - (double)diceRoll.getSuccessValue() + 1.) / (double)diceRoll.getDiceSides();
    }
    public double calculateChanceOfRerolledSuccess(DiceRoll diceRoll){
        double chanceOfNonRerolledSuccess = this.calculateChanceOfNonRerolledSuccess(diceRoll);
        return chanceOfNonRerolledSuccess + (1 - chanceOfNonRerolledSuccess) * chanceOfNonRerolledSuccess;
    }
    public double calculateChanceOfSuccessAfterFavourableSingleValueReRoll(DiceRoll diceRoll){
        double chanceOfNonRerolledSuccess = this.calculateChanceOfNonRerolledSuccess(diceRoll);
        return chanceOfNonRerolledSuccess + (
                (1 - chanceOfNonRerolledSuccess)/(double)diceRoll.getDiceSides()) * chanceOfNonRerolledSuccess;
    }
    public double calculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(DiceRoll diceRoll){
        double chanceOfNonRerolledSuccess = this.calculateChanceOfNonRerolledSuccess(diceRoll);
        return (chanceOfNonRerolledSuccess - 1/(double)diceRoll.getDiceSides()) +
                ((1 - (chanceOfNonRerolledSuccess - 1/(double)diceRoll.getDiceSides()))
                        * 1/(double)diceRoll.getDiceSides()) * chanceOfNonRerolledSuccess;
    }

    public double calculateProbability(DiceRoll diceRoll){
        double chance = 0;
        double chanceOfNonRerolledSuccess =
                this.calculateChanceOfNonRerolledSuccess(diceRoll);
        double chanceOfRerolledSuccess =
                this.calculateChanceOfRerolledSuccess(diceRoll);
        double chanceOfSuccessAfterFavourableSingleValueReRoll =
                this.calculateChanceOfSuccessAfterFavourableSingleValueReRoll(diceRoll);
        double chanceOfSuccessAfterNonFavourableSingleValueReRoll =
                this.calculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(diceRoll);

        //rolls with rerolls
        if(diceRoll.isReroll()){
            if(diceRoll.isFailures())
                chance = 1 - chanceOfRerolledSuccess;             //chance of failure of single dice roll with reroll
            else if(!diceRoll.isFailures())
                chance = chanceOfRerolledSuccess;             //chance of success of single dice roll with reroll
        }
        //re roll of single value
        else if(diceRoll.getValueToReRoll() > 0){
            if(diceRoll.isFailures()){
                if(diceRoll.getValueToReRoll() > diceRoll.getDiceSides())   //badly filled form, can happen
                    chance = 1 - chanceOfNonRerolledSuccess;
                else if(diceRoll.getValueToReRoll() >= diceRoll.getSuccessValue())
                    chance = 1 - chanceOfSuccessAfterNonFavourableSingleValueReRoll;
                else if(diceRoll.getValueToReRoll() < diceRoll.getSuccessValue())
                    chance = 1 - chanceOfSuccessAfterFavourableSingleValueReRoll;
            }
            else if(!diceRoll.isFailures()){
                if(diceRoll.getValueToReRoll() > diceRoll.getDiceSides())   //badly filled form, can happen
                    chance = chanceOfNonRerolledSuccess;
                else if(diceRoll.getValueToReRoll() >= diceRoll.getSuccessValue())
                    chance = chanceOfSuccessAfterNonFavourableSingleValueReRoll;
                else if(diceRoll.getValueToReRoll() < diceRoll.getSuccessValue())
                    chance = chanceOfSuccessAfterFavourableSingleValueReRoll;
            }
        }
        //rolls without any rerolls
        else if(diceRoll.isFailures() && !diceRoll.isReroll())
            chance = (1 - chanceOfNonRerolledSuccess);
        else if(!diceRoll.isFailures() && !diceRoll.isReroll())
            chance = chanceOfNonRerolledSuccess;

        return chance;
    }
}
