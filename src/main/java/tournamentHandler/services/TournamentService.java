package tournamentHandler.services;

import tournamentHandler.daos.TournamentDAO;
import tournamentHandler.entities.*;
import tournamentHandler.requests.TournamentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
    @Autowired
    private TournamentDAO tournamentDAO;

    public Tournament createEvent(TournamentRequest request){
        return this.tournamentDAO.createEvent(request);
    }

    public String updateEvent(TournamentRequest request){
        return this.tournamentDAO.updateEvent(request);
    }

    public String deleteEvent(int tournamentId){
        return this.tournamentDAO.deleteEvent(tournamentId);

    }

    public List<Participant> getStandings(int id){
        return this.tournamentDAO.getStandings(id);
    }
}

