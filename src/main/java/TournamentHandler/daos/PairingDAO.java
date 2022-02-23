package TournamentHandler.daos;

import TournamentHandler.entities.Game;
import TournamentHandler.entities.Match;
import TournamentHandler.entities.SwissSystem;
import TournamentHandler.entities.Tournament;
import TournamentHandler.enums.TournamentType;
import TournamentHandler.requests.ManualPlayerPairingRequest;
import TournamentHandler.requests.ManualTeamPairingRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PairingDAO implements IPairingDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Game> getRandomizedPairings(int tournamentId) {
        SwissSystem swissSystem = new SwissSystem();
        return new ArrayList<>();
    }

    @Override
    public Game postManualTeamPairing(ManualTeamPairingRequest request) {
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

    @Override
    public Game postManualPlayerPairing(ManualPlayerPairingRequest request) {
        return null;
    }
}
