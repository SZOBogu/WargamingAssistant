package testCommon;

import common.Rounder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class testRounder {
    @Test
    void testRound(){
        assertEquals(1.52, Rounder.round(1.51501));       //co za idiotyzm
        assertEquals(0, Rounder.round(0.001));
        assertEquals(1.51, Rounder.round(1.515));


        assertEquals(1.0001, Rounder.round(1.000051,4));       //co za idiotyzm
        assertEquals(0, Rounder.round(0.00001, 4));
        assertEquals(1.0001, Rounder.round(1.00005, 4));
    }
}
