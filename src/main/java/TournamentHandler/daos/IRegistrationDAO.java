package TournamentHandler.daos;

import TournamentHandler.entities.Participant;
import TournamentHandler.entities.Submission;
import TournamentHandler.requests.RegisterRequest;

public interface IRegistrationDAO{
    String registerToEvent(RegisterRequest request);
    Participant markSubmissionAsCorrect(Submission submission);
}
