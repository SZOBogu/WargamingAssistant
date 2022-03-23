package testRosterBuilder.testRules;

import org.junit.jupiter.api.Test;
import rosterBuilder.entities.*;
import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.rules.CategoryPointCapExceedRule;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class testCategoryPointCapExceedRule {
    UnitProfile up0 = new UnitProfile("Spearmen", new ArrayList<>(), new ArrayList<>(), 100);
    UnitProfile up1 = new UnitProfile("Archer", new ArrayList<>(), new ArrayList<>(), 200);
    ArmySubcategory armySubcategory0 = new ArmySubcategory("HQ", new ArrayList<>(Arrays.asList(up0, up1)));
    UnitProfile up2 = new UnitProfile("Swordsmen", new ArrayList<>(), new ArrayList<>(), 300);
    UnitProfile up3 = new UnitProfile("SLinger", new ArrayList<>(), new ArrayList<>(), 400);
    ArmySubcategory armySubcategory1 = new ArmySubcategory("TROOPS", new ArrayList<>(Arrays.asList(up2, up3)));
    Army army = new Army("Kingdom of costam", new ArrayList<>(Arrays.asList(armySubcategory0, armySubcategory1)));

    Roster roster  = new Roster();

    ArrayList<Integer> min0 = new ArrayList<>(Arrays.asList(1, 2, 0));
    ArrayList<Integer> max0 = new ArrayList<>(Arrays.asList(3, 6, 2));
    Detachment detachment0 = new Detachment.DetachmentBuilder("Detachment 0")
            .army(army)
            .arrayOfMandatoryChoicesInCategories(min0)
            .arrayOfMaxChoicesPerCategory(max0)
            .build();
    ArrayList<Integer> min1 = new ArrayList<>(Arrays.asList(1, 2, 0));
    ArrayList<Integer> max1 = new ArrayList<>(Arrays.asList(3, 6, 2));
    Detachment detachment1 = new Detachment.DetachmentBuilder("Detachment 1")
            .army(army)
            .arrayOfMandatoryChoicesInCategories(min1)
            .arrayOfMaxChoicesPerCategory(max1)
            .detachmentNumber(1)
            .build();

    ArrayList<Entity> eq0 = new ArrayList<>(Arrays.asList(new SpecialRule("Wizard Master", ""), new Entity("Talisman", ""), new SpecialRule("Any", "")));
    Unit unit0 = new Unit.UnitBuilder("Wizard", eq0)
            .pointCost(350)
            .build();
    ArrayList<Entity> eq1 = new ArrayList<>(Arrays.asList(new Weapon("Sword", ""), new Entity("Shield", "")));
    Unit unit1 = new Unit.UnitBuilder("Swordsmen", eq1)
            .modelsInUnit(10)
            .pointCost(350)
            .build();
    ArrayList<Entity> eq2 = new ArrayList<>(Arrays.asList(new Weapon("Sword", ""), new SpecialRule("Commander", ""), new Item("Plate Armour", ""), new SpecialRule("Any", "")));
    Unit unit2 = new Unit.UnitBuilder("General", eq2)
            .pointCost(350)
            .build();
    ArrayList<Entity> eq3 = new ArrayList<>(Arrays.asList(new SpecialRule("Cannon", ""), new Entity("3 Crew", "")));
    Unit unit3 = new Unit.UnitBuilder("Cannon", eq3)
            .pointCost(350)
            .build();

    CategoryPointCapExceedRule ruleOK = new CategoryPointCapExceedRule();

    @Test
    void testCheck(){
        roster.setPrimaryArmy(army);
        roster.addDetachment(detachment0);
        roster.addDetachment(detachment1);
        roster.setPointCap(10000);
        roster.getDetachments().get(0).addUnit(unit0, 0, roster.getUniqueEntitiesPool());
        roster.getDetachments().get(0).addUnit(unit1, 1, roster.getUniqueEntitiesPool());
        roster.getDetachments().get(1).addUnit(unit2, 0, roster.getUniqueEntitiesPool());
        roster.getDetachments().get(1).addUnit(unit3, 1, roster.getUniqueEntitiesPool());
        roster.getDetachments().get(0).setArmy(army);
        roster.getDetachments().get(1).setArmy(army);

        assertNotNull(roster.getArmy(0));
        assertNotNull(roster.getArmy(1));

        assertNotNull(roster.getArmy(0).getArmySubcategory(0));
        assertNotNull(roster.getArmy(0).getArmySubcategory(1));
        assertNotNull(roster.getArmy(1).getArmySubcategory(0));
        assertNotNull(roster.getArmy(1).getArmySubcategory(1));

        ArmySubcategory armySubcategory00 = roster.getArmy(0).getArmySubcategory(0);
        ArmySubcategory armySubcategory01 = roster.getArmy(0).getArmySubcategory(1);
        ArmySubcategory armySubcategory10 = roster.getArmy(1).getArmySubcategory(0);
        ArmySubcategory armySubcategory11 = roster.getArmy(1).getArmySubcategory(1);

        armySubcategory00.setCategoryPointCap(1000);
        armySubcategory01.setCategoryPointCap(1000);
        armySubcategory10.setCategoryPointCap(1000);
        armySubcategory11.setCategoryPointCap(1000);

        assertDoesNotThrow(() -> {ruleOK.check(roster, 0, 0);});
        assertDoesNotThrow(() -> {ruleOK.check(roster, 0, 1);});
        assertDoesNotThrow(() -> {ruleOK.check(roster, 1, 0);});
        assertDoesNotThrow(() -> {ruleOK.check(roster, 1, 1);});

        armySubcategory00.setCategoryPointCap(1);
        armySubcategory01.setCategoryPointCap(1);
        armySubcategory10.setCategoryPointCap(1);
        armySubcategory11.setCategoryPointCap(1);

        assertThrows(RosterBuildingException.class, () -> {ruleOK.check(roster, 0, 0);});
        assertThrows(RosterBuildingException.class, () -> {ruleOK.check(roster, 0, 1);});
        assertThrows(RosterBuildingException.class, () -> {ruleOK.check(roster, 1, 0);});
        assertThrows(RosterBuildingException.class, () -> {ruleOK.check(roster, 1, 1);});
    }
}
