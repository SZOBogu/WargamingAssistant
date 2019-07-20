package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testDetachment {
    UnitProfile up0 = new UnitProfile("Spearmen", new ArrayList<>(), new ArrayList<>(), 100);
    UnitProfile up1 = new UnitProfile("Archer", new ArrayList<>(), new ArrayList<>(), 200);
    ArmySubcategory armySubcategory0 = new ArmySubcategory("HQ", new ArrayList<UnitProfile>(Arrays.asList(up0, up1)));
    UnitProfile up2 = new UnitProfile("Swordsmen", new ArrayList<>(), new ArrayList<>(), 300);
    UnitProfile up3 = new UnitProfile("SLinger", new ArrayList<>(), new ArrayList<>(), 400);
    ArmySubcategory armySubcategory1 = new ArmySubcategory("Troops", new ArrayList<UnitProfile>(Arrays.asList(up2, up3)));
    Army army = new Army("Kingdom of costam", new ArrayList<>(Arrays.asList(armySubcategory0, armySubcategory1)));

    ArrayList<Integer> min = new ArrayList<>(Arrays.asList(1, 2, 0));
    ArrayList<Integer> max = new ArrayList<>(Arrays.asList(3, 6, 2));
    Detachment detachment0 = new Detachment("Detachment 0", min, max, 0);
    Detachment detachment1 = new Detachment("Detachment 1", 4, 1);
    Detachment detachment2 = new Detachment("Detachment 2", min, 2);
    @Test
    void testGetName(){
        assertEquals("Detachment 0", detachment0.getName());
        assertEquals("Detachment 1", detachment1.getName());
        assertEquals("Detachment 2", detachment2.getName());
    }

    @Test
    void testGetCost(){
        assertEquals(0, detachment0.getCost());
    }

    @Test
    void testGetBoughtUnitsCategorized(){
        assertEquals(3, detachment0.getBoughtUnitsCategorized().size());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(1).size());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(2).size());
    }

    @Test
    void testGetDetachmentNumber(){
        assertEquals(0, detachment0.getDetachmentNumber());
        assertEquals(1, detachment1.getDetachmentNumber());
        assertEquals(2, detachment2.getDetachmentNumber());
    }

    @Test
    void testSetDetachmentNumber(){
        detachment0.setDetachmentNumber(5);
        detachment1.setDetachmentNumber(6);
        detachment2.setDetachmentNumber(7);
        assertEquals(5, detachment0.getDetachmentNumber());
        assertEquals(6, detachment1.getDetachmentNumber());
        assertEquals(7, detachment2.getDetachmentNumber());
    }

    @Test
    void testArrayOfMandatoryChoicesInCategories(){
        assertEquals(1, (int)detachment0.getArrayOfMandatoryChoicesInCategories().get(0));
        assertEquals(2, (int)detachment0.getArrayOfMandatoryChoicesInCategories().get(1));
        assertEquals(0, (int)detachment0.getArrayOfMandatoryChoicesInCategories().get(2));

        assertEquals(0, (int)detachment1.getArrayOfMandatoryChoicesInCategories().get(0));
        assertEquals(0, (int)detachment1.getArrayOfMandatoryChoicesInCategories().get(1));
        assertEquals(0, (int)detachment1.getArrayOfMandatoryChoicesInCategories().get(2));
        assertEquals(0, (int)detachment1.getArrayOfMandatoryChoicesInCategories().get(3));

        assertEquals(1, (int)detachment2.getArrayOfMandatoryChoicesInCategories().get(0));
        assertEquals(2, (int)detachment2.getArrayOfMandatoryChoicesInCategories().get(1));
        assertEquals(0, (int)detachment2.getArrayOfMandatoryChoicesInCategories().get(2));
    }

    @Test
    void testGetArrayOfMaxChoicesPerCategory(){
        assertEquals(3, (int)detachment0.getArrayOfMaxChoicesPerCategory().get(0));
        assertEquals(6, (int)detachment0.getArrayOfMaxChoicesPerCategory().get(1));
        assertEquals(2, (int)detachment0.getArrayOfMaxChoicesPerCategory().get(2));

        assertEquals(100, (int)detachment1.getArrayOfMaxChoicesPerCategory().get(0));
        assertEquals(100, (int)detachment1.getArrayOfMaxChoicesPerCategory().get(1));
        assertEquals(100, (int)detachment1.getArrayOfMaxChoicesPerCategory().get(2));
        assertEquals(100, (int)detachment1.getArrayOfMaxChoicesPerCategory().get(3));

        assertEquals(100, (int)detachment2.getArrayOfMaxChoicesPerCategory().get(0));
        assertEquals(100, (int)detachment2.getArrayOfMaxChoicesPerCategory().get(1));
        assertEquals(100, (int)detachment2.getArrayOfMaxChoicesPerCategory().get(2));
    }

    @Test
    void testSetCapacity(){
        assertEquals(3, detachment0.getBoughtUnitsCategorized().size());
        detachment0.setCapacity(5);
        assertEquals(5, detachment0.getBoughtUnitsCategorized().size());
    }

    @Test
    void testAddUnit(){
        assertEquals(0, detachment0.getUnitCount());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(1).size());
        Unit testUnit0 = new Unit("Test 0", 1, new ArrayList<>(), new ArrayList<>(), 30);
        Unit testUnit1 = new Unit("Test 1", 1, new ArrayList<>(), new ArrayList<>(),50);
        detachment0.addUnit(testUnit0, 0);
        assertEquals(1, detachment0.getUnitCount());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(1).size());
        detachment0.addUnit(testUnit1, 1);
        assertEquals(2, detachment0.getUnitCount());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(1).size());
    }

    @Test
    void testGetUnit(){
        Unit testUnit = new Unit("Test", 1, new ArrayList<>(), new ArrayList<>(), 30);
        detachment0.addUnit(testUnit, 0);
        assertEquals(testUnit, detachment0.getUnit(0, 0));
    }

    @Test
    void testDeleteUnit(){
        detachment0.setCapacity(2);
        detachment0.setArmy(army);

        Unit testUnit = new Unit("Test", 1, new ArrayList<>(), new ArrayList<>(), 30);
        detachment0.addUnit(testUnit, 0);
        assertEquals(1, detachment0.getUnitCount());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(1).size());
        Unit testUnit0 = new Unit("Test 0", 0, new ArrayList<>(), new ArrayList<>(), 50);
        detachment0.addUnit(testUnit0, 1);
        assertEquals(2, detachment0.getUnitCount());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(1).size());

        detachment0.deleteUnit(0, 0);
        assertEquals(1, detachment0.getUnitCount());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(1).size());
        assertEquals("Test 0", detachment0.getUnit(1, 0).getName());
    }

    @Test
    void testContains(){
        Unit testUnit = new Unit("Test", 1, new ArrayList<>(), new ArrayList<>(), 30);
        detachment0.addUnit(testUnit, 0);

        assertTrue(detachment0.contains(testUnit));
    }

    @Test
    void testSetAndGetArmy(){
        assertEquals(3, detachment0.getBoughtUnitsCategorized().size());
        detachment0.setArmy(army);
        assertEquals(3, detachment0.getBoughtUnitsCategorized().size());
        assertEquals(army, detachment0.getArmy());
    }

    @Test
    void testCopyEmptyDetachment(){
        Detachment copiedDetachment = detachment0.copyEmptyDetachment();
        assertEquals(detachment0.getName(), copiedDetachment.getName());
        assertEquals(0, copiedDetachment.getCost());
        assertEquals(3, copiedDetachment.getBoughtUnitsCategorized().size());
        assertEquals(0, copiedDetachment.getBoughtUnitsCategorized().get(0).size());
        assertNotSame(detachment0.getArrayOfMandatoryChoicesInCategories().get(0), copiedDetachment.getArrayOfMandatoryChoicesInCategories().get(0));
        assertNotSame(detachment0.getArrayOfMandatoryChoicesInCategories().get(0), copiedDetachment.getArrayOfMandatoryChoicesInCategories().get(1));
        assertNotSame(detachment0.getArrayOfMandatoryChoicesInCategories().get(0), copiedDetachment.getArrayOfMandatoryChoicesInCategories().get(2));

        assertNotSame(detachment0.getArrayOfMaxChoicesPerCategory().get(0), copiedDetachment.getArrayOfMaxChoicesPerCategory().get(0));
        assertNotSame(detachment0.getArrayOfMaxChoicesPerCategory().get(0), copiedDetachment.getArrayOfMaxChoicesPerCategory().get(1));
        assertNotSame(detachment0.getArrayOfMaxChoicesPerCategory().get(0), copiedDetachment.getArrayOfMaxChoicesPerCategory().get(2));

        assertEquals(1, copiedDetachment.getDetachmentNumber());

        assertNull(copiedDetachment.getArmy());

    }

    @Test
    void testGetUnitCount(){
        Unit testUnit = new Unit("Test", 1, new ArrayList<>(), new ArrayList<>(), 30);
        detachment0.addUnit(testUnit, 0);
        Unit testUnit0 = new Unit("Test 0", 10, new ArrayList<>(), new ArrayList<>(), 50);
        detachment0.addUnit(testUnit0, 1);

        assertEquals(2, detachment0.getUnitCount());
    }

    @Test
    void testToString(){
        detachment0.setArmy(army);
        Unit testUnit0 = new Unit("General", 1, new ArrayList<Entity>(Arrays.asList(new SpecialRule("Skirmisher", "-"))), new ArrayList<>(), 50);
        detachment0.addUnit(testUnit0, 0);
        Unit testUnit1 = new Unit("Swordsmen", 10, new ArrayList<Entity>(Arrays.asList(new Weapon("Sword", "-"))), new ArrayList<>(), 30);
        detachment0.addUnit(testUnit1, 1);
        String expected = "Detachment No.0: Detachment 0\n" +
                "   HQ\n      " + testUnit0.toString() + "\n" +
                "   Troops\n      " + testUnit1.toString() + "\n";
        assertEquals(expected, detachment0.toString());
    }
}
