package diceRollSimulator.requests;

import diceRollSimulator.pojos.DiceRoll;

import java.util.List;

public class RunDiceRollsRequest {
    private List<DiceRoll> diceRollList;

    public List<DiceRoll> getDiceRollList() {
        return diceRollList;
    }

    public void setDiceRollList(List<DiceRoll> diceRollList) {
        this.diceRollList = diceRollList;
    }

    @Override
    public String toString() {
        return "RunDiceRollsRequest{" +
                "diceRollList=" + diceRollList +
                '}';
    }
}
