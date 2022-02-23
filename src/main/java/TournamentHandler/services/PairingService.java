package TournamentHandler.services;

import TournamentHandler.daos.IPairingDAO;
import TournamentHandler.entities.Game;
import TournamentHandler.entities.Match;
import TournamentHandler.entities.SwissSystem;
import TournamentHandler.entities.Tournament;
import TournamentHandler.enums.TournamentType;
import TournamentHandler.requests.ManualPlayerPairingRequest;
import TournamentHandler.requests.ManualTeamPairingRequest;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PairingService {
    @Autowired
    private IPairingDAO dao;

    public List<Game> getRandomizedPairings(int tournamentId){
        return this.dao.getRandomizedPairings(tournamentId);
    }

    public Game postManualTeamPairing(ManualTeamPairingRequest request){
        return this.dao.postManualTeamPairing(request);
    }

    public Game postManualPlayerPairing(ManualPlayerPairingRequest request){
        return this.dao.postManualPlayerPairing(request);
    }
}
