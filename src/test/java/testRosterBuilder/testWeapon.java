package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.entities.Characteristic;
import rosterBuilder.entities.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class testWeapon {
    Weapon weapon0 = new Weapon("CCW", "-", "5+");
    Characteristic stat0 = new Characteristic("Range", "24\"");
    Characteristic stat1 = new Characteristic("Str", "4");
    List<Characteristic> statline = new ArrayList<>(Arrays.asList(stat0, stat1));
    Weapon weapon1 = new Weapon("Bolter", "pew pew", statline);

    @Test
    void testGetName(){
        assertEquals("CCW", weapon0.getName());
        assertEquals("Bolter", weapon1.getName());
    }
    @Test
    void testGetDescription(){
        assertEquals("-", weapon0.getDescription());
        assertEquals("pew pew", weapon1.getDescription());
    }
    @Test
    void testGetStatline(){
        assertEquals(new ArrayList<>(), weapon0.getStatline());
        assertEquals(statline, weapon1.getStatline());
    }

    @Test
    void testGetParameter(){
        assertTrue(weapon1.getParameter().isEmpty());
        assertEquals("5+", weapon0.getParameter());
    }

    @Test
    void testSetParameter(){
        weapon0.setParameter("5+");
        weapon1.setParameter("against Flaming Attacks");

        assertEquals("5+", weapon0.getParameter());
        assertEquals("against Flaming Attacks", weapon1.getParameter());
    }

    @Test
    void testToString(){
        assertEquals("CCW(5+)", weapon0.toString());
        assertEquals("Bolter", weapon1.toString());
    }

}

