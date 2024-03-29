package rosterBuilder.pojos;

import common.Refreshable;
import rosterBuilder.entities.Roster;

import java.util.ArrayList;

public class RosterObserverSubject {
    private Roster roster;
    private ArrayList<Refreshable> refreshables;

    public RosterObserverSubject(){
        this.refreshables = new ArrayList<>();
    }

    public void addRefreshable(Refreshable refreshable){
        refreshables.add(refreshable);
    }

    public Roster getRoster(){
        return this.roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }

    public void refreshComponents(){
        for(Refreshable refreshable : refreshables){
            refreshable.refresh();
        }
    }

    public void removeRefreshable(Refreshable refreshable){
        this.refreshables.remove(refreshable);
    }

    public void removeRefreshables(ArrayList<Refreshable> refreshableList){
        this.refreshables.removeAll(refreshableList);
    }
}
