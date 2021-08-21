package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testQuantityDependentOption {
    QuantityDependentOption option0 = new QuantityDependentOption(new Entity("Miecz", "+1S"), 3, 10);
    QuantityDependentOption option1 = new QuantityDependentOption(new SpecialRule("Cieknace wiadro", "+1 do przeciekania"), -3, 20);
    QuantityDependentOption option2 = new QuantityDependentOption(new Weapon("Tarcza", "+Def"), 0, 30);

    @Test
    void testGetEntity(){
        assertEquals(option0.getEntity(), new Entity("Miecz", "+1S"));
        assertEquals(option1.getEntity(), new SpecialRule("Cieknace wiadro", "+1 do przeciekania"));
        assertEquals(option2.getEntity(), new Weapon("Tarcza", "+Def"));
    }

    @Test
    void testGetCost(){
        assertEquals(30, option0.getCost());
        assertEquals(-60, option1.getCost());
        assertEquals(0, option2.getCost());
    }

    @Test
    void testToString(){
        assertEquals("Miecz\t3p/per model", option0.toString());
        assertEquals("Cieknace wiadro\t-3p/per model", option1.toString());
        assertEquals("Tarcza\t0p/per model", option2.toString());
    }
}
