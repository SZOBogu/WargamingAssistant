import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testItem {
    @Test
    public void testGetName(){
        Item item = new Item("Winter Cloak", "The bearer gains Distracting, Aegis (5+), and Aegis (2+,\n" +
                "against Flaming Attacks).");
        assertEquals("Winter Cloak", item.getName());
    }
    @Test
    public void testGetDescription(){
        Item item = new Item("Winter Cloak", "The bearer gains Distracting, Aegis (5+), and Aegis (2+,\n" +
                "against Flaming Attacks).");
        assertEquals("The bearer gains Distracting, Aegis (5+), and Aegis (2+,\n" +
                "against Flaming Attacks).", item.getDescription());
    }
}