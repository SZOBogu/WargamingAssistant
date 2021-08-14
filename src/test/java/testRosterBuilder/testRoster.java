package testRosterBuilder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import rosterBuilder.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class testRoster {
    UnitProfile up0 = Mockito.mock(UnitProfile.class);
    UnitProfile up1 = Mockito.mock(UnitProfile.class);

    UnitProfile up2 = Mockito.mock(UnitProfile.class);
    UnitProfile up3 = Mockito.mock(UnitProfile.class);

    ArmySubcategory armySubcategory0 = new ArmySubcategory("HQ", new ArrayList<>(Arrays.asList(up0, up1)));
    ArmySubcategory armySubcategory1 = new ArmySubcategory("TROOPS", new ArrayList<>(Arrays.asList(up2, up3)));
    Army army = new Army("Kingdom of costam", new ArrayList<>(Arrays.asList(armySubcategory0, armySubcategory1)));
    Army army1 = new Army("Republic of costam", new ArrayList<>(Arrays.asList(armySubcategory0, armySubcategory1)));

    Roster roster  = new Roster();

    ArrayList<Integer> min0 = new ArrayList<>(Arrays.asList(1, 2, 0));
    ArrayList<Integer> max0 = new ArrayList<>(Arrays.asList(3, 6, 2));
    Detachment detachment0 = new Detachment("Detachment 0", min0, max0, 0);
    ArrayList<Integer> min1 = new ArrayList<>(Arrays.asList(1, 2, 0));
    ArrayList<Integer> max1 = new ArrayList<>(Arrays.asList(3, 6, 2));
    Detachment detachment1 = new Detachment("Detachment 1", min1, max1, 1);

    @Test
    void testGetDetachments(){
        assertEquals(new ArrayList<>(), roster.getDetachments());
    }

    @Test
    void testSize(){
        assertEquals(0, roster.size());
        roster.addDetachment(detachment0);
        roster.addDetachment(detachment1);
        assertEquals(2, roster.size());
        roster.removeDetachment(0);
        assertEquals(1, roster.size());
    }

    @Test
    void testAddDetachment(){
        roster.addDetachment(detachment0);
        roster.addDetachment(detachment1);

        assertEquals(detachment0, roster.getDetachments().get(0));
        assertEquals(detachment1, roster.getDetachments().get(1));
    }

    @Test
    void testRemoveDetachment(){
        roster.addDetachment(detachment0);
        roster.addDetachment(detachment1);
        assertEquals(detachment0, roster.getDetachments().get(0));
        roster.removeDetachment(0);
        assertEquals(detachment1, roster.getDetachments().get(0));
    }

    @Test
    void testGetPointCap(){
        assertEquals(0, roster.getPointCap());
    }

    @Test
    void testSetPointCap(){
        assertEquals(0, roster.getPointCap());
        roster.setPointCap(4500);
        assertEquals(4500, roster.getPointCap());
    }

    @Test
    void testGetPrimaryArmy(){
        assertNull(roster.getPrimaryArmy());
    }

    @Test
    void testSetPrimaryArmy(){
        roster.setPrimaryArmy(army);
        assertEquals(army, roster.getPrimaryArmy());
    }

    @Test
    void testToString(){
        roster.setPointCap(4500);
        roster.setPrimaryArmy(army);
        roster.addDetachment(detachment0);
        detachment0.setArmy(army);
        roster.addDetachment(detachment1);
        detachment1.setArmy(army);

        Unit unit0 = Mockito.mock(Unit.class);
        Unit unit1 = Mockito.mock(Unit.class);
        Unit unit2 = Mockito.mock(Unit.class);
        Unit unit3 = Mockito.mock(Unit.class);

        roster.getDetachments().get(0).addUnit(unit0, 0);
        roster.getDetachments().get(0).addUnit(unit1, 1);
        roster.getDetachments().get(1).addUnit(unit2, 0);
        roster.getDetachments().get(1).addUnit(unit3, 1);

        String expected = roster.getPrimaryArmy().getName() + " " + roster.getPointCap() +
                "p Army\n" + roster.getDetachments().get(0).toString() + roster.getDetachments().get(1).toString();
        assertEquals(expected, roster.toString());
    }

    @Test
    void testGetTotalCost(){
        roster.addDetachment(detachment0);
        detachment0.setArmy(army);
        Unit testUnit0 = new Unit("General", 1, new ArrayList<>(), new ArrayList<>(), 50);
        detachment0.addUnit(testUnit0, 0);
        Unit testUnit1 = new Unit("Swordsmen", 10, new ArrayList<>(), new ArrayList<>(), 30);
        detachment0.addUnit(testUnit1, 1);

        assertEquals(80, roster.getTotalCost());
    }

    @Test
    void testGetArmy(){
        roster.setPointCap(4500);
        roster.setPrimaryArmy(army);
        roster.addDetachment(detachment0);
        detachment0.setArmy(army);
        roster.addDetachment(detachment1);
        detachment1.setArmy(army1);

        assertEquals(army, roster.getArmy(0));
        assertEquals(army1, roster.getArmy(1));
    }
}
