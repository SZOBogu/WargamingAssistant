package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.Entity;
import rosterBuilder.EntityContainer;
import rosterBuilder.Item;
import rosterBuilder.SpecialRule;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testEntityContainer {
    Item lightArmour = new Item("Light Armour", "+1 Armour.");
    Item heavyArmour = new Item("Heavy Armour", "+2 Armour.");
    Item plateArmour = new Item("Plate Armour", "+3 Armour.");
    Item shield = new Item("Shield", "Two-Handed weapons prevent the simultaneous use of a Shield against Melee Attacks (see “Weapons ”, page 106 ).");
    ArrayList<Entity> entities1 = new ArrayList<>(Arrays.asList(lightArmour, heavyArmour, plateArmour, shield));

    Item kamien = new Item("Kamien", "mozna nim go centralnie bez kitu");
    SpecialRule costam = new SpecialRule("Costam", "csoajfsojfaofs");
    ArrayList<Entity> entities2 = new ArrayList<>(Arrays.asList(kamien, costam));

    EntityContainer entityContainer0 = new EntityContainer();
    EntityContainer entityContainer1 = new EntityContainer(entities1);

    @Test
    void testContains(){
        assertTrue(entityContainer1.contains(shield));
        assertFalse(entityContainer0.contains(shield));
        assertFalse(entityContainer1.contains(kamien));

        assertTrue(entityContainer1.contains("Plate Armour"));
        assertFalse(entityContainer0.contains("Plate Armour"));
        assertFalse(entityContainer1.contains("zloty rolex"));
    }

    @Test
    void testSize(){
        assertEquals(0, entityContainer0.size());
        assertEquals(4, entityContainer1.size());
    }

    @Test
    void testAdd(){
        assertEquals(0, entityContainer0.size());
        entityContainer0.add(kamien);
        assertEquals(1, entityContainer0.size());
        assertTrue(entityContainer0.contains(kamien));
    }

    @Test
    void testAddAll(){
        assertEquals(0, entityContainer0.size());
        entityContainer0.addAll(entities2);
        assertEquals(2, entityContainer0.size());
        assertTrue(entityContainer0.contains(kamien));
        assertTrue(entityContainer0.contains(costam));
    }

    @Test
    void testGetAll(){
        assertEquals(entities1, entityContainer1.getAll());
    }

    @Test
    void testGetByIndex(){
        assertEquals(heavyArmour, entityContainer1.get(1));
        assertNotSame(heavyArmour, entityContainer1.get(1));
    }

    @Test
    void testGetByName(){
        assertNotSame(shield, entityContainer1.get(1));
        assertEquals(shield, entityContainer1.get("Shield"));
    }

    @Test
    void testClear(){
        assertEquals(4, entityContainer1.size());
        entityContainer1.clear();
        assertEquals(0, entityContainer1.size());
    }

    @Test
    void testRemoveByIndex(){
        assertTrue(entityContainer1.contains(plateArmour));
        entityContainer1.remove(2);
        assertFalse(entityContainer1.contains(plateArmour));
    }

    @Test
    void testRemoveByName(){
        assertTrue(entityContainer1.contains(heavyArmour));
        entityContainer1.remove("Heavy Armour");
        assertFalse(entityContainer1.contains(heavyArmour));
    }


}
