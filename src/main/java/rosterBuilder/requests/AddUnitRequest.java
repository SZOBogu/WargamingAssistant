package rosterBuilder.requests;

import rosterBuilder.Unit;

public class AddUnitRequest {
    private Unit unit;
    private int detachmentId;
    private int categoryId;

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
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
}
