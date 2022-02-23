package TournamentHandler.daos;

import ScoreCalculator.requests.ScoreRequest;
import TournamentHandler.entities.Participant;
import TournamentHandler.requests.ExtraPointsRequest;

public interface IScoreDAO {
    String uploadScore(ScoreRequest request);
    Participant addExtraPoints(ExtraPointsRequest request);
}
