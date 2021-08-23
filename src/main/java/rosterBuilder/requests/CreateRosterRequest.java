package rosterBuilder.requests;

public class CreateRosterRequest {
    private int pointCap;
    private int primaryArmyIndex;
    private int detachmentTypeIndex;
    private int wargameId;

    public int getPointCap() {
        return pointCap;
    }

    public void setPointCap(int pointCap) {
        this.pointCap = pointCap;
    }

    public int getPrimaryArmyIndex() {
        return primaryArmyIndex;
    }

    public void setPrimaryArmyIndex(int primaryArmyIndex) {
        this.primaryArmyIndex = primaryArmyIndex;
    }

    public int getDetachmentTypeIndex() {
        return detachmentTypeIndex;
    }

    public void setDetachmentTypeIndex(int detachmentTypeIndex) {
        this.detachmentTypeIndex = detachmentTypeIndex;
    }

    public int getWargameId() {
        return wargameId;
    }

    public void setWargameId(int wargameId) {
        this.wargameId = wargameId;
    }
}
