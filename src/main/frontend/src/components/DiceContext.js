import React, {useState, useContext, createContext} from 'react'
import DiceRoll from "../js/diceRollSimulator/DiceRoll";

export const DiceContext = createContext()

function DiceContextProvider(props){
    const [diceRolls, setDiceRolls] = useState([])

    const addDiceRoll = (quantity, successValue, reroll, valueToReRoll, failures, diceSides) => {
        console.log("quantity " + quantity);
        console.log("successValue " + successValue);
        console.log("reroll " + reroll);
        console.log("valueToReRoll " + valueToReRoll);
        console.log("failures " + failures);
        console.log("diceSides " + diceSides);

        const diceRoll = new DiceRoll(quantity, successValue, reroll, valueToReRoll, failures, diceSides);

        console.log(diceRoll);

        setDiceRolls([...diceRolls, {diceRoll}])
    }

    const clearDiceRolls = () => {
        setDiceRolls([])
    }

    return(
        <DiceContext.Provider value={{diceRolls, addDiceRoll, clearDiceRolls}}>
            {props.children}
        </DiceContext.Provider>
    );

}

export default DiceContextProvider;