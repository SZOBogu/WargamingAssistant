package testCommon;

import common.Dice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testDice {
    Dice d6 = new Dice();
    Dice d8 = new Dice(8);
    Dice du = new Dice(-28);

    @Test
    void getMaxTest(){
        assertEquals(d6.getMax(), 6);
        assertEquals(d8.getMax(), 8);
        assertEquals(du.getMax(), 6);
    }

    @Test
    void rollTest(){
        for(int i=0; i<1000; i++) {
            int result6 = d6.roll();
            int result8 = d8.roll();

            assertTrue(result6 >= 1 && result6 <= 6);
            assertTrue(result8 >= 1 && result8 <= 8);
        }
    }
}
