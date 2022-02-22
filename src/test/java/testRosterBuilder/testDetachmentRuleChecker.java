package testRosterBuilder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import rosterBuilder.exceptions.RosterBuildingException;
import rosterBuilder.pojos.Detachment;
import rosterBuilder.pojos.UniqueEntitiesPool;
import rosterBuilder.pojos.Unit;
import rosterBuilder.utility.DetachmentRuleChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testDetachmentRuleChecker {
    List<List<Unit>> units = new ArrayList<>();
    List<Integer> min = new ArrayList<>(Arrays.asList(1, 0));
    List<Integer> max = new ArrayList<>(Arrays.asList(1, 1));

    Unit unit1 = Mockito.mock(Unit.class);

    UniqueEntitiesPool pool = Mockito.mock(UniqueEntitiesPool.class);
    Detachment detachment = new Detachment.DetachmentBuilder("").arrayOfMandatoryChoicesInCategories(min).arrayOfMaxChoicesPerCategory(max).build();

    @BeforeEach
    void setup(){
        units.add(new ArrayList<>());
        units.add(new ArrayList<>());
    }

    @Test
    void testCorrect(){
        units.get(0).add(unit1);
        detachment.setBoughtUnitsCategorized(units);
        //RosterBuildingException ex = assertThrows(RosterBuildingException.class, () -> DetachmentRuleChecker.checkDetachment(detachment));
        assertDoesNotThrow(() -> DetachmentRuleChecker.checkDetachment(detachment));
    }

    @Test
    void testTooFew(){
        RosterBuildingException ex = assertThrows(RosterBuildingException.class, () -> DetachmentRuleChecker.checkDetachment(detachment));
        assertEquals("Too few units in detachment 0", ex.getMessage());
    }

    @Test
    void testTooMany(){
        units.get(0).add(unit1);
        units.get(0).add(unit1);

        units.get(0).add(unit1);
        units.get(0).add(unit1);
        detachment.setBoughtUnitsCategorized(units);
        RosterBuildingException ex = assertThrows(RosterBuildingException.class, () -> DetachmentRuleChecker.checkDetachment(detachment));
        assertEquals("Too many units in detachment 0", ex.getMessage());
    }
}
