package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.entities.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testItem {
    Item item = new Item("Winter Cloak", "The bearer gains Distracting, Aegis (5+), and Aegis (2+,\n" +
            "against Flaming Attacks).");
    Item item0 = new Item("Winter Cloak", "The bearer gains Distracting, Aegis (5+), and Aegis (2+,\n" +
            "against Flaming Attacks).", "4+");
    @Test
    public void testGetName(){
        assertEquals("Winter Cloak", item.getName());
    }
    @Test
    public void testGetDescription(){
        assertEquals("The bearer gains Distracting, Aegis (5+), and Aegis (2+,\n" +
                "against Flaming Attacks).", item.getDescription());
    }

    @Test
    void testGetParameter(){
        assertTrue(item.getParameter().isEmpty());
        assertEquals("4+", item0.getParameter());
    }

    @Test
    void testSetParameter(){
        item.setParameter("5+");
        item0.setParameter("against Flaming Attacks");

        assertEquals("5+", item.getParameter());
        assertEquals("against Flaming Attacks", item0.getParameter());
    }

    @Test
    void testToString(){
        assertEquals("Winter Cloak", item.toString());
        assertEquals("Winter Cloak(4+)", item0.toString());
    }
}