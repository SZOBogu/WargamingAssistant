package scenarioGenerator.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import scenarioGenerator.exceptions.ScenarioGenerationException;
import scenarioGenerator.requests.ScenarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scenarioGenerator.responses.ScenarioInfoResponse;
import scenarioGenerator.services.ScenarioService;

@RestController
@RequestMapping(value = "/scenario")
public class ScenarioController {
    private ScenarioService scenarioService;

    @GetMapping(value = "/{wargameId}")
    public ScenarioInfoResponse getScenarioInfo(@PathVariable int wargameId){
        ScenarioInfoResponse response = new ScenarioInfoResponse();
        response.setDeploymentList(this.scenarioService.getDeployments(wargameId));
        response.setMissionList(this.scenarioService.getMissions(wargameId));
        System.out.println("ScenarioController, getScenarioInfo got GET");
        return response;
    }

    @PostMapping(value = "/{wargameId}")
    public ResponseEntity generateScenarios(@RequestBody ScenarioRequest request, @PathVariable int wargameId){
        try {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(this.scenarioService.generateScenarioList(request, wargameId));
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
}
