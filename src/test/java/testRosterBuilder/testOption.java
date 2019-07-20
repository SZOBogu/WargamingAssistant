package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.Entity;
import rosterBuilder.Option;
import rosterBuilder.SpecialRule;
import rosterBuilder.Weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testOption {
    Option option0 = new Option(new Entity("Miecz", "+1S"), 30);
    Option option1 = new Option(new SpecialRule("Cieknace wiadro", "+1 do przeciekania"), -30);
    Option option2 = new Option(new Weapon("Tarcza", "+Def"), 0);

    @Test
    void testGetEntity(){
        assertTrue(option0.getEntity().equals(new Entity("Miecz", "+1S")));
        assertTrue(option1.getEntity().equals(new SpecialRule("Cieknace wiadro", "+1 do przeciekania")));
        assertTrue(option2.getEntity().equals(new Weapon("Tarcza", "+Def")));
    }

    @Test
    void testGetCost(){
        assertEquals(30, option0.getCost());
        assertEquals(-30, option1.getCost());
        assertEquals(0, option2.getCost());
    }

    @Test
    void testToString(){
        assertEquals("Miecz\t30p", option0.toString());
        assertEquals("Cieknace wiadro\t-30p", option1.toString());
        assertEquals("Tarcza\t0p", option2.toString());
    }
}
