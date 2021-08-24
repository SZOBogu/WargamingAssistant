package rosterBuilder.requests;

public class GetUnitListRequest {
    private int wargameIndex;
    private int armyIndex;

    public int getWargameIndex() {
        return wargameIndex;
    }

    public void setWargameIndex(int wargameIndex) {
        this.wargameIndex = wargameIndex;
    }

    public int getArmyIndex() {
        return armyIndex;
    }

    public void setArmyIndex(int armyIndex) {
        this.armyIndex = armyIndex;
    }
}
