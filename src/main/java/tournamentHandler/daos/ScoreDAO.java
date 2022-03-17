package tournamentHandler.daos;

import scoreCalculator.requests.ScoreRequest;
import tournamentHandler.entities.Participant;
import tournamentHandler.requests.ExtraPointsRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreDAO implements IScoreDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String uploadScore(ScoreRequest request) {
        return null;
    }

    @Override
    public Participant addExtraPoints(ExtraPointsRequest request) {
        Participant participant;
        try{
            Session session = sessionFactory.openSession();
            participant = session.get(Participant.class, request.getParticipantId());
            participant.getScoreList().addPoints(request.getScorePoints());
            session.saveOrUpdate(participant);
            session.close();
        }
        finally {
            assert true;
        }
        return participant;
    }
}
