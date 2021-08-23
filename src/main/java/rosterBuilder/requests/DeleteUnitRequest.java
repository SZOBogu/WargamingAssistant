package rosterBuilder.requests;

import rosterBuilder.pojos.Roster;

public class DeleteUnitRequest {
    private Roster roster;
    private int detachmentId;
    private int categoryId;
    private int unitId;
    private int wargameId;

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }

    public int getDetachmentId() {
        return detachmentId;
    }

    public void setDetachmentId(int detachmentId) {
        this.detachmentId = detachmentId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getWargameId() {
        return wargameId;
    }

    public void setWargameId(int wargameId) {
        this.wargameId = wargameId;
    }
}
