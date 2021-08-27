import React, {useState} from "react";
import DiceRoll from "../js/diceRollSimulator/DiceRoll";
import RunDiceRollsRequest from "../js/diceRollSimulator/requests/RunDiceRollsRequest";
import DiceRollList from "./DiceRollList";
import axios from "axios";

function DiceRollComponent(){
    const [diceRolls, setDiceRolls] = useState([])

    const [quantity, setQuantity] = useState(0)
    const [successValue, setSuccessValue] = useState(7)
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

        if(quantity == null){
            setQuantity(0);
        }
        if(successValue == null){
            setSuccessValue(7);
        }
        if(reroll == null){
            setReroll(false);
        }
        if(valueToReRoll == null){
            setValueToReRoll(-1);
        }
        if(failures == null){
            setFailures(false);
        }
        if(diceSides == null){
            setDiceSides(6);
        }


        let tempDiceRoll = new DiceRoll(quantity, successValue, reroll, valueToReRoll, failures, diceSides);
        console.log(tempDiceRoll)

        setDiceRolls(diceRolls.concat(tempDiceRoll));
    }

    const handleClearButton = (e) => {
        e.preventDefault();
        clearDiceRolls();
    }

    function clearDiceRolls(){
        setDiceRolls([]);
    }


    return(
        <div className="container">
            <div className="row">
                <form>
                    <h4>Quantity</h4>
                    <input type="number" id="quantityInput" value = {quantity} placeholder = "1" onChange={(e) => setQuantity(e.target.value)}/>
                    <h4>Success Value</h4>
                    <input type="number" id="successValueInput"  value = {successValue} placeholder = "7" onChange={(e) => setSuccessValue(e.target.value)}/>
                    <h4>Should there be re rolls?</h4>
                    <input type="checkbox" id="rerollCheckbox"  value = {reroll} onChange={(e) => setReroll(e.target.checked)}/>
                    <h4>Should there be re rolls, but only of specific value?</h4>
                    <input type="number" id="valueToReRollInput" value = {valueToReRoll} onChange={(e) => setValueToReRoll(e.target.value)}/>
                    <h4>Should failures be counted as positive result?</h4>
                    <input type="checkbox"  id="failuresCheckbox" value = {failures} onChange={(e) => setFailures(e.target.checked)}/>
                    <h4>How many sides should dice have?</h4>
                    <input type="number" id="successDiceSides" value = {diceSides} placeholder = "6" onChange={(e) => setDiceSides(e.target.value)}/>

                    <button className="btn btn-primary" onClick={handleAddButton}>Add Dice Roll</button>
                </form>

                <button className="btn btn-primary" type="submit" onClick={handleSubmit}>Run Simulation</button>
                <button className="btn btn-primary" type="submit" onClick={handleSubmitNonRandom}>Get most probable outcome</button>
                <button className="btn btn-primary" type="submit" onClick={handleClearButton}>Clear Dice Rolls</button>
            </div>
            <div className="row">
                <DiceRollList diceRolls = {diceRolls}/>
            </div>
            {/*<div className="column">*/}
            {/*    <p>*/}
            {/*        Response: <br/> {response}*/}
            {/*    </p>*/}
            {/*</div>*/}
        </div>

    );
}

export default DiceRollComponent;