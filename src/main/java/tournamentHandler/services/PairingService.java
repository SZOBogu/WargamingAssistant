package tournamentHandler.services;

import tournamentHandler.daos.IPairingDAO;
import tournamentHandler.entities.Game;
import tournamentHandler.requests.ManualPlayerPairingRequest;
import tournamentHandler.requests.ManualTeamPairingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
