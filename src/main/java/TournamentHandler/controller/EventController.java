package TournamentHandler.controller;

import TournamentHandler.entities.Game;
import TournamentHandler.pojos.EventScore;
import TournamentHandler.requests.EventRequest;
import TournamentHandler.requests.ExtraPointsRequest;
import TournamentHandler.requests.RegisterRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventController {
    /*
    create
    delete
    register
    check as correct
    pair
    post score
    update score
    add karniaki
    get standings
    pair manually
    start round
    end round
    end event
    nominate ref
    choose scenario //do scenariogeneratora?
     */

    /*
    druzynowki
     */

    @PostMapping
    public String createEvent(@RequestBody EventRequest request){
        return "";
    }

    @PostMapping("/{id}")
    public String updateEvent(@RequestBody EventRequest request){

        return "";
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@RequestBody EventRequest request){
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
    public List<EventScore> getStandings(){
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
