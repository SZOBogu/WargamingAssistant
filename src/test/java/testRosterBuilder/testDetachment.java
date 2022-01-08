package testRosterBuilder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import rosterBuilder.pojos.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testDetachment {
    UnitProfile up0 = Mockito.mock(UnitProfile.class);
    UnitProfile up1 = Mockito.mock(UnitProfile.class);
    ArmySubcategory armySubcategory0 = new ArmySubcategory("HQ", new ArrayList<>(Arrays.asList(up0, up1)));
    UnitProfile up2 = Mockito.mock(UnitProfile.class);
    UnitProfile up3 = Mockito.mock(UnitProfile.class);
    ArmySubcategory armySubcategory1 = new ArmySubcategory("Troops", new ArrayList<>(Arrays.asList(up2, up3)));
    Army army = new Army("Kingdom of costam", new ArrayList<>(Arrays.asList(armySubcategory0, armySubcategory1)));

    UniqueEntitiesPool pool = Mockito.mock(UniqueEntitiesPool.class);

    ArrayList<Integer> min = new ArrayList<>(Arrays.asList(1, 2, 0));
    ArrayList<Integer> max = new ArrayList<>(Arrays.asList(3, 6, 2));
    Detachment detachment0 = new Detachment.DetachmentBuilder("Detachment 0")
                    .army(army)
                    .arrayOfMaxChoicesPerCategory(max)
                    .arrayOfMandatoryChoicesInCategories(min)
                    .build();

    Detachment detachment1 = new Detachment.DetachmentBuilder("Detachment 1", 4)
            .army(army)
            .detachmentNumber(1)
            .build();

    Detachment detachment2 = new Detachment.DetachmentBuilder("Detachment 2")
                                    .arrayOfMandatoryChoicesInCategories(min)
                                    .detachmentNumber(2)
                                    .build();
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
        detachment0.setCapacity(0);
        assertEquals(0, detachment0.getBoughtUnitsCategorized().size());
        detachment0.setCapacity(-2);
        assertEquals(0, detachment0.getBoughtUnitsCategorized().size());
    }

    @Test
    void testAddUnit(){
        assertEquals(0, detachment0.getUnitCount());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(1).size());

        Unit testUnit0 = new Unit.UnitBuilder("Test 0", new ArrayList<>())
                .pointCost(30)
                .build();
        Unit testUnit1 = new Unit.UnitBuilder("Test 1", new ArrayList<>())
                .pointCost(50)
                .build();

        detachment0.addUnit(testUnit0, 0, pool);
        assertEquals(1, detachment0.getUnitCount());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(1).size());
        detachment0.addUnit(testUnit1, 1, pool);
        assertEquals(2, detachment0.getUnitCount());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(1).size());
    }

    @Test
    void testGetUnit(){
        Unit testUnit = new Unit.UnitBuilder("Test 1", new ArrayList<>())
                .pointCost(50)
                .build();
        detachment0.addUnit(testUnit, 0, pool);
        assertEquals(testUnit, detachment0.getUnit(0, 0));
    }

    @Test
    void testDeleteUnit(){
        detachment0.setCapacity(2);
        detachment0.setArmy(army);

        Unit testUnit = new Unit.UnitBuilder("Test 1", new ArrayList<>())
                .pointCost(30)
                .build();

        detachment0.addUnit(testUnit, 0, pool);
        assertEquals(1, detachment0.getUnitCount());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(1).size());

        Unit testUnit0 = new Unit.UnitBuilder("Test 0", new ArrayList<>())
                .pointCost(50)
                .build();

        detachment0.addUnit(testUnit0, 1, pool);
        assertEquals(2, detachment0.getUnitCount());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(1).size());

        detachment0.deleteUnit(0, 0, pool);
        assertEquals(1, detachment0.getUnitCount());
        assertEquals(0, detachment0.getBoughtUnitsCategorized().get(0).size());
        assertEquals(1, detachment0.getBoughtUnitsCategorized().get(1).size());
        assertEquals("Test 0", detachment0.getUnit(1, 0).getName());
    }

    @Test
    void testContains(){
        Unit testUnit = new Unit.UnitBuilder("Test 1", new ArrayList<>())
                .pointCost(30)
                .build();
        detachment0.addUnit(testUnit, 0, pool);

        assertTrue(detachment0.contains(testUnit));
    }

    @Test
    void testGetArmy(){
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

        assertEquals(1, copiedDetachment.getDetachmentNumber());

        assertNull(copiedDetachment.getArmy());

    }

    @Test
    void testGetUnitCount(){
        Unit testUnit = new Unit.UnitBuilder("Test 1", new ArrayList<>())
                .pointCost(30)
                .build();
        detachment0.addUnit(testUnit, 0, pool);
        Unit testUnit0 = new Unit.UnitBuilder("Test 0", new ArrayList<>())
                .pointCost(50)
                .build();
        detachment0.addUnit(testUnit0, 1, pool);

        assertEquals(2, detachment0.getUnitCount());
    }

    @Test
    void testToString(){
        detachment0.setArmy(army);
        Unit testUnit0 = new Unit.UnitBuilder("General", new ArrayList<>(Arrays.asList(new SpecialRule("Skirmisher", "-"))))
                        .pointCost(50)
                        .build();
        detachment0.addUnit(testUnit0, 0, pool);
        Unit testUnit1 = new Unit.UnitBuilder("Swordsmen", new ArrayList<>(Arrays.asList(new SpecialRule("Skirmisher", "-"))))
                .modelsInUnit(10)
                .pointCost(50)
                .build();
        detachment0.addUnit(testUnit1, 1, pool);
        String expected = "Detachment No.0: Detachment 0\n" +
                "   HQ\n      " + testUnit0.toString() + "\n" +
                "   Troops\n      " + testUnit1.toString() + "\n";
        assertEquals(expected, detachment0.toString());
    }
}
