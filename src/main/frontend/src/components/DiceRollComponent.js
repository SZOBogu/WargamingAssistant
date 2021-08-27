import React, {useState} from "react";
import DiceRoll from "../js/diceRollSimulator/DiceRoll";
import RunDiceRollsRequest from "../js/diceRollSimulator/requests/RunDiceRollsRequest";
import DiceRollList from "./DiceRollList";
import axios from "axios";

function DiceRollComponent(){
    const [diceRolls, setDiceRolls] = useState([])

    const [quantity, setQuantity] = useState('')
    const [successValue, setSuccessValue] = useState('')
    const [reroll, setReroll] = useState(false)
    const [valueToReRoll, setValueToReRoll] = useState(-1)
    const [failures, setFailures] = useState(false)
    const [diceSides, setDiceSides] = useState(6)

    const [response, setResponse] = useState('')


    const handleSubmit = (e) => {
        e.preventDefault();
        const url = 'http://localhost:8080/dice/';
        const rollRequest = new RunDiceRollsRequest(diceRolls);

        axios.post(url, rollRequest).then(response => {setResponse(response.data)})
        clearDiceRolls();
    }

    const handleSubmitNonRandom = async (e) => {
        e.preventDefault();
        const url = 'http://localhost:8080/dice/nonrandom';
        const rollRequest = new RunDiceRollsRequest(diceRolls);

        axios.post(url, rollRequest).then(response => {setResponse(response.data)})
        clearDiceRolls();
    }

    const handleAddButton = (e) => {
        e.preventDefault();
        let tempDiceRoll = new DiceRoll(quantity, successValue, reroll, valueToReRoll, failures, diceSides);

        console.log("Dice Rolls BEFORE " + diceRolls);

        setDiceRolls(diceRolls.concat(tempDiceRoll));

        console.log("Dice Rolls AFTER " + diceRolls);
        setQuantity();
        setSuccessValue();
        setReroll(false);
        setValueToReRoll(-1);
        setFailures(false);
        setDiceSides(6);
    }

    const handleClearButton = (e) => {
        e.preventDefault();
        clearDiceRolls();
    }

    function clearDiceRolls(){
        setDiceRolls([]);
    }


    return(
        <div>
            <form className="col=md-4">
                <div className="form-group">
                    <h3>Quantity</h3>
                    <input type="number" id="quantityInput" value = {quantity} placeholder = "1" onChange={(e) => setQuantity(e.target.value)}/>
                    <h3>Success Value</h3>
                    <input type="number" id="successValueInput"  value = {successValue} placeholder = "7" onChange={(e) => setSuccessValue(e.target.value)}/>
                    <h3>Should there be re rolls?</h3>
                    <input type="checkbox" id="rerollCheckbox"  value = {!!reroll} onChange={(e) => setReroll(e.target.checked)}/>
                    <h3>Should there be re rolls, but only of specific value?</h3>
                    <input type="number" id="valueToReRollInput" value = {valueToReRoll} onChange={(e) => setValueToReRoll(e.target.value)}/>
                    <h3>Should failures be counted as positive result?</h3>
                    <input type="checkbox"  id="failuresCheckbox" value = {!!failures} onChange={(e) => setFailures(e.target.checked)}/>
                    <h3>How many sides should dice have?</h3>
                    <input type="number" id="successDiceSides" value = {diceSides} placeholder = "6" onChange={(e) => setDiceSides(e.target.value)}/>
                </div>
                <button className="btn btn-primary" onClick={handleAddButton}>Add Dice Roll</button>
            </form>

            <div>
                <button className="btn btn-primary" type="submit" onClick={handleSubmit}>Run Simulation</button>
                <button className="btn btn-primary" type="submit" onClick={handleSubmitNonRandom}>Get most probable outcome</button>
                <button className="btn btn-primary" type="submit" onClick={clearDiceRolls}>Clear Dice Rolls</button>

                <p>
                   Response: <br/> {response}
                </p>
            </div>
            <DiceRollList diceRolls = {diceRolls}/>
        </div>

    );
}

export default DiceRollComponent;