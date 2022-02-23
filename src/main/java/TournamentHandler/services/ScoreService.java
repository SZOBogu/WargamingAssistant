package TournamentHandler.services;

import ScoreCalculator.requests.ScoreRequest;
import TournamentHandler.daos.IScoreDAO;
import TournamentHandler.entities.Participant;
import TournamentHandler.requests.ExtraPointsRequest;
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
