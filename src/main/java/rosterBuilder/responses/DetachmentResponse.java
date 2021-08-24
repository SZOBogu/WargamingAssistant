package rosterBuilder.responses;

import rosterBuilder.pojos.Army;
import rosterBuilder.pojos.Unit;

import java.util.List;

public class DetachmentResponse {
    private String name;
    private int armyIndex;
    private int detachmentNumber;
    private List<List<Unit>> boughtUnitsCategorized;
    private List<Integer> arrayOfMandatoryChoicesInCategories;
    private List<Integer> arrayOfMaxChoicesPerCategory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmyIndex() {
        return armyIndex;
    }

    public void setArmyIndex(int armyIndex) {
        this.armyIndex = armyIndex;
    }

    public int getDetachmentNumber() {
        return detachmentNumber;
    }

    public void setDetachmentNumber(int detachmentNumber) {
        this.detachmentNumber = detachmentNumber;
    }

    public List<List<Unit>> getBoughtUnitsCategorized() {
        return boughtUnitsCategorized;
    }

    public void setBoughtUnitsCategorized(List<List<Unit>> boughtUnitsCategorized) {
        this.boughtUnitsCategorized = boughtUnitsCategorized;
    }

    public List<Integer> getArrayOfMandatoryChoicesInCategories() {
        return arrayOfMandatoryChoicesInCategories;
    }

    public void setArrayOfMandatoryChoicesInCategories(List<Integer> arrayOfMandatoryChoicesInCategories) {
        this.arrayOfMandatoryChoicesInCategories = arrayOfMandatoryChoicesInCategories;
    }

    public List<Integer> getArrayOfMaxChoicesPerCategory() {
        return arrayOfMaxChoicesPerCategory;
    }

    public void setArrayOfMaxChoicesPerCategory(List<Integer> arrayOfMaxChoicesPerCategory) {
        this.arrayOfMaxChoicesPerCategory = arrayOfMaxChoicesPerCategory;
    }
}
