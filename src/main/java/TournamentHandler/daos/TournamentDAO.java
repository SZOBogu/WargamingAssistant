package TournamentHandler.daos;

import TournamentHandler.entities.Participant;
import TournamentHandler.entities.Tournament;
import TournamentHandler.requests.TournamentRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class TournamentDAO implements ITournamentDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Tournament createEvent(TournamentRequest request) {
        Tournament tournament = new Tournament();
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
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

    @Override
    public String updateEvent(TournamentRequest request) {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Tournament tournament = new Tournament.TournamentBuilder(request.getRoundNumber(), request.getTeamSize(),
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
        return "";
    }

    @Override
    public String deleteEvent(int tournamentId) {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Tournament tournament = session.get(Tournament.class, tournamentId);
            session.delete(tournament);
            session.close();
        }
        finally{
            assert true;
        }
        return "";
    }


    @Override
    public List<Participant> getStandings(int id) {
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
}
