package testRosterBuilder.testRules;

import org.junit.jupiter.api.Test;
import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.entities.Entity;
import rosterBuilder.entities.SpecialRule;
import rosterBuilder.entities.Unit;
import rosterBuilder.rules.CannotBeTakenTogether;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testCannotBeTakenTogether {
    ArrayList<Entity> eq0 = new ArrayList<>(Arrays.asList(new SpecialRule("Wizard Master", ""), new Entity("Talisman", ""), new SpecialRule("Any", "")));
    Unit unit0 = new Unit.UnitBuilder("Wizard", new ArrayList<>())
            .nonBaseEquipment(eq0)
            .pointCost(350)
            .build();

    CannotBeTakenTogether ruleOK = new CannotBeTakenTogether(new SpecialRule("Any", ""), new SpecialRule("Pass", ""));
    CannotBeTakenTogether ruleNotOK = new CannotBeTakenTogether(new SpecialRule("Any", ""), new SpecialRule("Wizard Master", ""));

    @Test
    void testCheck(){
        assertDoesNotThrow(() -> {ruleOK.check(unit0);});
        assertThrows(UnitBuildingException.class, () -> {ruleNotOK.check(unit0);});
    }

}
