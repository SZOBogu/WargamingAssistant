package testRosterBuilder.testRules;

import org.junit.jupiter.api.Test;
import rosterBuilder.entities.Entity;
import rosterBuilder.entities.SpecialRule;
import rosterBuilder.entities.Unit;
import rosterBuilder.entities.Weapon;
import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.rules.CannotHaveTogether;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testCannotHaveTogether {
    ArrayList<Entity> eq0 = new ArrayList<>(Arrays.asList(new SpecialRule("Wizard Master", ""), new Entity("Talisman", ""), new SpecialRule("Any", "")));
    Unit unit0 = new Unit.UnitBuilder("Wizard", eq0)
            .pointCost(350)
            .build();
    ArrayList<Entity> eq1 = new ArrayList<>(Arrays.asList(new Weapon("Sword", ""), new Entity("Shield", "")));

    CannotHaveTogether ruleOK = new CannotHaveTogether(new SpecialRule("Any", ""), new SpecialRule("Non Pass", ""));
    CannotHaveTogether ruleNotOK = new CannotHaveTogether(new SpecialRule("Any", ""), new SpecialRule("Wizard Master", ""));

    @Test
    void testCheck(){
        assertDoesNotThrow(() -> {ruleOK.check(unit0);});
        assertThrows(UnitBuildingException.class, () -> {ruleNotOK.check(unit0);});
    }
}
