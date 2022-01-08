import React, {useEffect, useState, useContext, useLayoutEffect} from "react";
import axios from "axios";
import {GameContext} from "../GameContext";
import ScenarioInfoResponse from "../../js/scenarioGenerator/ScenarioInfoResponse";
import ScenarioRequest from "../../js/scenarioGenerator/ScenarioRequest";
import DeploymentComponent from "./DeploymentComponent";

function ScenarioComponent() {
    const [scenarioInfoResponse, setScenarioInfoResponse] = useState({});

    const [deploymentBooleanPool, setDeploymentBooleanPool] = useState([true, false, true, false, true, false]);
    const [missionBooleanPool, setMissionBooleanPool] = useState([[true, false, true, false, true, false],
        [true, false, true, false, true, false]]);

    const [scenariosToGenerate, setScenariosToGenerate] = useState(0);
    const [canDuplicateMissions, setCanDuplicateMissions] = useState(false);
    const [canDuplicateDeployments, setCanDuplicateDeployments] = useState(false);
    const [duplicateMissionsFreely, setDuplicateMissionsFreely] = useState(false);
    const [duplicateDeploymentsFreely, setDuplicateDeploymentsFreely] = useState(false);
    const [duplicateDeploymentsQuantity, setDuplicateDeploymentsQuantity] = useState(1);
    const [duplicateMissionsQuantity, setDuplicateMissionsQuantity] = useState(1);

    const [generatedScenarios, setGeneratedScenarios] = useState();

    const [deploymentCheckedState, setDeploymentCheckedState] = useState([]);
    const [missionsCheckedState, setMissionsCheckedState] = useState([]);

    const {wargameId} = useContext(GameContext)

    useEffect(() => {
        const url = 'http://localhost:8080/scenario';

        let numberOfDeployments;
        let numberOfMissions = [];

        axios.get(url).then(response => {
            console.log(response.data)

            numberOfDeployments = response.data.deploymentList.length;
            console.log(numberOfDeployments)
            for(let i=0; i < numberOfDeployments; i++){
                setDeploymentCheckedState([...deploymentCheckedState, false])
            }
            console.log(deploymentCheckedState.length)
            for(let i=0; i < response.data.missionList.length; i++){
                numberOfMissions.push(response.data.missionList[i].missions.length);
            }

            let scenarioInfoResp = new ScenarioInfoResponse(response.data.gameName, response.data.deploymentList, response.data.missionList);
            setScenarioInfoResponse(scenarioInfoResp);
        })

        for(let i=0; i < numberOfMissions.length; i++){
            setMissionsCheckedState(missionsCheckedState.concat(new Array(numberOfMissions[i]).fill(false)));
        }

    }, []);


    const handleOnChangeDeploymentIndex = (position) => {
        const updatedCheckedState = deploymentCheckedState.map((item, index) =>
            index === position ? !item : item
        );

        setDeploymentCheckedState(updatedCheckedState);
    };

    const handleGenerateButton = () => {
        const url = 'http://localhost:8080/scenario';

        let request = new ScenarioRequest(deploymentBooleanPool, missionBooleanPool, scenariosToGenerate, canDuplicateMissions,
            canDuplicateDeployments, duplicateMissionsFreely, duplicateDeploymentsFreely,
            duplicateDeploymentsQuantity, duplicateMissionsQuantity)

        axios.post(url, request).then(response => {
            setGeneratedScenarios(response);
        })
    }

    const handleGetInfoButton = () => {
        const url = 'http://localhost:8080/scenario';

        // if(scenarioInfoResponse.gameName === "" || scenarioInfoResponse.deploymentList === [] || scenarioInfoResponse.missionList === []) {
            axios.get(url).then(response => {
                console.log(JSON.stringify(response))
                let scenarioInfoResp = new ScenarioInfoResponse(response.data.gameName, response.data.deploymentList, response.data.missionList);
                setScenarioInfoResponse(scenarioInfoResp);
            })
        // }
    }
    return(
        <div>
            <h1> {scenarioInfoResponse.gameName} </h1>
            <h1> {deploymentCheckedState.length} </h1>
            <div id="form">
                <form>
                    <h4>How many scenarios?</h4>
                    <input type="number" id="scenariosToGenerateInput" value = {scenariosToGenerate} onChange={(e) => setScenariosToGenerate(e.target.value)}/>
                    <h4>Should deployments be duplicated?</h4>
                    <input type="checkbox" id="canDuplicateDeploymentsCheckbox"  value = {canDuplicateDeployments} onChange={(e) => setCanDuplicateDeployments(e.target.checked)}/>
                    <h4>Should there be unlimited amount of deployment duplicates?</h4>
                    <input type="checkbox" id="duplicateDeploymentsFreelyCheckbox"  value = {duplicateDeploymentsFreely} onChange={(e) => setDuplicateDeploymentsFreely(e.target.checked)}/>
                    <h4>Max number of duplicates</h4>
                    <input type="number" id="duplicateDeploymentsQuantityInput" value = {duplicateDeploymentsQuantity} onChange={(e) => setDuplicateDeploymentsQuantity(e.target.value)}/>
                    <h4>Should missions be duplicated?</h4>
                    <input type="checkbox" id="canDuplicateMissionsCheckbox"  value = {canDuplicateMissions} onChange={(e) => setCanDuplicateMissions(e.target.checked)}/>
                    <h4>Should there be unlimited amount of mission duplicates?</h4>
                    <input type="checkbox" id="duplicateMissionsFreelyCheckbox"  value = {duplicateMissionsFreely} onChange={(e) => setDuplicateMissionsFreely(e.target.checked)}/>
                    <h4>Max number of duplicates</h4>
                    <input type="number" id="duplicateMissionsQuantityInput" value = {duplicateMissionsQuantity} onChange={(e) => setDuplicateMissionsQuantity(e.target.value)}/>

                    {/*{scenarioInfoResponse.deploymentList.map(({deployment}, index) => {*/}
                    {/*    return (*/}
                    {/*        <li key={index}>*/}
                    {/*            <div className="toppings-list-item">*/}
                    {/*                <div className="left-section">*/}
                    {/*                    <input*/}
                    {/*                        type="checkbox"*/}
                    {/*                        id={`custom-checkbox-${index}`}*/}
                    {/*                        name={deployment}*/}
                    {/*                        value={deployment}*/}
                    {/*                        checked={deploymentCheckedState[index]}*/}
                    {/*                        onChange={() => handleOnChangeDeploymentIndex(index)}*/}
                    {/*                    />*/}
                    {/*                    <label htmlFor={`custom-checkbox-${index}`}>{deployment}</label>*/}
                    {/*                </div>*/}
                    {/*            </div>*/}
                    {/*        </li>*/}
                    {/*    );*/}
                    {/*})}*/}

                    {deploymentCheckedState.map(()=>{
                        <DeploymentComponent/>
                    })}

                </form>
                <button className="btn btn-primary" onClick={handleGenerateButton}>Generate Scenarios</button>
            </div>

            <div>
                response: {generatedScenarios}
            </div>
        </div>
    );
}

export default ScenarioComponent;