package testDiceRollSimulator;

import diceRollSimulator.DiceRoll;
import diceRollSimulator.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDatabase {
    Database db = new Database();
    DiceRoll dr1 = new DiceRoll(10, 5, false, false, 6);
    DiceRoll dr2 = new DiceRoll(10, 5, true, true, 8);

    @Test
    public void testGetDiceRolls(){
        assertEquals(db.getDiceRolls(), new ArrayList<DiceRoll>());
    }

    @Test
    public void testAddDiceRoll(){
        db.addDiceRoll(dr1);
        db.addDiceRoll(dr2);


        Database db1 = new Database();
        DiceRoll dr11 = new DiceRoll(10, 5, false, false, 6);
        DiceRoll dr21 = new DiceRoll(10, 5, true, true, 8);

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
