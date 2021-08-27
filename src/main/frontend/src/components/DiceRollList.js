import React from 'react'
import DiceRoll from "../js/diceRollSimulator/DiceRoll";

function DiceRollList(props){

    return (props.diceRolls.length ?(
                <div className="d-flex justify-content-center p-3">
                    {
                        props.diceRolls.map(diceRoll=> (
                                <div>
                                    <p> Dice roll type: {diceRoll instanceof DiceRoll} </p>
                                    <p> Dice quantity: {diceRoll.quantity} </p>
                                    <p> Minimal roll for success: {diceRoll.successValue} </p>
                                    <p> Should there be rerolls : {diceRoll.reroll} </p>
                                    <p> Re roll of specific value: {diceRoll.valueToReRoll} </p>
                                    <p> Should failures be counted: {diceRoll.failures} </p>
                                    <p> How many dice sides: {diceRoll.diceSides} </p>
                                </div>
                            )
                        )
                    }
                </div>
            ):
            (
                <div className="d-flex justify-content-center p-3">
                    <p> List empty </p>
                </div>
            )
    );
}

export default DiceRollList;