class SaveUnitRequest {
    constructor(roster, unit, armyIndex, detachmentIndex, categoryIndex, wargameId) {
        this.roster = roster;
        this.unit = unit;
        this.armyIndex = armyIndex;
        this.detachmentIndex = detachmentIndex;
        this.categoryIndex = categoryIndex;
        this.wargameId = wargameId;
    }
}