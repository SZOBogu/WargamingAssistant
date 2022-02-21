package scenarioGenerator.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import scenarioGenerator.exceptions.ScenarioGenerationException;
import scenarioGenerator.requests.ScenarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rosterBuilder.pojos.WargamingSystem;
import scenarioGenerator.pojos.Scenario;
import scenarioGenerator.responses.ScenarioInfoResponse;
import scenarioGenerator.services.ScenarioService;

import java.util.List;

@RestController
@RequestMapping(value = "/scenario")
public class ScenarioController {
    private WargamingSystem system;
    private ScenarioService scenarioService;

    @GetMapping(value = "/{wargameId}")
    public ScenarioInfoResponse getScenarioInfo(@PathVariable int wargameId){
        System.out.println("ScenarioController, getScenarioInfo got GET");

        return new ScenarioInfoResponse(system);
    }

    @PostMapping(value = "/{wargameId}")
    public ResponseEntity generateScenarios(@RequestBody ScenarioRequest request, @PathVariable int wargameId){
        try {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(this.scenarioService.generateScenarioList(request, system.getDeployments(), system.getMissions()));
        }
        catch(ScenarioGenerationException ex){
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Scenario Form Invalid");
        }
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
