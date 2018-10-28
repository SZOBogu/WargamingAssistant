import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testItem {
    Item item = new Item("Winter Cloak", "The bearer gains Distracting, Aegis (5+), and Aegis (2+,\n" +
            "against Flaming Attacks).");
    @Test
    public void testGetName(){
        assertEquals("Winter Cloak", item.getName());
    }
    @Test
    public void testGetDescription(){
        assertEquals("The bearer gains Distracting, Aegis (5+), and Aegis (2+,\n" +
                "against Flaming Attacks).", item.getDescription());
    }
}