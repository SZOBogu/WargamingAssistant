package testRosterBuilder.testRules;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rosterBuilder.*;
import rosterBuilder.rules.CannotBeMoreUnitsWithThan;
import rosterBuilder.rules.CategoryPointCapExceedRule;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class testCategoryPointCapExceedRule {
    UnitProfile up0 = new UnitProfile("Spearmen", new ArrayList<>(), new ArrayList<>(), 100);
    UnitProfile up1 = new UnitProfile("Archer", new ArrayList<>(), new ArrayList<>(), 200);
    ArmySubcategory armySubcategory0 = new ArmySubcategory("HQ", new ArrayList<UnitProfile>(Arrays.asList(up0, up1)));
    UnitProfile up2 = new UnitProfile("Swordsmen", new ArrayList<>(), new ArrayList<>(), 300);
    UnitProfile up3 = new UnitProfile("SLinger", new ArrayList<>(), new ArrayList<>(), 400);
    ArmySubcategory armySubcategory1 = new ArmySubcategory("TROOPS", new ArrayList<UnitProfile>(Arrays.asList(up2, up3)));
    Army army = new Army("Kingdom of costam", new ArrayList<>(Arrays.asList(armySubcategory0, armySubcategory1)));

    Roster roster  = new Roster();

    ArrayList<Integer> min0 = new ArrayList<>(Arrays.asList(1, 2, 0));
    ArrayList<Integer> max0 = new ArrayList<>(Arrays.asList(3, 6, 2));
    Detachment detachment0 = new Detachment("Detachment 0", min0, max0, 0);
    ArrayList<Integer> min1 = new ArrayList<>(Arrays.asList(1, 2, 0));
    ArrayList<Integer> max1 = new ArrayList<>(Arrays.asList(3, 6, 2));
    Detachment detachment1 = new Detachment("Detachment 1", min1, max1, 1);

    ArrayList<Entity> eq0 = new ArrayList<>(Arrays.asList(new SpecialRule("Wizard Master", ""), new Entity("Talisman", ""), new SpecialRule("Any", "")));
    Unit unit0 = new Unit("Wizard", 1, eq0, new ArrayList<>(),350);
    ArrayList<Entity> eq1 = new ArrayList<>(Arrays.asList(new Weapon("Sword", ""), new Entity("Shield", "")));
    Unit unit1 = new Unit("Swordsmen", 10, eq1, new ArrayList<>(),350);
    ArrayList<Entity> eq2 = new ArrayList<>(Arrays.asList(new Weapon("Sword", ""), new SpecialRule("Commander", ""), new Item("Plate Armour", ""), new SpecialRule("Any", "")));
    Unit unit2 = new Unit("General", 1, eq2, new ArrayList<>(),350);
    ArrayList<Entity> eq3 = new ArrayList<>(Arrays.asList(new SpecialRule("Cannon", ""), new Entity("3 Crew", "")));
    Unit unit3 = new Unit("Cannon", 1, eq3, new ArrayList<>(),350);

    CategoryPointCapExceedRule ruleOK = new CategoryPointCapExceedRule();

    @BeforeAll
    static void init(){
        RuleViolationLog.clear();
    }

    @Test
    void testCheck(){
        roster.setPrimaryArmy(army);
        roster.addDetachment(detachment0);
        roster.addDetachment(detachment1);
        roster.setPointCap(10000);
        roster.getDetachments().get(0).addUnit(unit0, 0);
        roster.getDetachments().get(0).addUnit(unit1, 1);
        roster.getDetachments().get(1).addUnit(unit2, 0);
        roster.getDetachments().get(1).addUnit(unit3, 1);
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

        ruleOK.check(roster, 0, 0);
        ruleOK.check(roster, 0, 1);
        ruleOK.check(roster, 1, 0);
        ruleOK.check(roster, 1, 1);
        assertEquals("", RuleViolationLog.getRosterRuleViolationLog());
        armySubcategory00.setCategoryPointCap(1);
        armySubcategory01.setCategoryPointCap(1);
        armySubcategory10.setCategoryPointCap(1);
        armySubcategory11.setCategoryPointCap(1);

        ruleOK.check(roster, 0, 0);
        ruleOK.check(roster, 0, 1);
        ruleOK.check(roster, 1, 0);
        ruleOK.check(roster, 1, 1);
        assertEquals("HQ Category Point Limit Exceeded.\n" +
                "TROOPS Category Point Limit Exceeded.\n" +
                "HQ Category Point Limit Exceeded.\n" +
                "TROOPS Category Point Limit Exceeded.\n", RuleViolationLog.getRosterRuleViolationLog());

        RuleViolationLog.clear();
    }
}
