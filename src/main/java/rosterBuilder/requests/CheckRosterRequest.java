package rosterBuilder.requests;

import rosterBuilder.pojos.Roster;
import rosterBuilder.rules.RosterBuildingRule;

import java.util.List;

public class CheckRosterRequest {
    private int wargameId;
    private Roster roster;
    private List<RosterBuildingRule> eventRosterRules;

    public int getWargameId() {
        return wargameId;
    }

    public void setWargameId(int wargameId) {
        this.wargameId = wargameId;
    }

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }

    public List<RosterBuildingRule> getEventRules() {
        return eventRosterRules;
    }

    public void setEventRules(List<RosterBuildingRule> eventRules) {
        this.eventRosterRules = eventRules;
    }
}
