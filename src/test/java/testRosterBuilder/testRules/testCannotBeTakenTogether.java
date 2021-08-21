package testRosterBuilder.testRules;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rosterBuilder.pojos.Entity;
import rosterBuilder.pojos.SpecialRule;
import rosterBuilder.pojos.Unit;
import rosterBuilder.rules.CannotBeTakenTogether;
import rosterBuilder.utility.RuleViolationLog;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCannotBeTakenTogether {
    ArrayList<Entity> eq0 = new ArrayList<>(Arrays.asList(new SpecialRule("Wizard Master", ""), new Entity("Talisman", ""), new SpecialRule("Any", "")));
    Unit unit0 = new Unit.UnitBuilder("Wizard", new ArrayList<>())
            .nonBaseEquipment(eq0)
            .pointCost(350)
            .build();

    CannotBeTakenTogether ruleOK = new CannotBeTakenTogether(new SpecialRule("Any", ""), new SpecialRule("Pass", ""));
    CannotBeTakenTogether ruleNotOK = new CannotBeTakenTogether(new SpecialRule("Any", ""), new SpecialRule("Wizard Master", ""));

    @BeforeAll
    static void init(){
        RuleViolationLog.clear();
    }

    @Test
    void testCheck(){
        ruleOK.check(unit0);
        assertEquals("", RuleViolationLog.getUnitRuleViolationLog());
        ruleNotOK.check(unit0);
        assertEquals("Any and Wizard Master cannot be taken together\n", RuleViolationLog.getUnitRuleViolationLog());
        RuleViolationLog.clear();
    }

}
