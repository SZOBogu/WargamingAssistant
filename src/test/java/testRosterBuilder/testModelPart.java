package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.entities.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testModelPart {
    Weapon eq00 = new Weapon("en0", "bum bum");
    Entity eq01 =    new Entity("en1", "asd");
    SpecialRule sr00 = new SpecialRule("sr0", "asdas");
    SpecialRule sr01 = new SpecialRule("sr1", "like, really");
    ArrayList<Entity> equipment0 = new ArrayList<>(Arrays.asList(eq00, eq01));
    ArrayList<SpecialRule> specialRules0 = new ArrayList<>(Arrays.asList(sr00, sr01));
    Characteristic characteristic00 = new Characteristic("S", "1");
    Characteristic characteristic01 = new Characteristic("D", "-1");
    Characteristic characteristic02 = new Characteristic("toHit", "3+");
    ArrayList<Characteristic> characteristics = new ArrayList<>(Arrays.asList(characteristic00, characteristic01, characteristic02));

    ModelPart modelPart0 = new ModelPart("Model", characteristics, specialRules0, equipment0);

    @Test
    void testGetName(){
        assertEquals("Model", modelPart0.getName());
    }

    @Test
    void testGetStatline(){
        assertEquals(characteristics, modelPart0.getCharacteristics());
    }

    @Test
    void testGetSpecialRules(){
        assertEquals(specialRules0.size(), modelPart0.getSpecialRules().size());
        assertEquals(specialRules0, modelPart0.getSpecialRules());
    }

    @Test
    void testGetEquipment(){
        assertEquals(equipment0.size(), modelPart0.getEquipment().size());
        assertEquals(equipment0, modelPart0.getEquipment());
    }

    @Test
    void testToString(){
        String expected = "Model\tS: 1 D: -1 toHit: 3+ \tsr0, sr1, en0, en1";
        assertEquals(expected, modelPart0.toString());
    }
}
