package TournamentHandler.daos;

import TournamentHandler.entities.*;
import TournamentHandler.requests.TournamentRequest;
import java.util.List;

public interface ITournamentDAO {
    Tournament createEvent(TournamentRequest request);
    String updateEvent(TournamentRequest request);
    String deleteEvent(int tournamentId);
    List<Participant> getStandings(int id);
}
