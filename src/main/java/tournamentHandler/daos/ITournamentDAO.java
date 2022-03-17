package tournamentHandler.daos;

import tournamentHandler.entities.*;
import tournamentHandler.requests.TournamentRequest;
import java.util.List;

public interface ITournamentDAO {
    Tournament createEvent(TournamentRequest request);
    String updateEvent(TournamentRequest request);
    String deleteEvent(int tournamentId);
    List<Participant> getStandings(int id);
}
