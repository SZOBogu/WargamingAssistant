package scenarioGenerator;

import common.RandomArrayElementsGetter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScenarioRequest {
    private List<Boolean> deploymentBooleanPool;
    private List<List<Boolean>> missionBooleanPool;
    private int scenariosToGenerate;

    private boolean canDuplicateMissions;
    private boolean getCanDuplicateDeployments;

    private boolean duplicateMissionsFreely;
    private boolean duplicateDeploymentsFreely;

    private int duplicateDeploymentsQuantity;
    private int duplicateMissionsQuantity;

//    private List<Integer> deploymentRepList;
//    private List<List<Integer>> missionRepList;


    public List<Boolean> getDeploymentBooleanPool() {
        return deploymentBooleanPool;
    }

    public void setDeploymentBooleanPool(List<Boolean> deploymentBooleanPool) {
        this.deploymentBooleanPool = deploymentBooleanPool;
    }

    public List<List<Boolean>> getMissionBooleanPool() {
        return missionBooleanPool;
    }

    public void setMissionBooleanPool(List<List<Boolean>> missionBooleanPool) {
        this.missionBooleanPool = missionBooleanPool;
    }

    public int getScenariosToGenerate() {
        return scenariosToGenerate;
    }

    public void setScenariosToGenerate(int scenariosToGenerate) {
        this.scenariosToGenerate = scenariosToGenerate;
    }

    public boolean isCanDuplicateMissions() {
        return canDuplicateMissions;
    }

    public void setCanDuplicateMissions(boolean canDuplicateMissions) {
        this.canDuplicateMissions = canDuplicateMissions;
    }

    public boolean isGetCanDuplicateDeployments() {
        return getCanDuplicateDeployments;
    }

    public void setGetCanDuplicateDeployments(boolean getCanDuplicateDeployments) {
        this.getCanDuplicateDeployments = getCanDuplicateDeployments;
    }

    public boolean isDuplicateMissionsFreely() {
        return duplicateMissionsFreely;
    }

    public void setDuplicateMissionsFreely(boolean duplicateMissionsFreely) {
        this.duplicateMissionsFreely = duplicateMissionsFreely;
    }

    public boolean isDuplicateDeploymentsFreely() {
        return duplicateDeploymentsFreely;
    }

    public void setDuplicateDeploymentsFreely(boolean duplicateDeploymentsFreely) {
        this.duplicateDeploymentsFreely = duplicateDeploymentsFreely;
    }

    public int getDuplicateDeploymentsQuantity() {
        return duplicateDeploymentsQuantity;
    }

    public void setDuplicateDeploymentsQuantity(int duplicateDeploymentsQuantity) {
        this.duplicateDeploymentsQuantity = duplicateDeploymentsQuantity;
    }

    public int getDuplicateMissionsQuantity() {
        return duplicateMissionsQuantity;
    }

    public void setDuplicateMissionsQuantity(int duplicateMissionsQuantity) {
        this.duplicateMissionsQuantity = duplicateMissionsQuantity;
    }

    //    public List<Integer> getDeploymentRepList() {
//        return deploymentRepList;
//    }
//
//    public void setDeploymentRepList(List<Integer> deploymentRepList) {
//        this.deploymentRepList = deploymentRepList;
//    }
//
//    public List<List<Integer>> getMissionRepList() {
//        return missionRepList;
//    }
//
//    public void setMissionRepList(List<List<Integer>> missionRepList) {
//        this.missionRepList = missionRepList;
//    }

/*
{
	"deploymentBooleanPool": [false, true, false, true, false, true],
	"missionBooleanPool": [[false, true, false, true, false, true],[false, true, false, true, false, true]],
	"scenariosToGenerate": 3,
	"canDuplicateMissions": true,
	"getCanDuplicateDeployments": true,
	"duplicateMissionsFreely": false,
	"duplicateDeploymentsFreely": false,
	"duplicateDeploymentsQuantity": 2,
	"duplicateMissionsQuantity": 2
}
 */

    @Override
    public String toString() {
        return "ScenarioRequest{" +
                "deploymentBooleanPool=" + deploymentBooleanPool +
                ", missionBooleanPool=" + missionBooleanPool +
                ", scenariosToGenerate=" + scenariosToGenerate +
                ", canDuplicateMissions=" + canDuplicateMissions +
                ", getCanDuplicateDeployments=" + getCanDuplicateDeployments +
                ", duplicateMissionsFreely=" + duplicateMissionsFreely +
                ", duplicateDeploymentsFreely=" + duplicateDeploymentsFreely +
                ", duplicateDeploymentsQuantity=" + duplicateDeploymentsQuantity +
                ", duplicateMissionsQuantity=" + duplicateMissionsQuantity +
                '}';
    }
}
