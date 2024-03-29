package testRosterBuilder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import rosterBuilder.entities.ArmySubcategory;
import rosterBuilder.entities.UnitProfile;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testArmySubcategory {
    UnitProfile unitProfile0 = Mockito.mock(UnitProfile.class);
    UnitProfile unitProfile1 = Mockito.mock(UnitProfile.class);
    ArrayList<UnitProfile> unitProfiles = new ArrayList<>(Arrays.asList(unitProfile0, unitProfile1));
    ArmySubcategory armySubcategory = new ArmySubcategory("TROOPS", unitProfiles);

    @Test
    void testGetName(){
        assertEquals("TROOPS", armySubcategory.getName());
    }

    @Test
    void testGetUnitProfile(){
        assertEquals(unitProfile0, armySubcategory.getUnitProfile(0));
        assertEquals(unitProfile1, armySubcategory.getUnitProfile(1));
    }

    @Test
    void testSize(){
        assertEquals(2, armySubcategory.size());
    }

    @Test
    void testGetCategoryPointCap(){
        assertEquals(Integer.MAX_VALUE, armySubcategory.getCategoryPointCap());
    }

    @Test
    void testSetCategoryPointCap(){
        assertEquals(Integer.MAX_VALUE, armySubcategory.getCategoryPointCap());
        armySubcategory.setCategoryPointCap(100);
        assertEquals(100, armySubcategory.getCategoryPointCap());
    }

    @Test
    void testSetCategoryPointCapPercentage(){
        assertEquals(1.0, armySubcategory.getCategoryPointCapPercentage());
        armySubcategory.setCategoryPointCapPercentage(3232.9);
        assertEquals(3232.9, armySubcategory.getCategoryPointCapPercentage());
    }

    //TODO: test recalculateCategoryPointCap() and think if its actually useful
}
