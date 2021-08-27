import React from "react";

function DiceRollInfo(props){
    return (
        <div>
            <p> Dice quantity: {props.diceRoll.quantity} </p>
            <p> Minimal roll for success: {props.diceRoll.successValue} </p>
            <p> Should there be rerolls : {props.diceRoll.reroll.toString()} </p>
            <p> Re roll of specific value: {props.diceRoll.valueToReRoll} </p>
            <p> Should failures be counted: {props.diceRoll.failures.toString()} </p>
            <p> How many dice sides: {props.diceRoll.diceSides} </p>
        </div>
    );
}

export default DiceRollInfo;