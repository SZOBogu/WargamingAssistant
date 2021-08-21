package testRosterBuilder.testRules;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rosterBuilder.*;
import rosterBuilder.rules.CannotBeMoreUnitsWithThan;
import rosterBuilder.rules.MustHaveAtLeast;
import rosterBuilder.rules.MustHaveExactly;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMustHaveExactly {
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
    Detachment detachment0 = new Detachment.DetachmentBuilder("Detachment 0")
            .arrayOfMandatoryChoicesInCategories(min0)
            .arrayOfMaxChoicesPerCategory(max0)
            .build();

    ArrayList<Integer> min1 = new ArrayList<>(Arrays.asList(1, 2, 0));
    ArrayList<Integer> max1 = new ArrayList<>(Arrays.asList(3, 6, 2));
    Detachment detachment1 = new Detachment.DetachmentBuilder("Detachment 1")
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

    MustHaveExactly ruleOK = new MustHaveExactly(new SpecialRule("Wizard Master", ""), 1);
    MustHaveExactly ruleNotOK = new MustHaveExactly(new SpecialRule("Any", ""), 1);

    @BeforeAll
    static void init(){
        RuleViolationLog.clear();
    }

    @Test
    void testCheck(){
        roster.setPrimaryArmy(army);
        roster.addDetachment(detachment0);
        roster.addDetachment(detachment1);

        roster.getDetachments().get(0).addUnit(unit0, 0);
        roster.getDetachments().get(0).addUnit(unit1, 1);
        roster.getDetachments().get(1).addUnit(unit2, 0);
        roster.getDetachments().get(1).addUnit(unit3, 1);


        ruleOK.check(roster);
        assertEquals("", RuleViolationLog.getRosterRuleViolationLog());
        ruleNotOK.check(roster);
        assertEquals("Roster must contain exactly 1 units with Any.\n", RuleViolationLog.getRosterRuleViolationLog());
        RuleViolationLog.clear();
    }
}
