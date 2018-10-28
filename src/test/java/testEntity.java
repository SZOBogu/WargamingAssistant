import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testEntity {
    @Test
    void testGetName(){
        Entity ent = new Entity("Secrets of Mithril", "The bearer gains Aegis (4+, against Armour Penetration\n" +
                "3 or more).");
        assertEquals("Secrets of Mithril", ent.getName());
    }
    @Test
    void testGetDescription(){
        Entity ent = new Entity("Secrets of Mithril", "The bearer gains Aegis (4+, against Armour Penetration\n" +
                "3 or more).");
        assertEquals("The bearer gains Aegis (4+, against Armour Penetration\n" +
                "3 or more).", ent.getDescription());
    }
}
