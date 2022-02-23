package TournamentHandler.daos;

import TournamentHandler.entities.Participant;
import TournamentHandler.entities.Submission;
import TournamentHandler.entities.Team;
import TournamentHandler.entities.Tournament;
import TournamentHandler.requests.RegisterRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationDAO implements IRegistrationDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String registerToEvent(RegisterRequest request) {
        return null;
    }

    @Override
    public Participant markSubmissionAsCorrect(Submission submission) {
        Participant participant = new Participant();
        participant.setName(submission.getUserEntity().getUsername());
        participant.setRoster(submission.getRoster());
        try{
            Session session = sessionFactory.openSession();
            Team team = session.get(Team.class, submission.getTeamId());
            Tournament tournament = session.get(Tournament.class, submission.getTournamentId());
            team.add(participant);
            tournament.getParticipants().add(participant);
            session.save(participant);
            session.saveOrUpdate(team);
            session.saveOrUpdate(tournament);
            session.close();
        }
        finally {
            assert true;
        }
        return participant;
    }
}
