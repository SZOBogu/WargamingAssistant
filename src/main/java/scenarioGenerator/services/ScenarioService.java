package scenarioGenerator.services;

import common.ArrayOrderMixer;
import common.RandomArrayElementsGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rosterBuilder.WargamingSystem;
import scenarioGenerator.*;
import scenarioGenerator.helpers.DeploymentPoolConverter;
import scenarioGenerator.helpers.MissionPoolConverter;
import scenarioGenerator.helpers.RandomMissionGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ScenarioService {
    private WargamingSystem system;

    public List<Scenario> generateScenarioList(ScenarioRequest request){
        List<Scenario> scenarios = new ArrayList<>();

        List<Deployment> chosenDeploymentPool = DeploymentPoolConverter.getDeploymentPoolList(request, this.system);
        List<List<Mission>> chosenMissionPool = MissionPoolConverter.getMissionPoolList(request, this.system);

        List<List<Integer>> chosenMissionsIndexes = BoolListToIndexListConverter.convert2dList(request.getMissionBooleanPool());
        List<List<Mission>> chosenMissions = new ArrayList<>();

        List<Deployment> randomDeployments;
        List<List<Mission>> randomMissionsPack = RandomMissionGenerator.generate(request, chosenMissionPool);

        for (int i = 0; i < chosenMissionsIndexes.size(); i++) {
            chosenMissions.add(new ArrayList<>());
            for (int j = 0; j < chosenMissionsIndexes.get(i).size(); j++) {
                chosenMissions.get(i).add(system.getAllMissions().get(i).get(j));
            }
        }

        if(ScenarioFormValidator.canBeGenerated(chosenDeploymentPool, chosenMissions,
                request.getDuplicateDeploymentsQuantity(), request.getDuplicateMissionsQuantity(),
        request.getScenariosToGenerate())) {

            if (request.isGetCanDuplicateDeployments()) {
                if (request.isDuplicateDeploymentsFreely()) {
                    randomDeployments = RandomArrayElementsGetter.randomArrayElementsWithAnyReps(chosenDeploymentPool,
                            request.getScenariosToGenerate());
                }
                else {
                    randomDeployments = RandomArrayElementsGetter.randomArrayElementsWithReps(chosenDeploymentPool,
                            request.getDuplicateDeploymentsQuantity(),
                            request.getScenariosToGenerate());
                }
            }
            else
                randomDeployments = RandomArrayElementsGetter.randomArrayElementsWithoutReps(chosenDeploymentPool, request.getScenariosToGenerate());


            //Merge Deployments and Mission lists into Scenario list.
            for(int i = 0; i < request.getScenariosToGenerate(); i++){
                scenarios.add(new Scenario("Scenario " + i, randomDeployments.get(i), randomMissionsPack.get(i)));
            }
            return scenarios;

        }
        else{
            System.out.println("Error");
            return scenarios;
        }
    }

    @Autowired
    public void setSystem(WargamingSystem system) {
        this.system = system;
    }
}
