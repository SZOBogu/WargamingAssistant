package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testEntity {

    Entity ent = new Entity("Secrets of Mithril", "The bearer gains Aegis (4+, against Armour Penetration\n" +
            "3 or more).");
    Entity ent0 = new Entity("Strider", "asdasd", "Forest");
    @Test
    public void testGetName(){
        assertEquals("Secrets of Mithril", ent.getName());
    }
    @Test
    public void testGetDescription(){
        assertEquals("The bearer gains Aegis (4+, against Armour Penetration\n" +
                "3 or more).", ent.getDescription());
    }
    @Test
    void testGetParameter(){
        assertTrue(ent.getParameter().isEmpty());
        assertEquals("Forest", ent0.getParameter());
    }

    @Test
    void testSetParameter(){
        ent.setParameter("5+");
        ent0.setParameter("against Flaming Attacks");

        assertEquals("5+", ent.getParameter());
        assertEquals("against Flaming Attacks", ent0.getParameter());
    }

    @Test
    void testToString(){
        assertEquals("Secrets of Mithril", ent.toString());
        assertEquals("Strider(Forest)", ent0.toString());
    }
}
