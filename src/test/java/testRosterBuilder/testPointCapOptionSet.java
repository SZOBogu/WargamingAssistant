package testRosterBuilder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import rosterBuilder.entities.*;
import rosterBuilder.exceptions.UnitBuildingException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testPointCapOptionSet {
    SpecialRule ambush = Mockito.mock(SpecialRule.class);
    Item lightArmour = Mockito.mock(Item.class);
    Weapon pairedWeapons = Mockito.mock(Weapon.class);

    SpecialRule wizardAdept = Mockito.mock(SpecialRule.class);
    SpecialRule wizardMaster = Mockito.mock(SpecialRule.class);

    Option op0 = new Option(ambush, 10);
    Option op1 = new Option(lightArmour, 5);
    Option op2 = new Option(pairedWeapons, 5);
    Option op3 = new Option(wizardAdept, 15);
    Option op4 = new Option(wizardMaster, 25);

    ArrayList<Option> options = new ArrayList<>(Arrays.asList(op0, op1, op2, op3, op4));
    ArrayList<Integer> chosenOptions = new ArrayList<>(Arrays.asList(0, 1, 4));
    PointCapOptionSet optionSet = new PointCapOptionSet(options, 40);
    PointCapOptionSet optionSet1 = new PointCapOptionSet(options, true, 40);
    PointCapOptionSet optionSet2 = new PointCapOptionSet(options, "Special Equipment", "get", 40);
    PointCapOptionSet optionSet3 = new PointCapOptionSet(options, "Wizard", "become",true,  40);

    @Test
    void testGetAllEntities(){
        assertEquals(new ArrayList<>(Arrays.asList(ambush, lightArmour, pairedWeapons, wizardAdept, wizardMaster)), optionSet.getAllEntities());
    }

    @Test
    void testGetCost(){
        assertEquals(40, optionSet.getCost(chosenOptions));
    }

    @Test
    void testGetEntities(){
        assertNotNull(optionSet.getEntities(chosenOptions));
        assertThrows(UnitBuildingException.class, () -> optionSet.getEntities(new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4))));
    }

    @Test
    void testGetDescription(){
        assertEquals("May take (max 40 points):", optionSet.getDescription());
        assertEquals("Must take (max 40 points):", optionSet1.getDescription());
        assertEquals("May get Special Equipment (max 40 points):", optionSet2.getDescription());
        assertEquals("Must become Wizard (max 40 points):", optionSet3.getDescription());
    }

    @Test
    void testGetKeyVerb(){
        assertEquals("take", optionSet.getKeyVerb());
        assertEquals("take", optionSet1.getKeyVerb());
        assertEquals("get", optionSet2.getKeyVerb());
        assertEquals("become", optionSet3.getKeyVerb());
    }

    @Test
    void testGetItemListName(){
        assertEquals("", optionSet.getItemListName());
        assertEquals("", optionSet1.getItemListName());
        assertEquals("Special Equipment", optionSet2.getItemListName());
        assertEquals("Wizard", optionSet3.getItemListName());
    }
}
