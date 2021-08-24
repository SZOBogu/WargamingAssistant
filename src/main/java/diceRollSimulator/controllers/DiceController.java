package diceRollSimulator.controllers;

import diceRollSimulator.pojos.NonRandomReportGenerator;
import diceRollSimulator.pojos.StreamRunner;
import diceRollSimulator.requests.RunDiceRollsRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dice")
public class DiceController {
    @RequestMapping("/run")
    public String runAndGetReport(@RequestBody RunDiceRollsRequest request){
        StreamRunner runner = new StreamRunner();
        runner.runAll(request.getDiceRollList());
        return runner.getReport();
    }

    @RequestMapping("/run/nonrandom")
    public String runAndGetNonRandomReport(@RequestBody RunDiceRollsRequest request){
        return NonRandomReportGenerator.generateReport(request.getDiceRollList());
    }
}
