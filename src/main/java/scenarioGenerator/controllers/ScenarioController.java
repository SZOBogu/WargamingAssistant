package scenarioGenerator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rosterBuilder.WargamingSystem;
import scenarioGenerator.pojos.Scenario;
import scenarioGenerator.responses.ScenarioInfoResponse;
import scenarioGenerator.requests.ScenarioRequest;
import scenarioGenerator.services.ScenarioService;

import java.util.List;

//TODO: path variable for multiple systems

@RestController
@RequestMapping(value = "/scenario")
public class ScenarioController {
    private WargamingSystem system;
    private ScenarioService scenarioService;

    @GetMapping
    public ScenarioInfoResponse getScenarioInfo(){
        ScenarioInfoResponse scenarioInfoResponse = new ScenarioInfoResponse(system);

        return scenarioInfoResponse;
    }

    @PostMapping
    public List<Scenario> generateScenarios(@RequestBody ScenarioRequest request){
        List<Scenario> scenarios = this.scenarioService.generateScenarioList(request);

        return scenarios;
    }

    @Autowired
    public void setScenarioService(ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }

    @Autowired
    public void setSystem(WargamingSystem system) {
        this.system = system;
    }
}
