import React from 'react'
import DiceRoll from "../js/diceRollSimulator/DiceRoll";
import DiceRollInfo from "./DiceRollInfo";

function DiceRollList(props){

    return (props.diceRolls.length ?(
                <div>
                    {
                        props.diceRolls.map(diceRoll=> (
                            <div>
                                <DiceRollInfo diceRoll = {diceRoll} />
                                <hr/>
                            </div>
                            )
                        )
                    }
                </div>
            ):
            (
                <div>
                    <p> List empty </p>
                </div>
            )
    );
}

export default DiceRollList;