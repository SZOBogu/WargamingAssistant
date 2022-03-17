package tournamentHandler.services;

import scoreCalculator.requests.ScoreRequest;
import tournamentHandler.daos.IScoreDAO;
import tournamentHandler.entities.Participant;
import tournamentHandler.requests.ExtraPointsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private IScoreDAO dao;

    public Participant addExtraPoints(ExtraPointsRequest request){
        return this.dao.addExtraPoints(request);
    }

    public String uploadScore(ScoreRequest request){
        return this.dao.uploadScore(request);
    }
}
