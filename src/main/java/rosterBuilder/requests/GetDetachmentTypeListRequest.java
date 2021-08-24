package rosterBuilder.requests;

import rosterBuilder.pojos.Detachment;

import java.util.List;

public class GetDetachmentTypeListRequest {
    private int wargameId;

    public int getWargameId() {
        return wargameId;
    }

    public void setWargameId(int wargameId) {
        this.wargameId = wargameId;
    }
}
