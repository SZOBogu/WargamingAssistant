package testDiceRollSimulator;

import diceRollSimulator.utility.DiceRoll;
import diceRollSimulator.utility.DiceRollList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDiceRollList {
    DiceRollList db = new DiceRollList();
    DiceRoll dr1 = new DiceRoll.DiceRollBuilder(10, 5).build();
    DiceRoll dr2 = new DiceRoll.DiceRollBuilder(10, 5).reroll(true).failures(true).diceSides(8).build();

    @Test
    public void testGetDiceRolls(){
        assertEquals(db.getDiceRolls(), new ArrayList<DiceRoll>());
    }

    @Test
    public void testAddDiceRoll(){
        db.addDiceRoll(dr1);
        db.addDiceRoll(dr2);


        DiceRollList db1 = new DiceRollList();
        DiceRoll dr11 = new DiceRoll.DiceRollBuilder(10, 5).reroll(false).build();
        DiceRoll dr21 = new DiceRoll.DiceRollBuilder(10, 5).reroll(true).failures(true).diceSides(8).build();

        db1.addDiceRoll(dr11);
        db1.addDiceRoll(dr21);
        assertEquals(db.getDiceRolls().size(), 2);
        assertEquals(db.getDiceRolls().get(1), db1.getDiceRolls().get(1));
    }

    @Test
    public void testRemoveDiceRoll(){
        db.addDiceRoll(dr1);
        db.addDiceRoll(dr2);

        assertEquals(db.getDiceRolls().size(), 2);
        db.removeDiceRoll(1);
        assertEquals(db.getDiceRolls().size(), 1);
        db.removeDiceRoll(0);
        assertEquals(db.getDiceRolls().size(), 0);
    }

    @Test
    public void testClear(){
        db.addDiceRoll(dr1);
        db.addDiceRoll(dr2);
        assertEquals(db.getDiceRolls().size(), 2);
        db.clear();
        assertEquals(db.getDiceRolls().size(), 0);
    }
}
