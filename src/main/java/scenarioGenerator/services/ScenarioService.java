package scenarioGenerator.services;

import common.RandomArrayElementsGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rosterBuilder.WargamingSystem;
import scenarioGenerator.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScenarioService {
    private WargamingSystem system;

    public List<Scenario> generateScenarioList(ScenarioRequest request){
        List<Scenario> scenarios = new ArrayList<>();

        List<Integer> chosenDeploymentIndexes = BoolListToIndexListConverter.convertList(request.getDeploymentBooleanPool());
        List<Deployment> chosenDeploymentPool = new ArrayList<>();
        for (Integer chosenDeploymentIndex : chosenDeploymentIndexes) {
            chosenDeploymentPool.add(this.system.getDeployments().get(chosenDeploymentIndex));
        }
        List<List<Integer>> chosenMissionsIndexes = BoolListToIndexListConverter.convert2dList(request.getMissionBooleanPool());
        List<List<Mission>> chosenMissions = new ArrayList<>();

        List<Deployment> randomDeployments;
        List<List<Mission>> randomMissionsPack = new ArrayList<>();

        for (int i = 0; i < chosenMissionsIndexes.size(); i++) {
            chosenMissions.add(new ArrayList<>());
            for (int j = 0; j < chosenMissionsIndexes.get(i).size(); j++) {
                chosenMissions.get(i).add(system.getAllMissions().get(i).get(j));
            }
        }

        if (ScenarioFormValidator.canBeGenerated(chosenDeploymentPool, chosenMissions,
                request.getDuplicateDeploymentsQuantity(), request.getDuplicateMissionsQuantity(),
        request.getScenariosToGenerate())) {
            if (request.isGetCanDuplicateDeployments()) {
                if (request.isDuplicateDeploymentsFreely()) {
                    randomDeployments = RandomArrayElementsGetter.randomArrayElementsWithAnyReps(chosenDeploymentPool,
                            request.getScenariosToGenerate());
                } else {
                    randomDeployments = RandomArrayElementsGetter.randomArrayElementsWithReps(chosenDeploymentPool,
                            request.getDuplicateDeploymentsQuantity(),
                            request.getScenariosToGenerate());
                }
            } else
                randomDeployments = RandomArrayElementsGetter.randomArrayElementsWithoutReps(chosenDeploymentPool, request.getScenariosToGenerate());

            if (request.isCanDuplicateMissions()) {
                if (request.isDuplicateMissionsFreely()) {
                    for (int i = 0; i < chosenMissionsIndexes.size(); i++) {
                        randomMissionsPack.add(RandomArrayElementsGetter.randomArrayElementsWithAnyReps(chosenMissions.get(i),
                                request.getScenariosToGenerate()));
                    }
                } else {
                    for (List<Mission> chosenMission : chosenMissions) {
                        randomMissionsPack.add(RandomArrayElementsGetter.randomArrayElementsWithReps(chosenMission,
                                request.getDuplicateMissionsQuantity(),
                                request.getScenariosToGenerate()));
                    }
                }
            }
            else {
                for (List<Mission> chosenMission : chosenMissions) {
                    randomMissionsPack.add(RandomArrayElementsGetter.randomArrayElementsWithoutReps(chosenMission,
                            request.getScenariosToGenerate()));
                }
            }
            for(int i = 0; i < Math.min(randomDeployments.size(), randomMissionsPack.size()); i++){
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
