package TournamentHandler.services;

import TournamentHandler.entities.*;
import TournamentHandler.enums.TournamentType;
import TournamentHandler.requests.ExtraPointsRequest;
import TournamentHandler.requests.ManualPairRequest;
import TournamentHandler.requests.RegisterRequest;
import TournamentHandler.requests.TournamentRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class TournamentService {
    private SessionFactory sessionFactory;

    public Tournament createEvent(@RequestBody TournamentRequest request){
        Tournament tournament = new Tournament();
        try{
            Session session = sessionFactory.openSession();
            tournament = new Tournament.TournamentBuilder(request.getRoundNumber(), request.getTeamSize(),
                            request.getGameScoringSystem(), request.getEventScoringSystem(), request.getPairingSystem())
                            .name(request.getName())
                            .statute(request.getStatute())
                            .participants(request.getParticipants())
                            .rounds(request.getRounds()).system(request.getSystem())
                            .participantLimit(request.getParticipantLimit())
                            .pointLimit(request.getPointLimit())
                            .scenarios(request.getScenarios())
                            .rosterRules(request.getRosterRules())
                            .armyPointCapRules(request.getArmyPointCapRules())
                            .teamCompositionRules(request.getTeamCompositionRules())
                        .build();
            session.saveOrUpdate(tournament);
            session.close();
        }
        finally{
            assert true;
        }
        return tournament;
    }

    public String updateEvent(@RequestBody TournamentRequest request){

        return "";
    }

    public String deleteEvent(@RequestBody TournamentRequest request){
        return "";

    }

    public String registerToEvent(@RequestBody RegisterRequest request){
        return "";

    }

    public Participant markSubmissionAsCorrect(Submission submission){
        Participant participant = new Participant();
        participant.setName(submission.getUserEntity().getUsername());
        participant.setRoster(submission.getRoster());
        try{
            Session session = sessionFactory.openSession();
            Team team = session.get(Team.class, submission.getTeamId());
            Tournament tournament = session.get(Tournament.class, submission.getTournamentId());
            team.add(participant);
            tournament.getParticipants().add(participant);
            session.save(participant);
            session.saveOrUpdate(team);
            session.saveOrUpdate(tournament);
            session.close();
        }
        finally {
            assert true;
        }
        return participant;
    }

    public List<Game> getRandomizedPairings(int tournamentId){
        SwissSystem swissSystem = new SwissSystem();

    }

    public String uploadScore(){
        return "";

    }

    public Participant addExtraPoints(@RequestBody ExtraPointsRequest request){
        Participant participant;
        try{
            Session session = sessionFactory.openSession();
            participant = session.get(Participant.class, request.getParticipantId());
            participant.getScoreList().addPoints(request.getScorePoints());
            session.saveOrUpdate(participant);
            session.close();
        }
        finally {
            assert true;
        }

        return participant;
    }

    public List<Participant> getStandings(int id){
        List<Participant> standings = new ArrayList<>();
        try{
            Session session = sessionFactory.openSession();
            Tournament tournament = session.get(Tournament.class, id);
            standings = tournament.getParticipants();
            Collections.sort(standings, Collections.reverseOrder());

            session.close();
        }
        finally {
            assert true;
        }
        return standings;
    }

    public Game postManualPairing(ManualPairRequest request){
        Game game = new Game();
        try{
            Session session = sessionFactory.openSession();
            Match match = session.get(Match.class, request.getMatchId());
            Tournament tournament = session.get(Tournament.class, request.getTournamentId());

            if(tournament.getType() == TournamentType.SINGLE) {
                game.setHomeTeam(match.getHomeTeam());
                game.setAwayTeam(match.getAwayTeam());
            }
            match.getGames().add(game);
            session.close();
        }
        finally {
            assert true;
        }
        return game;
    }
}

