package scenarioGenerator.services;

import org.springframework.beans.factory.annotation.Autowired;
import scenarioGenerator.daos.IDeploymentDAO;
import scenarioGenerator.daos.IMissionDAO;
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
    @Autowired
    private IDeploymentDAO deploymentDAO;
    @Autowired
    private IMissionDAO missionDAO;

    public List<Deployment> getDeployments(int wargameId){
        return this.deploymentDAO.getDeployments(wargameId);
    }

    public List<MissionList> getMissions(int wargameId){
        return this.missionDAO.getMissions(wargameId);
    }

    public List<Scenario> generateScenarioList(ScenarioRequest request, int wargameId){
        List<Scenario> scenarios = new ArrayList<>();
        List<List<Mission>> missions = new ArrayList<>();

        List<Deployment> allGameDeployments = this.deploymentDAO.getDeployments(wargameId);
        List<MissionList> allGameMissions = this.missionDAO.getMissions(wargameId);

        for(MissionList m : allGameMissions){
            missions.add(m.getMissions());
        }

        List<Deployment> chosenDeploymentPool = DeploymentPoolGetter.getDeploymentPoolList(request, allGameDeployments);
        List<List<Mission>> chosenMissionPool = MissionPoolGetter.getMissionPoolList(request, missions);

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


