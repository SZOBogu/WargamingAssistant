import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testEntity {

    Entity ent = new Entity("Secrets of Mithril", "The bearer gains Aegis (4+, against Armour Penetration\n" +
            "3 or more).");
    @Test
    public void testGetName(){
        assertEquals("Secrets of Mithril", ent.getName());
    }
    @Test
    public void testGetDescription(){
        assertEquals("The bearer gains Aegis (4+, against Armour Penetration\n" +
                "3 or more).", ent.getDescription());
    }
}
