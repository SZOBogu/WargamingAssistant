package tournamentHandler.daos;

import tournamentHandler.entities.Participant;
import tournamentHandler.entities.Submission;
import tournamentHandler.requests.RegisterRequest;

public interface IRegistrationDAO{
    String registerToEvent(RegisterRequest request);
    Participant markSubmissionAsCorrect(Submission submission);
}
