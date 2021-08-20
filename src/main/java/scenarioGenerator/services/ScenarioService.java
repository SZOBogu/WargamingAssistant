package scenarioGenerator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rosterBuilder.WargamingSystem;
import scenarioGenerator.exceptions.ScenarioGenerationException;
import scenarioGenerator.helpers.*;
import scenarioGenerator.pojos.Deployment;
import scenarioGenerator.pojos.Mission;
import scenarioGenerator.pojos.Scenario;
import scenarioGenerator.requests.ScenarioRequest;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScenarioService {
    private WargamingSystem system;

    public List<Scenario> generateScenarioList(ScenarioRequest request){
        List<Scenario> scenarios = new ArrayList<>();

        List<Deployment> chosenDeploymentPool = DeploymentPoolConverter.getDeploymentPoolList(request, this.system);
        List<List<Mission>> chosenMissionPool = MissionPoolConverter.getMissionPoolList(request, this.system);

        if(ScenarioFormValidator.canBeGenerated(chosenDeploymentPool, chosenMissionPool,
                request.getDuplicateDeploymentsQuantity(), request.getDuplicateMissionsQuantity(),
        request.getScenariosToGenerate())) {

            List<Deployment> randomDeployments = RandomDeploymentList.generate(request, chosenDeploymentPool);
            List<List<Mission>> randomMissionsPack = RandomMissionPackListGenerator.generate(request, chosenMissionPool);

            for(int i = 0; i < request.getScenariosToGenerate(); i++){
                scenarios.add(new Scenario("Scenario " + i, randomDeployments.get(i), randomMissionsPack.get(i)));
            }
            return scenarios;
        }
        else{
            throw new ScenarioGenerationException("It is impossible to generate Scenario pack with combination of given parameters");
        }
    }

    @Autowired
    public void setSystem(WargamingSystem system) {
        this.system = system;
    }
}
