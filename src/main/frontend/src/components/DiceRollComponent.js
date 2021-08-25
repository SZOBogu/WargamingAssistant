import React, {useState} from "react";
import axios from 'axios'
import DiceRoll from "../js/diceRollSimulator/DiceRoll";
import RunDiceRollsRequest from "../js/diceRollSimulator/requests/RunDiceRollsRequest";

function DiceRollComponent(){
    const [quantity, setName] = useState('')
    const [successValue, setSuccessValue] = useState('')
    const [reroll, setReroll] = useState('')
    const [valueToReRoll, setValueToReRoll] = useState('')
    const [failures, setFailures] = useState('')
    const [diceSides, setDiceSides] = useState('')

    const bullshitDiceRoll = new DiceRoll(50, 3, false, -1, false, 6);
    const diceRollList = [];
    var responseData = "";

    const handleSubmit = (e) => {
        const url = "http://localhost:8080/dice/";

        const rollRequest = new RunDiceRollsRequest(diceRollList);

        axios.post(url, rollRequest).then(response => {
            responseData = response.data
        })
    }

    const handleSubmitNonRandom = (e) => {
        const url = "http://localhost:8080/dice/nonrandom";

        const rollRequest = new RunDiceRollsRequest(diceRollList);

        axios.post(url, rollRequest).then(response => {
            responseData = response.data
        })
    }

    const handleAddButton = (e) => {
        const diceRoll = new DiceRoll(quantity, successValue, reroll, successValue, valueToReRoll, failures, diceSides);

        var element = document.getElementById("pppp");
        element.innerText =
            "quantity: " +  diceRollList.quantity + "\n" +
            "successValue: " + diceRollList.successValue + "\n" +
            "reroll: " + diceRollList.reroll + "\n" +
            "valueToReRoll: " + diceRollList.valueToReRoll + "\n" +
            "failures: " + diceRollList.failures + "\n" +
            "diceSides: " + diceRollList.diceSides + "\n"

        diceRollList.add(diceRoll);
    }


    return(
        <div>
            <form className="col=md-4">
                <div className="form-group">
                    <h3>Quantity</h3>
                    <input type="number" value = {quantity} placeholder = "1" onChange={(e) =>setName(e.target.value)}/>
                    <h3>Success Value</h3>
                    <input type="number" value = {successValue} onChange={(e) =>setSuccessValue(e.target.value)}/>
                    <h3>Should there be re rolls?</h3>
                    <input type="checkbox" value = {reroll} placeholder = "100" onChange={(e) =>setReroll(e.target.value)}/>
                    <h3>Should there be re rolls, but only of specific value?</h3>
                    <input type="number" value = {valueToReRoll} onChange={(e) =>setValueToReRoll(e.target.value)}/>
                    <h3>Should failures be counted as positive result?</h3>
                    <input type="checkbox" value = {failures} onChange={(e) =>setFailures(e.target.value)}/>
                    <h3>How many sides should dice have?</h3>
                    <input type="number" value = {diceSides} placeholder = "6" onChange={(e) =>setDiceSides(e.target.value)}/>
                </div>
                <button className="btn btn-primary" onClick={handleAddButton}>Add Dice Roll</button>
            </form>
            <div>
                <button className="btn btn-primary" type="submit" onClick={handleSubmit}>Run Simulation</button>
                <button className="btn btn-primary" type="submit" onClick={handleSubmitNonRandom}>Get most probable outcome</button>
                <p>
                   Response: {responseData}
                </p>
            </div>

            <div>
                <h1>Test</h1>
                <p id = "pppp">

                </p>
            </div>
        </div>

    );
}

export default DiceRollComponent;