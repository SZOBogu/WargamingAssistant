package testRosterBuilder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import rosterBuilder.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testArmy {
    ArmySubcategory armySubcategory0 = Mockito.mock(ArmySubcategory.class);
    ArmySubcategory armySubcategory1 = Mockito.mock(ArmySubcategory.class);

    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    ArrayList<Integer> allyArray = new ArrayList<>(Collections.singletonList(0));
    ArrayList<ArmySubcategory> armySubcategories = new ArrayList<>(Arrays.asList(armySubcategory0, armySubcategory1));
    ImageIcon img = Mockito.mock(ImageIcon.class);
    Army army = new Army("Cosmosailors", armySubcategories, img);

    @Test
    void testGetName(){
        assertEquals("Cosmosailors", army.getName());
    }

    @Test
    void testGetArmySubcategory(){
        assertEquals(armySubcategory0, army.getArmySubcategory(0));
        assertEquals(armySubcategory1, army.getArmySubcategory(1));
    }

    @Test
    void testSetArmySubcategory(){

    }

    @Test
    void testSize(){
        assertEquals(2, army.size());
    }

    @Test
    void testGetImg(){
        assertEquals(img, army.getImg());
    }

    @Test
    void testGetRelevantSlotCount() {
        UnitProfile up0 = Mockito.mock(UnitProfile.class);
        UnitProfile up1 = Mockito.mock(UnitProfile.class);
        ArmySubcategory armySubcategory0 = new ArmySubcategory("HQ", new ArrayList<>(Arrays.asList(up0, up1)));
        UnitProfile up2 = Mockito.mock(UnitProfile.class);
        UnitProfile up3 = Mockito.mock(UnitProfile.class);
        ArmySubcategory armySubcategory1 = new ArmySubcategory("Troops", new ArrayList<>(Arrays.asList(up2, up3)));
        ArmySubcategory armySubcategory2 = new ArmySubcategory("Shooters", new ArrayList<>());
        Army army0 = new Army("Kingdom of costam", new ArrayList<>(Arrays.asList(armySubcategory0, armySubcategory1, armySubcategory2)));

        assertEquals(2, army0.getRelevantSlotCount());
    }

    @Test
    void testGetAlliableArmyIndexes(){
        assertEquals(new ArrayList<>(), army.getAlliableArmyIndexes());
    }

    @Test
    void testSetAlliableArmyIndexes(){
        army.setAlliableArmyIndexes(new ArrayList<>(Arrays.asList(0)));
        assertEquals(new ArrayList<>(Arrays.asList(0)), army.getAlliableArmyIndexes());
    }
}
