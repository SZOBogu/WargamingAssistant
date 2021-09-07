import React from "react";

function DiceRollInfo(props){
    return (
        <div>
            <b> Dice quantity: </b> {props.diceRoll.quantity} <br/>
            <b> Minimal roll for success: </b> {props.diceRoll.successValue} <br/>
            <b> Should there be rerolls : </b> {props.diceRoll.reroll.toString()} <br/>
            <b> Re roll of specific value: </b> {props.diceRoll.valueToReRoll} <br/>
            <b> Should failures be counted: </b> {props.diceRoll.failures.toString()} <br/>
            <b> How many dice sides: </b> {props.diceRoll.diceSides} <br/>
        </div>
    );
}

export default DiceRollInfo;