package testRosterBuilder.testRules;

import org.junit.jupiter.api.Test;
import rosterBuilder.*;
import rosterBuilder.rules.CannotBeTakenTogether;
import rosterBuilder.rules.MustHaveAtLeast;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCannotBeTakenTogether {
    ArrayList<Entity> eq0 = new ArrayList<>(Arrays.asList(new SpecialRule("Wizard Master", ""), new Entity("Talisman", ""), new SpecialRule("Any", "")));
    Unit unit0 = new Unit("Wizard", 1, eq0, new ArrayList<>(),350);

    CannotBeTakenTogether ruleOK = new CannotBeTakenTogether(new SpecialRule("Any", ""), new SpecialRule("Pass", ""));
    CannotBeTakenTogether ruleNotOK = new CannotBeTakenTogether(new SpecialRule("Any", ""), new SpecialRule("Wizard Master", ""));

    @Test
    void testCheck(){
        ruleOK.check(unit0);
        assertEquals("", RuleViolationLog.getUnitRuleViolationLog());
        ruleNotOK.check(unit0);
        assertEquals("Any and Wizard Master cannot be taken together\n", RuleViolationLog.getUnitRuleViolationLog());
        RuleViolationLog.clear();
    }

}
