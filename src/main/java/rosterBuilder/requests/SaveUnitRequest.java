package rosterBuilder.requests;

import rosterBuilder.entities.Roster;
import rosterBuilder.entities.Unit;
import rosterBuilder.rules.UnitBuildingRule;

import java.util.List;

public class SaveUnitRequest {
    private Roster roster;
    private Unit unit;
    private int armyIndex;
    private int detachmentIndex;
    private int categoryIndex;
    private int wargameId;
    private int unitProfileId;
    private List<UnitBuildingRule> unitBuildingRuleList;

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getArmyIndex() {
        return armyIndex;
    }

    public void setArmyIndex(int armyIndex) {
        this.armyIndex = armyIndex;
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

    public int getWargameId() {
        return wargameId;
    }

    public void setWargameId(int wargameId) {
        this.wargameId = wargameId;
    }

    public int getUnitProfileId() {
        return unitProfileId;
    }

    public void setUnitProfileId(int unitProfileId) {
        this.unitProfileId = unitProfileId;
    }

    public List<UnitBuildingRule> getUnitBuildingRuleList() {
        return unitBuildingRuleList;
    }

    public void setUnitBuildingRuleList(List<UnitBuildingRule> unitBuildingRuleList) {
        this.unitBuildingRuleList = unitBuildingRuleList;
    }
}
