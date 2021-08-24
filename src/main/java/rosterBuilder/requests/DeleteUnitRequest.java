package rosterBuilder.requests;

import rosterBuilder.pojos.Roster;

public class DeleteUnitRequest {
    private Roster roster;
    private int detachmentIndex;
    private int categoryIndex;
    private int unitIndex;
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

    public int getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(int categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    public int getUnitIndex() {
        return unitIndex;
    }

    public void setUnitIndex(int unitIndex) {
        this.unitIndex = unitIndex;
    }

    public int getWargameId() {
        return wargameId;
    }

    public void setWargameId(int wargameId) {
        this.wargameId = wargameId;
    }
}
