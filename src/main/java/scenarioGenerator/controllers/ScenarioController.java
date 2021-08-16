package scenarioGenerator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scenarioGenerator.Scenario;
import scenarioGenerator.ScenarioRequest;
import scenarioGenerator.services.ScenarioService;

import java.util.List;

//TODO: path variable for multiple systems

@RestController
@RequestMapping(value = "/scenario")
public class ScenarioController {
    private ScenarioService scenarioService;

    @PostMapping
    public List<Scenario> getScenarios(@RequestBody ScenarioRequest request){
        List<Scenario> scenarios = this.scenarioService.generateScenarioList(request);

        return scenarios;
    }

    @Autowired
    public void setScenarioService(ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }
}
