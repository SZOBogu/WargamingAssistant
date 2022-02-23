package TournamentHandler.services;

import TournamentHandler.daos.PairingDAO;
import TournamentHandler.daos.RegistrationDAO;
import TournamentHandler.daos.ScoreDAO;
import TournamentHandler.daos.TournamentDAO;
import TournamentHandler.entities.*;
import TournamentHandler.enums.TournamentType;
import TournamentHandler.requests.ExtraPointsRequest;
import TournamentHandler.requests.ManualTeamPairingRequest;
import TournamentHandler.requests.RegisterRequest;
import TournamentHandler.requests.TournamentRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
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

