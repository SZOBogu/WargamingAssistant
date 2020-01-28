package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.*;
import rosterBuilder.UnitAndProfileFinder;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testUnitAndProfileFinder {
    Unit unit0 = new Unit("Unit0", 20, new ArrayList<>(), new ArrayList<>(), 1000);
    Unit unit1 = new Unit("Unit1", 20, new ArrayList<>(), new ArrayList<>(), 1000);
    Unit unit2 = new Unit("Unit2", 20, new ArrayList<>(), new ArrayList<>(), 1000);
    Unit unit3 = new Unit("Unit3", 20, new ArrayList<>(), new ArrayList<>(), 1000);

    UnitProfile profile0 =  new UnitProfile("Unit0", new ArrayList<>(), new ArrayList<>(), 100);
    UnitProfile profile1 =  new UnitProfile("Unit1", new ArrayList<>(), new ArrayList<>(), 100);
    UnitProfile profile2 =  new UnitProfile("Unit2", new ArrayList<>(), new ArrayList<>(), 100);
    UnitProfile profile3 =  new UnitProfile("Unit3", new ArrayList<>(), new ArrayList<>(), 100);

    UnitAndProfileFinder unitAndProfileFinder = new UnitAndProfileFinder();

    ArrayList<UnitProfile> unitProfiles0 = new ArrayList<>(Arrays.asList(profile0, profile1));
    ArrayList<UnitProfile> unitProfiles1 = new ArrayList<>(Arrays.asList(profile2, profile3));

    ArmySubcategory armySubcategory0 = new ArmySubcategory("CAT0", unitProfiles0);
    ArmySubcategory armySubcategory1 = new ArmySubcategory("CAT1", unitProfiles1);
    ArrayList<ArmySubcategory> armySubcategories = new ArrayList<>(Arrays.asList(armySubcategory0, armySubcategory1));

    ImageIcon img = new ImageIcon();
    Army army = new Army("Army", armySubcategories, img);

    Detachment detachment0 = new Detachment("Detachment 0", 2, 0);
    Detachment detachment1 = new Detachment("Detachment 1", 2, 1);

    Roster roster = new Roster();

    @Test
    void testGetProfileArmyName(){
        assertEquals(profile0, unitAndProfileFinder.getProfile(army, "Unit0"));
        assertEquals(profile1, unitAndProfileFinder.getProfile(army, "Unit1"));
        assertEquals(profile2, unitAndProfileFinder.getProfile(army, "Unit2"));
        assertEquals(profile3, unitAndProfileFinder.getProfile(army, "Unit3"));
        assertEquals(new UnitProfile(), unitAndProfileFinder.getProfile(army, "Unit10"));
    }

    @Test
    void testGetProfileArmysubcategoryName(){
        assertEquals(profile0, unitAndProfileFinder.getProfile(armySubcategory0, "Unit0"));
        assertEquals(profile1, unitAndProfileFinder.getProfile(armySubcategory0, "Unit1"));
        assertEquals(new UnitProfile(), unitAndProfileFinder.getProfile(armySubcategory0, "Unit10"));
        assertEquals(profile2, unitAndProfileFinder.getProfile(armySubcategory1, "Unit2"));
        assertEquals(profile3, unitAndProfileFinder.getProfile(armySubcategory1, "Unit3"));
        assertEquals(new UnitProfile(), unitAndProfileFinder.getProfile(armySubcategory1, "Unit30"));
    }

    @Test
    void testGetProfileArmyUnit() {
        assertEquals(profile0, unitAndProfileFinder.getProfile(army, unit0));
        assertEquals(profile1, unitAndProfileFinder.getProfile(army, unit1));
        assertEquals(profile2, unitAndProfileFinder.getProfile(army, unit2));
        assertEquals(profile3, unitAndProfileFinder.getProfile(army, unit3));

        Unit unit4 = new Unit("Unit4", 20, new ArrayList<>(), new ArrayList<>(), 1000);

        assertEquals(new UnitProfile(), unitAndProfileFinder.getProfile(army, unit4));
    }

    @Test
    void testGetProfileArmysubcategoryUnit(){
        assertEquals(profile0, unitAndProfileFinder.getProfile(armySubcategory0, unit0));
        assertEquals(profile1, unitAndProfileFinder.getProfile(armySubcategory0, unit1));
        assertEquals(new UnitProfile(), unitAndProfileFinder.getProfile(armySubcategory0, unit2));
        assertEquals(profile2, unitAndProfileFinder.getProfile(armySubcategory1, unit2));
        assertEquals(profile3, unitAndProfileFinder.getProfile(armySubcategory1, unit3));
        assertEquals(new UnitProfile(), unitAndProfileFinder.getProfile(armySubcategory1, unit0));
    }

    @Test
    void testGetUnitRosterName(){
        roster.setPrimaryArmy(army);
        roster.addDetachment(detachment0);
        roster.addDetachment(detachment1);
        detachment0.addUnit(unit0, 0);
        detachment1.addUnit(unit1, 1);
        detachment0.addUnit(unit2, 0);
        detachment1.addUnit(unit3, 1);

        assertEquals(unit0, unitAndProfileFinder.getUnit(roster, "Unit0"));
        assertEquals(unit1, unitAndProfileFinder.getUnit(roster, "Unit1"));
        assertEquals(unit2, unitAndProfileFinder.getUnit(roster, "Unit2"));
        assertEquals(unit3, unitAndProfileFinder.getUnit(roster, "Unit3"));
        assertEquals(new Unit(), unitAndProfileFinder.getUnit(roster, "Unit10"));
    }

    @Test
    void testGetUnitDetachmentName(){
        detachment0.addUnit(unit0, 0);
        detachment0.addUnit(unit1, 0);
        detachment0.addUnit(unit2, 1);
        detachment0.addUnit(unit3, 1);

        assertEquals(unit0, unitAndProfileFinder.getUnit(detachment0, "Unit0"));
        assertEquals(unit1, unitAndProfileFinder.getUnit(detachment0, "Unit1"));
        assertEquals(unit2, unitAndProfileFinder.getUnit(detachment0, "Unit2"));
        assertEquals(unit3, unitAndProfileFinder.getUnit(detachment0, "Unit3"));
        assertEquals(new Unit(), unitAndProfileFinder.getUnit(detachment0, "Unit10"));
    }

    @Test
    void testGetUnitArraylistName(){
        ArrayList<Unit> unitArrayList = new ArrayList<>();

        unitArrayList.add(unit0);
        unitArrayList.add(unit1);
        unitArrayList.add(unit2);
        unitArrayList.add(unit3);

        assertEquals(unit0, unitAndProfileFinder.getUnit(unitArrayList, "Unit0"));
        assertEquals(unit1, unitAndProfileFinder.getUnit(unitArrayList, "Unit1"));
        assertEquals(unit2, unitAndProfileFinder.getUnit(unitArrayList, "Unit2"));
        assertEquals(unit3, unitAndProfileFinder.getUnit(unitArrayList, "Unit3"));
        assertEquals(new Unit(), unitAndProfileFinder.getUnit(unitArrayList, "Unit5"));
    }

    @Test
    void testGetUnitRosterUnitProfile(){
        roster.setPrimaryArmy(army);
        roster.addDetachment(detachment0);
        roster.addDetachment(detachment1);
        detachment0.addUnit(unit0, 0);
        detachment1.addUnit(unit1, 1);
        detachment0.addUnit(unit2, 0);
        detachment1.addUnit(unit3, 1);

        UnitProfile profile4 =  new UnitProfile("Unit4", new ArrayList<>(), new ArrayList<>(), 100);

        assertEquals(unit0, unitAndProfileFinder.getUnit(roster, profile0));
        assertEquals(unit1, unitAndProfileFinder.getUnit(roster, profile1));
        assertEquals(unit2, unitAndProfileFinder.getUnit(roster, profile2));
        assertEquals(unit3, unitAndProfileFinder.getUnit(roster, profile3));
        assertEquals(new Unit(), unitAndProfileFinder.getUnit(roster, profile4));
    }

    @Test
    void testGetUnitDetachmentUnitProfile(){
        detachment0.addUnit(unit0, 0);
        detachment0.addUnit(unit1, 0);
        detachment0.addUnit(unit2, 1);
        detachment0.addUnit(unit3, 1);
        UnitProfile profile4 =  new UnitProfile("Unit4", new ArrayList<>(), new ArrayList<>(), 100);

        assertEquals(unit0, unitAndProfileFinder.getUnit(detachment0, profile0));
        assertEquals(unit1, unitAndProfileFinder.getUnit(detachment0, profile1));
        assertEquals(unit2, unitAndProfileFinder.getUnit(detachment0, profile2));
        assertEquals(unit3, unitAndProfileFinder.getUnit(detachment0, profile3));
        assertEquals(new Unit(), unitAndProfileFinder.getUnit(detachment0, profile4));
    }

    @Test
    void testGetUnitArrayListUnitProfile(){
        ArrayList<Unit> unitArrayList = new ArrayList<>();

        unitArrayList.add(unit0);
        unitArrayList.add(unit1);
        unitArrayList.add(unit2);
        unitArrayList.add(unit3);
        UnitProfile profile4 =  new UnitProfile("Unit4", new ArrayList<>(), new ArrayList<>(), 100);

        assertEquals(unit0, unitAndProfileFinder.getUnit(unitArrayList, profile0));
        assertEquals(unit1, unitAndProfileFinder.getUnit(unitArrayList, profile1));
        assertEquals(unit2, unitAndProfileFinder.getUnit(unitArrayList, profile2));
        assertEquals(unit3, unitAndProfileFinder.getUnit(unitArrayList, profile3));
        assertEquals(new Unit(), unitAndProfileFinder.getUnit(unitArrayList, profile4));
    }
}
