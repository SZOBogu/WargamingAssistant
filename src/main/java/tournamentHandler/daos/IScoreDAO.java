package tournamentHandler.daos;

import scoreCalculator.requests.ScoreRequest;
import tournamentHandler.entities.Participant;
import tournamentHandler.requests.ExtraPointsRequest;

public interface IScoreDAO {
    String uploadScore(ScoreRequest request);
    Participant addExtraPoints(ExtraPointsRequest request);
}
