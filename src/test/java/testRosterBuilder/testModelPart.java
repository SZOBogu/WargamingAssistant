package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.pojos.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testModelPart {
    Weapon eq00 = new Weapon("en0", "bum bum");
    Entity eq01 =    new Entity("en1", "asd");
    SpecialRule sr00 = new SpecialRule("sr0", "asdas");
    SpecialRule sr01 = new SpecialRule("sr1", "like, really");
    ArrayList<Entity> equipment0 = new ArrayList<>(Arrays.asList(eq00, eq01));
    ArrayList<SpecialRule> specialRules0 = new ArrayList<>(Arrays.asList(sr00, sr01));
    Statistic statistic00 = new Statistic("S", "1");
    Statistic statistic01 = new Statistic("D", "-1");
    Statistic statistic02 = new Statistic("toHit", "3+");
    Statline statline0 = new Statline(new ArrayList<>(Arrays.asList(statistic00, statistic01, statistic02)));

    ModelPart modelPart0 = new ModelPart("Model", statline0, specialRules0, equipment0);

    @Test
    void testGetName(){
        assertEquals("Model", modelPart0.getName());
    }

    @Test
    void testGetStatline(){
        assertEquals(statistic00, modelPart0.getStatline().getStatistic(0));
        assertEquals(statistic01, modelPart0.getStatline().getStatistic(1));
        assertEquals(statistic02, modelPart0.getStatline().getStatistic(2));
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
