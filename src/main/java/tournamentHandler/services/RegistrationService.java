package tournamentHandler.services;

import tournamentHandler.daos.IRegistrationDAO;
import tournamentHandler.entities.Participant;
import tournamentHandler.entities.Submission;
import tournamentHandler.requests.RegisterRequest;
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
