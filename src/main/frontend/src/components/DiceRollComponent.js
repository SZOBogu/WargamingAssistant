import React, {useContext, useState} from "react";
import axios from 'axios'
import DiceRoll from "../js/diceRollSimulator/DiceRoll";
import RunDiceRollsRequest from "../js/diceRollSimulator/requests/RunDiceRollsRequest";
import DiceRollList from "./DiceRollList";
import {DiceContext} from "./DiceContext";

function DiceRollComponent(){
    const [quantity, setQuantity] = useState('')
    const [successValue, setSuccessValue] = useState('')
    const [reroll, setReroll] = useState(false)
    const [valueToReRoll, setValueToReRoll] = useState(-1)
    const [failures, setFailures] = useState(false)
    const [diceSides, setDiceSides] = useState(6)
    const [response, setResponse] = useState('')

    const {addDiceRoll} = useContext(DiceContext)
    const {diceRolls} = useContext(DiceContext)
    const {clearDiceRolls} = useContext(DiceContext)

    const handleSubmit = (e) => {
        e.preventDefault()
        const url = 'http://localhost:8080/dice/';

        let diceRoll1 = new DiceRoll(23,3,false,-1,false,6);
        let diceRoll2 = new DiceRoll(23,4,false,-1,false,6);
        let diceRoll3 = new DiceRoll(23,5,false,-1,false,6);

        let diceRollsLocal = [diceRoll1, diceRoll2, diceRoll3];

        const rollRequest = new RunDiceRollsRequest(diceRollsLocal);

        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(rollRequest)
        };

        console.log(JSON.stringify(rollRequest))

        fetch(url, requestOptions).then(r => console.log(r));

        clearDiceRolls()
    }

    const handleSubmitNonRandom = async (e) => {
        e.preventDefault()
        const url = 'http://localhost:8080/dice/nonrandom';

        const rollRequest = new RunDiceRollsRequest(diceRolls);

        const response = await axios.post(url, rollRequest)

        clearDiceRolls()
    }

    const handleAddButton = (e) => {
        e.preventDefault()
        addDiceRoll(quantity, successValue, reroll, valueToReRoll, failures, diceSides)
        setQuantity()
        setSuccessValue()
        setReroll(false)
        setValueToReRoll(-1)
        setFailures(false)
        setDiceSides(6)
    }


    return(
        <div>
            <form className="col=md-4">
                <div className="form-group">
                    <h3>Quantity</h3>
                    <input type="number" id="quantityInput" value = {quantity} placeholder = "1" onChange={(e) => setQuantity(e.target.value)}/>
                    <h3>Success Value</h3>
                    <input type="number" id="successValueInput"  value = {successValue} onChange={(e) => setSuccessValue(e.target.value)}/>
                    <h3>Should there be re rolls?</h3>
                    <input type="checkbox" id="rerollCheckbox"  value = {reroll} onChange={(e) => setReroll(e.target.checked)}/>
                    <h3>Should there be re rolls, but only of specific value?</h3>
                    <input type="number" id="valueToReRollInput" value = {valueToReRoll} onChange={(e) => setValueToReRoll(e.target.value)}/>
                    <h3>Should failures be counted as positive result?</h3>
                    <input type="checkbox"  id="failuresCheckbox" value = {failures} onChange={(e) => setFailures(e.target.checked)}/>
                    <h3>How many sides should dice have?</h3>
                    <input type="number" id="successDiceSides" value = {diceSides} placeholder = "6" onChange={(e) => setDiceSides(e.target.value)}/>
                </div>
                <button className="btn btn-primary" onClick={handleAddButton}>Add Dice Roll</button>
            </form>
            <div>
                <button className="btn btn-primary" type="submit" onClick={handleSubmit}>Run Simulation</button>
                <button className="btn btn-primary" type="submit" onClick={handleSubmitNonRandom}>Get most probable outcome</button>
                <p>
                   Response: {response}
                </p>
            </div>

            <DiceRollList/>
        </div>

    );
}

export default DiceRollComponent;