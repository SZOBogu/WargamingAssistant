package TournamentHandler.entities;

import TournamentHandler.pojos.PlayerScore;
import rosterBuilder.pojos.WargamingSystem;

import java.util.List;

public class Tournament {
    private List<Player> players;
    private List<Round> rounds;
    private int roundNumber;
    private WargamingSystem system;
}
