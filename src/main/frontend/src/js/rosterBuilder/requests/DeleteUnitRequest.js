class DeleteUnitRequest {
    constructor(roster, detachmentIndex, categoryIndex, unitIndex, wargameId) {
        this.roster = roster;
        this.detachmentIndex = detachmentIndex;
        this.categoryIndex = categoryIndex;
        this.unitIndex = unitIndex;
        this.wargameId = wargameId;
    }
}