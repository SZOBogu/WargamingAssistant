package tournamentHandler.daos;

import tournamentHandler.entities.Game;
import tournamentHandler.requests.ManualPlayerPairingRequest;
import tournamentHandler.requests.ManualTeamPairingRequest;

import java.util.List;

public interface IPairingDAO {
    List<Game> getRandomizedPairings(int tournamentId);
    Game postManualTeamPairing(ManualTeamPairingRequest request);
    Game postManualPlayerPairing(ManualPlayerPairingRequest request);
}
