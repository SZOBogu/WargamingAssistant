package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testModelPart {
    Option option00 = new Option(new Weapon("op00", "bum bum"), 20);
    Option option01 = new Option(new SpecialRule("op01", "asdas"), 50);
    OptionSet optionSet0 = new SingleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option00, option01)));

    Option option10 = new Option(new Weapon("op10", "bam bam"), 200);
    Option option11 = new Option(new SpecialRule("op11", "asdasa"), 500);
    OptionSet optionSet1 = new MultipleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option10, option11)));

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
    void testAutism(){
        assertEquals(2, equipment0.size());
        assertEquals(2, specialRules0.size());

        assertEquals(2, modelPart0.getEquipment().size());
        assertEquals(2, modelPart0.getSpecialRules().size());
    }

    @Test
    void testGetName(){
        assertEquals("Model", modelPart0.getName());
    }

    @Test
    void testGetStatline(){
        assertTrue(statistic00.equals(modelPart0.getStatline().getStatistic(0)));
        assertTrue(statistic01.equals(modelPart0.getStatline().getStatistic(1)));
        assertTrue(statistic02.equals(modelPart0.getStatline().getStatistic(2)));
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

//    @Test
//    void testGetBaseEquipmentAndRules(){
//        ArrayList<Entity> tempEnts = modelPart0.getEquipment();
//        assertEquals(2 ,tempEnts.size());
//        assertTrue(tempEnts.addAll(specialRules0));
//        assertEquals(4 ,tempEnts.size());
//        assertEquals(tempEnts, modelPart0.getBaseEquipmentAndRules());
//    }
}
