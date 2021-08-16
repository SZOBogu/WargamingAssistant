package scenarioGenerator.services;

import common.RandomArrayElementsGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rosterBuilder.WargamingSystem;
import scenarioGenerator.*;
import scenarioGenerator.helpers.DeploymentPoolConverter;
import scenarioGenerator.helpers.MissionPoolConverter;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScenarioService {
    private WargamingSystem system;

    public List<Scenario> generateScenarioList(ScenarioRequest request){
        List<Scenario> scenarios = new ArrayList<>();

        List<Deployment> deploymentPoolList = DeploymentPoolConverter.getDeploymentPoolList(request, this.system);
        List<List<Mission>> missionPoolList = MissionPoolConverter.getMissionPoolList(request, this.system);

        List<Deployment> chosenDeployments = new ArrayList<>();
        List<List<Mission>> chosenMissions = new ArrayList<>();

        if(ScenarioFormValidator.canBeGenerated(deploymentPoolList, missionPoolList,
                request.getDuplicateDeploymentsQuantity(), request.getDuplicateMissionsQuantity(),
                request.getScenariosToGenerate())) {

            if (request.isGetCanDuplicateDeployments()) {
                if (request.isDuplicateDeploymentsFreely()) {
                    chosenDeployments = RandomArrayElementsGetter.randomArrayElementsWithAnyReps(deploymentPoolList,
                            request.getScenariosToGenerate());
                } else {
                    chosenDeployments = RandomArrayElementsGetter.randomArrayElementsWithReps(deploymentPoolList,
                            request.getDuplicateDeploymentsQuantity(),
                            request.getScenariosToGenerate()));
                }
            }
            else
                chosenDeployments = RandomArrayElementsGetter.randomArrayElementsWithoutReps(deploymentPoolList, request.getScenariosToGenerate());

            if (request.isCanDuplicateMissions()) {
                if (request.isDuplicateMissionsFreely()) {
                    for (int i = 0; i < missionPoolList.size(); i++) {
                        chosenMissions.add(RandomArrayElementsGetter.randomArrayElementsWithAnyReps(chosenMissions.get(i),
                                request.getScenariosToGenerate()));
                    }
                }
                else {
                    for (List<Mission> chosenMission : chosenMissions) {
                        chosenMissions.add(RandomArrayElementsGetter.randomArrayElementsWithReps(chosenMission,
                                request.getDuplicateMissionsQuantity(),
                                request.getScenariosToGenerate()));
                    }
                }
            }
            else {
                for (List<Mission> chosenMission : chosenMissions) {
                    chosenMissions.add(RandomArrayElementsGetter.randomArrayElementsWithoutReps(chosenMission,
                            request.getScenariosToGenerate()));
                }
            }

            for(int i = 0;i < chosenDeployments.size(); i++){
                scenarios.add(new Scenario("Scenario " + i,chosenDeployments.get(i), chosenMissions.get(i)));
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
