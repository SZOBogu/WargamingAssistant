class SaveDetachmentRequest {
    constructor(roster, detachmentIndex, wargameId) {
        this.roster = roster;
        this.detachmentIndex = detachmentIndex;
        this.wargameId = wargameId;
    }
}

export default SaveDetachmentRequest;