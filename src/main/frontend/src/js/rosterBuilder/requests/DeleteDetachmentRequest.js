class DeleteDetachmentRequest {
    constructor(roster, detachmentIndex, wargameId) {
        this.roster = roster;
        this.detachmentIndex = detachmentIndex;
        this.wargameId = wargameId;
    }
}

export default DeleteDetachmentRequest;