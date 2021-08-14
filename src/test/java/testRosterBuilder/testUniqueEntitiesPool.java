package testRosterBuilder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import rosterBuilder.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testUniqueEntitiesPool {
    SpecialRule specialRule = new SpecialRule("usr", "");
    Item item = new Item("ring", "");
    Entity entity = new Entity("ent", "");
    Weapon weapon = new Weapon("excalibur", "", new Statline(new ArrayList<>(Arrays.asList(new Statistic("S", "10"), new Statistic("AP", "-5")))));
    ArrayList<Entity> entities = new ArrayList<>(Arrays.asList(specialRule, item, entity, weapon));
    UniqueEntitiesPool pool = new UniqueEntitiesPool(entities);

    @Test
    public void testGetAvailable(){
        assertEquals(entities, pool.getAvailable());
    }

    @Test
    public void testContains(){
        assertTrue(pool.contains(specialRule));
        assertTrue(pool.contains(item));
        assertTrue(pool.contains(entity));
        assertTrue(pool.contains(weapon));

        Entity entity0 = new Entity("ent", "");
        Entity entity1 = new Entity("ent1", "");

        assertTrue(pool.contains(entity0));
        assertFalse(pool.contains(entity1));
    }

    @Test
    public void testGet(){
        Entity entity0 = pool.get("ent");
        assertSame(entity, entity0);
        assertFalse(pool.getAvailable().contains(entity));
        assertTrue(pool.contains(entity));
    }

    @Test
    public void testRelease(){
        Entity entity0 = pool.get("ent");
        assertSame(entity, entity0);
        assertFalse(pool.getAvailable().contains(entity));
        assertTrue(pool.contains(entity));

        pool.release(entity0);
        assertTrue(pool.getAvailable().contains(entity));
        assertTrue(pool.contains(entity));
    }
}
