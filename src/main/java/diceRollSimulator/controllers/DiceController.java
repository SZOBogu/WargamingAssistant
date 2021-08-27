package diceRollSimulator.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import diceRollSimulator.pojos.DiceRoll;
import diceRollSimulator.pojos.NonRandomReportGenerator;
import diceRollSimulator.pojos.StreamRunner;
import diceRollSimulator.requests.RunDiceRollsRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/dice")
public class DiceController {
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> runAndGetReport(HttpServletRequest request){
        Gson gson = new Gson();
        StringBuffer jb = new StringBuffer();
        String line = null;

        try{
            System.out.println("DiceController got POST");
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);

            String jsonString = jb.toString();
            RunDiceRollsRequest runDiceRollsRequest = gson.fromJson(jsonString, RunDiceRollsRequest.class);

            System.out.println(runDiceRollsRequest);

            StreamRunner runner = new StreamRunner();
            runner.runAll(runDiceRollsRequest.getDiceRollList());

            return ResponseEntity.status(HttpStatus.OK).body(runner.getReport());
        }

        catch(Exception ex){
            System.out.println("DiceController servlet received POST, exception: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("");
        }
    }

    @PostMapping("/nonrandom")
    public String runAndGetNonRandomReport(@RequestBody RunDiceRollsRequest request){
        return NonRandomReportGenerator.generateReport(request.getDiceRollList());
    }
}
