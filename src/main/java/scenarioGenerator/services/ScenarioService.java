package scenarioGenerator.services;

import scenarioGenerator.exceptions.ScenarioGenerationException;
import scenarioGenerator.pojos.MissionList;
import scenarioGenerator.requests.ScenarioRequest;
import org.springframework.stereotype.Service;
import scenarioGenerator.utility.*;
import scenarioGenerator.pojos.Deployment;
import scenarioGenerator.pojos.Mission;
import scenarioGenerator.pojos.Scenario;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScenarioService {
    public List<Scenario> generateScenarioList(ScenarioRequest request, List<Deployment> deployments, List<MissionList> missionList){
        List<Scenario> scenarios = new ArrayList<>();
        List<List<Mission>> missions = new ArrayList<>();

        for(MissionList m : missionList){
            missions.add(m.getMissions());
        }

        List<Deployment> chosenDeploymentPool = DeploymentPoolGetter.getDeploymentPoolList(request, deployments);
        List<List<Mission>> chosenMissionPool = MissionPoolGetter.getObjectivePackPoolList(request, missions);

        if(ScenarioFormValidator.canBeGenerated(request)) {
            List<Deployment> randomDeployments = RandomDeploymentListGetter.generate(request, chosenDeploymentPool);
            List<List<Mission>> randomMissionsPack = RandomMissionListGenerator.generate(request, chosenMissionPool);

            for(int i = 0; i < request.getScenariosToGenerate(); i++){
                scenarios.add(new Scenario("Scenario " + i, randomDeployments.get(i), randomMissionsPack.get(i)));
            }
            return scenarios;
        }
        else{
            throw new ScenarioGenerationException("It is impossible to generate Scenario pack with combination of given parameters");
        }
    }
}


