package testDiceRollSimulator;

import diceRollSimulator.DiceRoll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDiceRoll {
    public DiceRoll testRoll0 = new DiceRoll(10, 5, false, false, 6);
    public DiceRoll testRoll1 = new DiceRoll(11, 5, true, true, 8);
    public DiceRoll testRoll2 = new DiceRoll(12, 5, true, true, 8, 1);


    @Test
    public void testRollDices(){
        ArrayList<Integer> results0 = testRoll0.rollDices();
        ArrayList<Integer> results1 = testRoll1.rollDices();
        ArrayList<Integer> results2 = testRoll2.rollDices();

        assertThat(results0, everyItem(greaterThanOrEqualTo(1)));
        assertThat(results0, everyItem(lessThanOrEqualTo(6)));
        assertThat(results1, everyItem(greaterThanOrEqualTo(1)));
        assertThat(results1, everyItem(lessThanOrEqualTo(8)));
        assertThat(results2, everyItem(greaterThanOrEqualTo(1)));
        assertThat(results2, everyItem(lessThanOrEqualTo(8)));
    }

    @Test
    public void testMakeDiceRoll(){
        ArrayList<ArrayList<Integer>> results0 = testRoll0.makeDiceRoll();
        ArrayList<ArrayList<Integer>> results1 = testRoll1.makeDiceRoll();
        ArrayList<ArrayList<Integer>> results2 = testRoll2.makeDiceRoll();

        assertEquals(results0.size(), 1);
        assertEquals(results1.size(), 2);
        assertEquals(results2.size(), 2);

        assertEquals(results0.get(0).size(), testRoll0.getQuantity());
        assertEquals(results1.get(0).size(), testRoll1.getQuantity());
        assertEquals(results1.get(1).size(), testRoll1.getQuantity());
        assertEquals(results2.get(0).size(), testRoll2.getQuantity());
        assertEquals(results2.get(1).size(), testRoll2.getQuantity());
    }

    @Test
    public void testEquals(){
         DiceRoll testRoll01 = new DiceRoll(10, 5, false, false, 6);
         DiceRoll testRoll11 = new DiceRoll(11, 5, true, true, 8);
         DiceRoll testRoll21 = new DiceRoll(12, 5, false, true, 8, 1);

        assertEquals(testRoll01, testRoll0);
        assertEquals(testRoll11, testRoll1);
        assertEquals(testRoll21, testRoll2);
    }

    @Test
    public void testToString() {
        String desc0 = testRoll0.toString();
        String desc1 = testRoll1.toString();
        String desc2 = testRoll2.toString();

        assertEquals(desc0, "D6 roll on 5+");
        assertEquals(desc1, "D8 roll on 5- with reroll");
        assertEquals(desc2, "D8 roll on 5- with reroll of 1s");
    }
}
