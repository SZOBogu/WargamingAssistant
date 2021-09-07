class ScenarioRequest{
    constructor(deploymentBooleanPool, missionBooleanPool, scenariosToGenerate, canDuplicateMissions,
                getCanDuplicateDeployments, duplicateMissionsFreely, duplicateDeploymentsFreely,
                duplicateDeploymentsQuantity, duplicateMissionsQuantity) {

        this.deploymentBooleanPool = deploymentBooleanPool;
        this.missionBooleanPool = missionBooleanPool;
        this.scenariosToGenerate = scenariosToGenerate;
        this.canDuplicateMissions = canDuplicateMissions;
        this.getCanDuplicateDeployments = getCanDuplicateDeployments;
        this.duplicateMissionsFreely = duplicateMissionsFreely;
        this.duplicateDeploymentsFreely = duplicateDeploymentsFreely;
        this.duplicateDeploymentsQuantity = duplicateDeploymentsQuantity;
        this.duplicateMissionsQuantity = duplicateMissionsQuantity;
    }
}

export default ScenarioRequest;