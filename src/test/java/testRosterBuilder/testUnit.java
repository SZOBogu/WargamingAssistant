package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.Entity;
import rosterBuilder.SpecialRule;
import rosterBuilder.Unit;
import rosterBuilder.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testUnit {
    Entity eq0 = new Entity("Miecz", "+1S");
    Entity eq1 = new SpecialRule("Cieknace wiadro", "+1 do przeciekania");
    Entity eq2 = new Weapon("Tarcza", "+Def");
    ArrayList<Entity> equipment = new ArrayList<>(Arrays.asList(eq0, eq1, eq2));

    Entity eq3 = new Entity("lekka zbroja", "+1S");
    Entity eq4 = new SpecialRule("kula u nogi", "");
    Entity eq5 = new Weapon("czapka", "+Def");
    ArrayList<Entity> standard = new ArrayList<>(Arrays.asList(eq3, eq4, eq5));

    Unit unit = new Unit("Unit", 20, equipment, standard, 1000);

    @Test
    void testGetName(){
        assertEquals("Unit", unit.getName());
    }

    @Test
    void testGetModelsInUnit(){
        assertEquals(20, unit.getModelsInUnit());
    }

    @Test
    void testGetNonBaseEquipment(){
        assertTrue(unit.getNonBaseEquipment().get(0).equals(new Entity("Miecz", "+1S", "lvl1")));
        assertTrue(unit.getNonBaseEquipment().get(1).equals(new SpecialRule("Cieknace wiadro", "+1 do przeciekania")));
        assertTrue(unit.getNonBaseEquipment().get(2).equals(new Weapon("Tarcza", "+Def")));
    }

    @Test
    void testGetBaseEquipmentAndRules(){
        assertEquals(unit.getBaseEquipmentAndRules(), standard);
    }

    @Test
    void testGetPointCost(){
        assertEquals(1000, unit.getPointCost());
    }

    @Test
    void testAddEquipment (){
        assertEquals(3, unit.getNonBaseEquipment().size());
        Entity eq3 = new Weapon("test", "test");
        unit.addEquipment(eq3);
        assertEquals(4, unit.getNonBaseEquipment().size());
    }

    @Test
    void testSetPointCost (){
        assertEquals(1000, unit.getPointCost());
        unit.setPointCost(300);
        assertEquals(300, unit.getPointCost());
    }

    @Test
    void testSetModelsIntUnit (){
        assertEquals(20, unit.getModelsInUnit());
        unit.setModelsInUnit(30);
        assertEquals(30, unit.getModelsInUnit());
    }

    @Test
    void testToString(){
        String expected = "20 Unit, " + unit.getNonBaseEquipment().get(0).toString() +
                ", " + unit.getNonBaseEquipment().get(1).toString() + ", " +  unit.getNonBaseEquipment().get(2).toString() +  "\t[1000]";
        assertEquals(expected, unit.toString());
    }
}