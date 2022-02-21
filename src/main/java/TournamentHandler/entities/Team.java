package TournamentHandler.entities;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Participant> members;

    public Team() {
        this.members = new ArrayList<>();
    }

    public void add(Participant participant){
        this.members.add(participant);
    }
}
