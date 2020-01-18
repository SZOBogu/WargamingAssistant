package testRosterBuilder.testRules;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rosterBuilder.*;
import rosterBuilder.rules.MustBeTakenTogether;
import rosterBuilder.rules.MustHaveExactly;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMustBeTakenTogether {
    ArrayList<Entity> eq0 = new ArrayList<>(Arrays.asList(new SpecialRule("Wizard Master", ""), new Entity("Talisman", ""), new SpecialRule("Any", "")));
    Unit unit0 = new Unit("Wizard", 1, eq0, new ArrayList<>(),350);
    ArrayList<Entity> eq1 = new ArrayList<>(Arrays.asList(new Weapon("Sword", ""), new Entity("Shield", "")));
    Unit unit1 = new Unit("Swordsmen", 10, eq1, new ArrayList<>(),350);
    ArrayList<Entity> eq2 = new ArrayList<>(Arrays.asList(new Weapon("Sword", ""), new SpecialRule("Commander", ""), new Item("Plate Armour", ""), new SpecialRule("Any", "")));
    Unit unit2 = new Unit("General", 1, eq2, new ArrayList<>(),350);
    ArrayList<Entity> eq3 = new ArrayList<>(Arrays.asList(new SpecialRule("Cannon", ""), new Entity("3 Crew", "")));
    Unit unit3 = new Unit("Cannon", 1, eq3, new ArrayList<>(),350);
    MustBeTakenTogether ruleOK = new MustBeTakenTogether(new SpecialRule("Wizard Master", ""), new SpecialRule("Any", ""));
    MustBeTakenTogether ruleNotOK = new MustBeTakenTogether(new SpecialRule("Any", ""), new SpecialRule("Not pass", ""));

    RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();

    @BeforeAll
    static void init(){
        RuleViolationLog.clear();
    }

    @Test
    void testCheck(){
        ruleOK.check(unit0);
        assertEquals("", RuleViolationLog.getUnitRuleViolationLog());
        ruleNotOK.check(unit0);
        assertEquals("Any cannot be taken without Not pass.\n", RuleViolationLog.getUnitRuleViolationLog());
        RuleViolationLog.clear();
    }
}
