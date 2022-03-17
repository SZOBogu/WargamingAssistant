package tournamentHandler.entities;

import tournamentHandler.helpers.PastEncounterChecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwissSystem extends PairingSystem{
    @Override
    public void getRound(List<Round> rounds, List<Participant> participants){
        Round round = new Round();
        round.setRoundNo(rounds.size() + 1);
        if(rounds.isEmpty()){
            Collections.shuffle(participants);
        }
        else
            Collections.sort(participants, Collections.reverseOrder());

        List<Participant> pairedParticipants = new ArrayList<>();
        for(Participant participant1 : participants){
            for(Participant participant2 : participants){
                if(!PastEncounterChecker.whereTherePastEncounters(rounds, participant1, participant2)
                    && !participant1.equals(participant2) && !pairedParticipants.contains(participant1)
                        && !pairedParticipants.contains(participant2)){
                    Match match = new Match();
                    Game game = new Game();
                    game.setHomePlayer(participant1);
                    game.setAwayPlayer(participant2);
                    match.getGames().add(game);
                    round.getMatchList().add(match);
                    pairedParticipants.add(participant1);
                    pairedParticipants.add(participant2);
                }
            }
        }
        rounds.add(round);
    }
}


