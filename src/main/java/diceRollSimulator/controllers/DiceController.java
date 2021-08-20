package diceRollSimulator.controllers;

import diceRollSimulator.helpers.DiceRollList;
import diceRollSimulator.helpers.DiceRoll;
import diceRollSimulator.pojos.NonRandomReportGenerator;
import diceRollSimulator.pojos.StreamRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dice")
public class DiceController {
    private DiceRollList db;

    @GetMapping
    public List<DiceRoll> getAllDiceRolls(){
        return this.db.getDiceRolls();
    }

    @GetMapping("/{index}")
    public DiceRoll getAllDiceRolls(@PathVariable int index){
        return this.db.getDiceRolls().get(index);
    }

    @PostMapping
    public DiceRoll addRoll(@RequestBody DiceRoll diceRoll){
        this.db.addDiceRoll(diceRoll);
        return diceRoll;
    }

    @DeleteMapping("/{index}")
    public String deleteDiceRoll(@PathVariable int index){
        this.db.removeDiceRoll(index);
        return "Deleted";
    }

    @DeleteMapping
    public String deleteAllDiceRolls(){
        this.db.clear();
        return "All dice rolls deleted";
    }

    @RequestMapping("/run")
    public String runAndGetReport(){
        StreamRunner runner = new StreamRunner();
        runner.runAll(this.db.getDiceRolls());
        return runner.getReport();
    }

    @RequestMapping("/run/nonrandom")
    public String runAndGetNonRandomReport(){
        return NonRandomReportGenerator.generateReport(this.db.getDiceRolls());
    }

    @Autowired
    public void setDb(DiceRollList db) {
        this.db = db;
    }
}
