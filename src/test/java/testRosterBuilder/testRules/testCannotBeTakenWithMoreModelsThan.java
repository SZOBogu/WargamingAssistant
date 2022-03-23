package testRosterBuilder.testRules;

import org.junit.jupiter.api.Test;
import rosterBuilder.exceptions.UnitBuildingException;
import rosterBuilder.entities.Entity;
import rosterBuilder.entities.SpecialRule;
import rosterBuilder.entities.Unit;
import rosterBuilder.rules.CannotBeTakenWithMoreThanModels;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class testCannotBeTakenWithMoreModelsThan {
    ArrayList<Entity> eq0 = new ArrayList<>(Arrays.asList(new SpecialRule("Wizard Master", ""), new Entity("Talisman", ""), new SpecialRule("Any", "")));
    Unit unit0 = new Unit.UnitBuilder("Wizard", new ArrayList<>())
            .nonBaseEquipment(eq0)
            .pointCost(350)
            .modelsInUnit(2)
            .build();
    CannotBeTakenWithMoreThanModels ruleOK = new CannotBeTakenWithMoreThanModels(new SpecialRule("Any", ""), 100);
    CannotBeTakenWithMoreThanModels ruleNotOK = new CannotBeTakenWithMoreThanModels(new SpecialRule("Any", ""), 1);

    @Test
    void testCheck(){
        assertDoesNotThrow(() -> {ruleOK.check(unit0);});
        assertThrows(UnitBuildingException.class, () -> {ruleNotOK.check(unit0);});
    }
}
