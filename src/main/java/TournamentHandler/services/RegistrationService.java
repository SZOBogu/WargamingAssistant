package TournamentHandler.services;

import TournamentHandler.daos.IRegistrationDAO;
import TournamentHandler.entities.Participant;
import TournamentHandler.entities.Submission;
import TournamentHandler.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private IRegistrationDAO dao;

    public String registerToEvent(RegisterRequest request){
        return this.dao.registerToEvent(request);
    }

    public Participant markSubmissionAsCorrect(Submission submission) {
        return this.dao.markSubmissionAsCorrect(submission);
    }
}
