package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.Entity;
import rosterBuilder.SpecialRule;
import rosterBuilder.Unit;
import rosterBuilder.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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
    Unit unit0 = new Unit();

    @Test
    void testGetName(){
        assertEquals("Unit", unit.getName());
        assertEquals("", unit0.getName());
    }

    @Test
    void testGetModelsInUnit(){
        assertEquals(20, unit.getModelsInUnit());
        assertEquals(1, unit0.getModelsInUnit());
    }

    @Test
    void testGetNonBaseEquipment(){
        assertEquals(unit.getNonBaseEquipment().get(0), new Entity("Miecz", "+1S", "lvl1"));
        assertEquals(unit.getNonBaseEquipment().get(1), new SpecialRule("Cieknace wiadro", "+1 do przeciekania"));
        assertEquals(unit.getNonBaseEquipment().get(2), new Weapon("Tarcza", "+Def"));

        assertEquals(new ArrayList<>(), unit0.getNonBaseEquipment());
    }

    @Test
    void testGetBaseEquipmentAndRules(){

        assertEquals(unit.getBaseEquipmentAndRules(), standard);
        assertEquals(new ArrayList<>(), unit0.getBaseEquipmentAndRules());
    }

    @Test
    void testGetPointCost(){
        assertEquals(1000, unit.getPointCost());
        assertEquals(0, unit0.getPointCost());
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
    void testSetNonBaseEquipment(){
        assertEquals(3, unit.getNonBaseEquipment().size());
        ArrayList<Entity> boughtEquipment = new ArrayList<>(Arrays.asList(eq0, eq2, eq1, eq3, eq4));
        unit.setNonBaseEquipment(boughtEquipment);
        assertEquals(5, unit.getNonBaseEquipment().size());
        assertEquals(eq0, unit.getNonBaseEquipment().get(0));
        assertEquals(eq2, unit.getNonBaseEquipment().get(1));
        assertEquals(eq1, unit.getNonBaseEquipment().get(2));
        assertEquals(eq3, unit.getNonBaseEquipment().get(3));
        assertEquals(eq4, unit.getNonBaseEquipment().get(4));
    }

    @Test
    void testToString(){
        String expected = "20 Unit, " + unit.getNonBaseEquipment().get(0).toString() +
                ", " + unit.getNonBaseEquipment().get(1).toString() + ", " +  unit.getNonBaseEquipment().get(2).toString() +  "\t[1000]";
        assertEquals(expected, unit.toString());
        assertEquals("\t[0]", unit0.toString());
    }
}