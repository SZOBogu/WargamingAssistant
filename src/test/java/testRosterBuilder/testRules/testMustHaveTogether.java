package testRosterBuilder.testRules;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.pojos.*;
import rosterBuilder.rules.MustHaveTogether;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testMustHaveTogether {
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

    MustHaveTogether ruleOK = new MustHaveTogether(new SpecialRule("Any", ""), new SpecialRule("Wizard Master", ""));
    MustHaveTogether ruleNotOK = new MustHaveTogether(new SpecialRule("Any", ""), new SpecialRule("Pass", ""));

    @Test
    void testCheck(){
        ruleOK.check(unit0);
        assertDoesNotThrow(() -> {ruleOK.check(unit0);});
        assertThrows(UnitBuildingException.class, () -> {ruleNotOK.check(unit0);});
    }
}
