package TournamentHandler.daos;

import TournamentHandler.entities.Game;
import TournamentHandler.requests.ManualPlayerPairingRequest;
import TournamentHandler.requests.ManualTeamPairingRequest;

import java.util.List;

public interface IPairingDAO {
    List<Game> getRandomizedPairings(int tournamentId);
    Game postManualTeamPairing(ManualTeamPairingRequest request);
    Game postManualPlayerPairing(ManualPlayerPairingRequest request);
}
