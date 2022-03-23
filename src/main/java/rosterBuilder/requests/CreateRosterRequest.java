package rosterBuilder.requests;

public class CreateRosterRequest {
    private int wargameId;
    private int armyId;
    private int detachmentId;
    private int pointLimit;

    public int getWargameId() {
        return wargameId;
    }

    public void setWargameId(int wargameId) {
        this.wargameId = wargameId;
    }

    public int getArmyId() {
        return armyId;
    }

    public void setArmyId(int armyId) {
        this.armyId = armyId;
    }

    public int getDetachmentId() {
        return detachmentId;
    }

    public void setDetachmentId(int detachmentId) {
        this.detachmentId = detachmentId;
    }

    public int getPointLimit() {
        return pointLimit;
    }

    public void setPointLimit(int pointLimit) {
        this.pointLimit = pointLimit;
    }
}
