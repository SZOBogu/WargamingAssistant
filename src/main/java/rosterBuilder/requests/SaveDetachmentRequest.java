package rosterBuilder.requests;


import rosterBuilder.entities.Roster;

public class SaveDetachmentRequest {
    private Roster roster;
    private int detachmentIndex;
    private int armyIndex;
    private int wargameId;

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }

    public int getDetachmentIndex() {
        return detachmentIndex;
    }

    public void setDetachmentIndex(int detachmentIndex) {
        this.detachmentIndex = detachmentIndex;
    }

    public int getArmyIndex() {
        return armyIndex;
    }

    public void setArmyIndex(int armyIndex) {
        this.armyIndex = armyIndex;
    }

    public int getWargameId() {
        return wargameId;
    }

    public void setWargameId(int wargameId) {
        this.wargameId = wargameId;
    }
}
