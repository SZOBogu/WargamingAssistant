import React from "react";

function DiceRollInfo(props){
    return (
        <div>
            <p> Dice quantity: {diceRoll.quantity} </p>
            <p> Minimal roll for success: {diceRoll.successValue} </p>
            <p> Should there be rerolls : {diceRoll.reroll} </p>
            <p> Re roll of specific value: {diceRoll.valueToReRoll} </p>
            <p> Should failures be counted: {diceRoll.failures} </p>
            <p> How many dice sides: {diceRoll.diceSides} </p>
        </div>
    );
}

export default DiceRollInfo;