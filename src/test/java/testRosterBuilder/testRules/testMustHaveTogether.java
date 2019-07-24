package testRosterBuilder.testRules;

import org.junit.jupiter.api.Test;
import rosterBuilder.*;
import rosterBuilder.rules.CannotBeTakenTogether;
import rosterBuilder.rules.MustHaveTogether;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMustHaveTogether {
    ArrayList<Entity> eq0 = new ArrayList<>(Arrays.asList(new SpecialRule("Wizard Master", ""), new Entity("Talisman", ""), new SpecialRule("Any", "")));
    Unit unit0 = new Unit("Wizard", 1, eq0, new ArrayList<>(),350);
    ArrayList<Entity> eq1 = new ArrayList<>(Arrays.asList(new Weapon("Sword", ""), new Entity("Shield", "")));
    Unit unit1 = new Unit("Swordsmen", 10, eq1, new ArrayList<>(),350);
    ArrayList<Entity> eq2 = new ArrayList<>(Arrays.asList(new Weapon("Sword", ""), new SpecialRule("Commander", ""), new Item("Plate Armour", ""), new SpecialRule("Any", "")));
    Unit unit2 = new Unit("General", 1, eq2, new ArrayList<>(),350);
    ArrayList<Entity> eq3 = new ArrayList<>(Arrays.asList(new SpecialRule("Cannon", ""), new Entity("3 Crew", "")));
    Unit unit3 = new Unit("Cannon", 1, eq3, new ArrayList<>(),350);

    RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();

    MustHaveTogether ruleOK = new MustHaveTogether(new SpecialRule("Any", ""), new SpecialRule("Wizard Master", ""));
    MustHaveTogether ruleNotOK = new MustHaveTogether(new SpecialRule("Any", ""), new SpecialRule("Pass", ""));

    @Test
    void testCheck(){
        ruleOK.check(unit0);
        assertEquals("", ruleViolationLog.getUnitRuleViolationLog());
        ruleNotOK.check(unit0);
        assertEquals("Unit must have Any and Pass together.\n", ruleViolationLog.getUnitRuleViolationLog());
        ruleViolationLog.clear();
    }
}
