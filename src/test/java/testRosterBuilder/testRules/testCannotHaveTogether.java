package testRosterBuilder.testRules;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rosterBuilder.*;
import rosterBuilder.rules.CannotBeTakenTogether;
import rosterBuilder.rules.CannotHaveTogether;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCannotHaveTogether {
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

    CannotHaveTogether ruleOK = new CannotHaveTogether(new SpecialRule("Any", ""), new SpecialRule("Non Pass", ""));
    CannotHaveTogether ruleNotOK = new CannotHaveTogether(new SpecialRule("Any", ""), new SpecialRule("Wizard Master", ""));

    @BeforeAll
    static void init(){
        RuleViolationLog.clear();
    }

    @Test
    void testCheck(){
        ruleOK.check(unit0);
        assertEquals("", RuleViolationLog.getUnitRuleViolationLog());
        ruleNotOK.check(unit0);
        assertEquals("Unit cannot have Any and Wizard Master together.\n", RuleViolationLog.getUnitRuleViolationLog());
        RuleViolationLog.clear();
    }
}
