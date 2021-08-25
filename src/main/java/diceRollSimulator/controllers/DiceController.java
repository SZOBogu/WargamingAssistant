package diceRollSimulator.controllers;

import diceRollSimulator.pojos.NonRandomReportGenerator;
import diceRollSimulator.pojos.StreamRunner;
import diceRollSimulator.requests.RunDiceRollsRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dice")
public class DiceController {
    @RequestMapping()
    public String runAndGetReport(@RequestBody RunDiceRollsRequest request){
        System.out.println("DiceController: " + request.getDiceRollList());
        StreamRunner runner = new StreamRunner();
        runner.runAll(request.getDiceRollList());
        return runner.getReport();
    }

    @RequestMapping("/nonrandom")
    public String runAndGetNonRandomReport(@RequestBody RunDiceRollsRequest request){
        return NonRandomReportGenerator.generateReport(request.getDiceRollList());
    }
}
