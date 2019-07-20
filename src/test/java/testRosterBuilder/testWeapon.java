package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.Statistic;
import rosterBuilder.Statline;
import rosterBuilder.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class testWeapon {
    Weapon weapon0 = new Weapon("CCW", "-", "5+");
    Statistic stat0 = new Statistic("Range", "24\"");
    Statistic stat1 = new Statistic("Str", "4");
    Statline statline = new Statline(new ArrayList<>(Arrays.asList(stat0, stat1)));
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
        assertEquals(new Statline(), weapon0.getStatline());
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

