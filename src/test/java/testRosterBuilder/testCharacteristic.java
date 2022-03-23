package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.entities.Characteristic;

import static org.junit.jupiter.api.Assertions.assertEquals;

class testCharacteristic {
    Characteristic stat = new Characteristic("Strength", "2D6");

    @Test
    public void testGetName() {
        assertEquals("Strength", stat.getName());
    }

    @Test
    public void testGetValue() {
        assertEquals("2D6", stat.getValue());
    }

    @Test
    public void testToString() {
        assertEquals("Strength: 2D6", stat.toString());
    }
}
