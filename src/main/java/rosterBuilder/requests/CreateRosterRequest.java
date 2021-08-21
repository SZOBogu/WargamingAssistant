package rosterBuilder.requests;

public class CreateRosterRequest {
    private int pointCap;
    private int primaryArmyIndex;
    private int detachmentTypeIndex;

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
}
