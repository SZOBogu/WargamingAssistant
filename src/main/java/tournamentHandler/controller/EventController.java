package tournamentHandler.controller;

import tournamentHandler.entities.Game;
import tournamentHandler.pojos.ScoreList;
import tournamentHandler.requests.TournamentRequest;
import tournamentHandler.requests.ExtraPointsRequest;
import tournamentHandler.requests.RegisterRequest;
import tournamentHandler.services.PairingService;
import tournamentHandler.services.RegistrationService;
import tournamentHandler.services.ScoreService;
import tournamentHandler.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventController {
    @Autowired
    private TournamentService tournamentService;
    @Autowired
    private PairingService pairingService;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public String createEvent(@RequestBody TournamentRequest request){
        return "";
    }

    @PostMapping("/{id}")
    public String updateEvent(@RequestBody TournamentRequest request){

        return "";
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@RequestBody TournamentRequest request){
        return "";

    }

    @PostMapping("/{id}/register")
    public String registerToEvent(@RequestBody RegisterRequest request){
        return "";

    }

    @PostMapping
    public String markSubmissionAsCorrect(){

        return "";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) //post, bo trzeba tylko uzupełnić brakujace
    public List<Game> getRandomizedPairings(){
        return new ArrayList<>();
    }

    //both create and update
    @PostMapping("/{id}/{gameId}")
    public String uploadScore(){
        return "";

    }

    @PostMapping("/{id}/{playerId}")
    public String addExtraPoints(@RequestBody ExtraPointsRequest request){
        return "";

    }

    @GetMapping(value = "/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ScoreList> getStandings(){
        return new ArrayList<>();

    }

    @PostMapping("/{id}/pairing")
    public String postManualPairing(){
        return "";

    }

    @PostMapping("/{id}/round")
    public String startRound(){

        return "";
    }

    @PostMapping("/{id}/round")
    public String endRound(){
        return "";

    }

    @PostMapping("/{id}")
    public String startEvent(){
        return "";

    }

    @PostMapping("/{id}")
    public String endEvent(){
        return "";

    }

    @PostMapping("/{id}/{playerId}")
    public String nominateRef(){
        return "";
    }
}
