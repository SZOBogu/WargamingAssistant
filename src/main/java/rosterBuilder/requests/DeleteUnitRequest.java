package rosterBuilder.requests;

public class DeleteUnitRequest {
    private int detachmentId;
    private int categoryId;
    private int unitId;

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
}
