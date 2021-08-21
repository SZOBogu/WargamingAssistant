package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.utility.UnitAndProfileFinder;
import rosterBuilder.pojos.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testUnitAndProfileFinder {
    Unit unit0 = new Unit.UnitBuilder("Unit0", new ArrayList<>())
            .modelsInUnit(20)
            .nonBaseEquipment(new ArrayList<>())
            .pointCost(1000)
            .build();
    Unit unit1 = new Unit.UnitBuilder("Unit1", new ArrayList<>())
            .modelsInUnit(20)
            .nonBaseEquipment(new ArrayList<>())
            .pointCost(1000)
            .build();
    Unit unit2 = new Unit.UnitBuilder("Unit2", new ArrayList<>())
            .modelsInUnit(20)
            .nonBaseEquipment(new ArrayList<>())
            .pointCost(1000)
            .build();
    Unit unit3 = new Unit.UnitBuilder("Unit3", new ArrayList<>())
            .modelsInUnit(20)
            .nonBaseEquipment(new ArrayList<>())
            .pointCost(1000)
            .build();

    UnitProfile profile0 =  new UnitProfile("Unit0", new ArrayList<>(), new ArrayList<>(), 100);
    UnitProfile profile1 =  new UnitProfile("Unit1", new ArrayList<>(), new ArrayList<>(), 100);
    UnitProfile profile2 =  new UnitProfile("Unit2", new ArrayList<>(), new ArrayList<>(), 100);
    UnitProfile profile3 =  new UnitProfile("Unit3", new ArrayList<>(), new ArrayList<>(), 100);

    ArrayList<UnitProfile> unitProfiles0 = new ArrayList<>(Arrays.asList(profile0, profile1));
    ArrayList<UnitProfile> unitProfiles1 = new ArrayList<>(Arrays.asList(profile2, profile3));

    ArmySubcategory armySubcategory0 = new ArmySubcategory("CAT0", unitProfiles0);
    ArmySubcategory armySubcategory1 = new ArmySubcategory("CAT1", unitProfiles1);
    ArrayList<ArmySubcategory> armySubcategories = new ArrayList<>(Arrays.asList(armySubcategory0, armySubcategory1));

    ImageIcon img = new ImageIcon();
    Army army = new Army("Army", armySubcategories, img);

    Detachment detachment0 = new Detachment.DetachmentBuilder("Detachment 0", 2).build();
    Detachment detachment1 = new Detachment.DetachmentBuilder("Detachment 1", 2).detachmentNumber(1).build();

    Roster roster = new Roster();

    @Test
    void testGetProfileArmyName(){
        assertEquals(profile0, UnitAndProfileFinder.getProfile(army, "Unit0"));
        assertEquals(profile1, UnitAndProfileFinder.getProfile(army, "Unit1"));
        assertEquals(profile2, UnitAndProfileFinder.getProfile(army, "Unit2"));
        assertEquals(profile3, UnitAndProfileFinder.getProfile(army, "Unit3"));
        assertEquals(new UnitProfile(), UnitAndProfileFinder.getProfile(army, "Unit10"));
    }

    @Test
    void testGetProfileArmysubcategoryName(){
        assertEquals(profile0, UnitAndProfileFinder.getProfile(armySubcategory0, "Unit0"));
        assertEquals(profile1, UnitAndProfileFinder.getProfile(armySubcategory0, "Unit1"));
        assertEquals(new UnitProfile(), UnitAndProfileFinder.getProfile(armySubcategory0, "Unit10"));
        assertEquals(profile2, UnitAndProfileFinder.getProfile(armySubcategory1, "Unit2"));
        assertEquals(profile3, UnitAndProfileFinder.getProfile(armySubcategory1, "Unit3"));
        assertEquals(new UnitProfile(), UnitAndProfileFinder.getProfile(armySubcategory1, "Unit30"));
    }

    @Test
    void testGetProfileArmyUnit() {
        assertEquals(profile0, UnitAndProfileFinder.getProfile(army, unit0));
        assertEquals(profile1, UnitAndProfileFinder.getProfile(army, unit1));
        assertEquals(profile2, UnitAndProfileFinder.getProfile(army, unit2));
        assertEquals(profile3, UnitAndProfileFinder.getProfile(army, unit3));

        Unit unit4 = new Unit.UnitBuilder("Unit4", new ArrayList<>())
                .modelsInUnit(20)
                .nonBaseEquipment(new ArrayList<>())
                .pointCost(1000)
                .build();

        assertEquals(new UnitProfile(), UnitAndProfileFinder.getProfile(army, unit4));
    }

    @Test
    void testGetProfileArmysubcategoryUnit(){
        assertEquals(profile0, UnitAndProfileFinder.getProfile(armySubcategory0, unit0));
        assertEquals(profile1, UnitAndProfileFinder.getProfile(armySubcategory0, unit1));
        assertEquals(new UnitProfile(), UnitAndProfileFinder.getProfile(armySubcategory0, unit2));
        assertEquals(profile2, UnitAndProfileFinder.getProfile(armySubcategory1, unit2));
        assertEquals(profile3, UnitAndProfileFinder.getProfile(armySubcategory1, unit3));
        assertEquals(new UnitProfile(), UnitAndProfileFinder.getProfile(armySubcategory1, unit0));
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

        assertEquals(unit0, UnitAndProfileFinder.getUnit(roster, "Unit0"));
        assertEquals(unit1, UnitAndProfileFinder.getUnit(roster, "Unit1"));
        assertEquals(unit2, UnitAndProfileFinder.getUnit(roster, "Unit2"));
        assertEquals(unit3, UnitAndProfileFinder.getUnit(roster, "Unit3"));
        assertEquals(new Unit(), UnitAndProfileFinder.getUnit(roster, "Unit10"));
    }

    @Test
    void testGetUnitDetachmentName(){
        detachment0.addUnit(unit0, 0);
        detachment0.addUnit(unit1, 0);
        detachment0.addUnit(unit2, 1);
        detachment0.addUnit(unit3, 1);

        assertEquals(unit0, UnitAndProfileFinder.getUnit(detachment0, "Unit0"));
        assertEquals(unit1, UnitAndProfileFinder.getUnit(detachment0, "Unit1"));
        assertEquals(unit2, UnitAndProfileFinder.getUnit(detachment0, "Unit2"));
        assertEquals(unit3, UnitAndProfileFinder.getUnit(detachment0, "Unit3"));
        assertEquals(new Unit(), UnitAndProfileFinder.getUnit(detachment0, "Unit10"));
    }

    @Test
    void testGetUnitArraylistName(){
        ArrayList<Unit> unitArrayList = new ArrayList<>();

        unitArrayList.add(unit0);
        unitArrayList.add(unit1);
        unitArrayList.add(unit2);
        unitArrayList.add(unit3);

        assertEquals(unit0, UnitAndProfileFinder.getUnit(unitArrayList, "Unit0"));
        assertEquals(unit1, UnitAndProfileFinder.getUnit(unitArrayList, "Unit1"));
        assertEquals(unit2, UnitAndProfileFinder.getUnit(unitArrayList, "Unit2"));
        assertEquals(unit3, UnitAndProfileFinder.getUnit(unitArrayList, "Unit3"));
        assertEquals(new Unit(), UnitAndProfileFinder.getUnit(unitArrayList, "Unit5"));
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

        assertEquals(unit0, UnitAndProfileFinder.getUnit(roster, profile0));
        assertEquals(unit1, UnitAndProfileFinder.getUnit(roster, profile1));
        assertEquals(unit2, UnitAndProfileFinder.getUnit(roster, profile2));
        assertEquals(unit3, UnitAndProfileFinder.getUnit(roster, profile3));
        assertEquals(new Unit(), UnitAndProfileFinder.getUnit(roster, profile4));
    }

    @Test
    void testGetUnitDetachmentUnitProfile(){
        detachment0.addUnit(unit0, 0);
        detachment0.addUnit(unit1, 0);
        detachment0.addUnit(unit2, 1);
        detachment0.addUnit(unit3, 1);
        UnitProfile profile4 =  new UnitProfile("Unit4", new ArrayList<>(), new ArrayList<>(), 100);

        assertEquals(unit0, UnitAndProfileFinder.getUnit(detachment0, profile0));
        assertEquals(unit1, UnitAndProfileFinder.getUnit(detachment0, profile1));
        assertEquals(unit2, UnitAndProfileFinder.getUnit(detachment0, profile2));
        assertEquals(unit3, UnitAndProfileFinder.getUnit(detachment0, profile3));
        assertEquals(new Unit(), UnitAndProfileFinder.getUnit(detachment0, profile4));
    }

    @Test
    void testGetUnitArrayListUnitProfile(){
        ArrayList<Unit> unitArrayList = new ArrayList<>();

        unitArrayList.add(unit0);
        unitArrayList.add(unit1);
        unitArrayList.add(unit2);
        unitArrayList.add(unit3);
        UnitProfile profile4 =  new UnitProfile("Unit4", new ArrayList<>(), new ArrayList<>(), 100);

        assertEquals(unit0, UnitAndProfileFinder.getUnit(unitArrayList, profile0));
        assertEquals(unit1, UnitAndProfileFinder.getUnit(unitArrayList, profile1));
        assertEquals(unit2, UnitAndProfileFinder.getUnit(unitArrayList, profile2));
        assertEquals(unit3, UnitAndProfileFinder.getUnit(unitArrayList, profile3));
        assertEquals(new Unit(), UnitAndProfileFinder.getUnit(unitArrayList, profile4));
    }
}
