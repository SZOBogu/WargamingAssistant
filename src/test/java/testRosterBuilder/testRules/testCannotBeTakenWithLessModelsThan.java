package testRosterBuilder.testRules;

import org.junit.jupiter.api.Test;
import rosterBuilder.*;
import rosterBuilder.rules.CannotBeTakenWithLessThanModels;
import rosterBuilder.rules.CannotBeTakenWithMoreThanModels;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCannotBeTakenWithLessModelsThan {
    ArrayList<Entity> eq0 = new ArrayList<>(Arrays.asList(new SpecialRule("Wizard Master", ""), new Entity("Talisman", ""), new SpecialRule("Any", "")));
    Unit unit0 = new Unit("Wizard", 10, eq0, new ArrayList<>(),350);

    CannotBeTakenWithLessThanModels ruleOK = new CannotBeTakenWithLessThanModels(new SpecialRule("Any", ""), 1);
    CannotBeTakenWithLessThanModels ruleNotOK = new CannotBeTakenWithLessThanModels(new SpecialRule("Any", ""), 11);

    @Test
    void testCheck(){
        ruleOK.check(unit0);
        assertEquals("", RuleViolationLog.getUnitRuleViolationLog());
        ruleNotOK.check(unit0);
        assertEquals("Any cannot be taken on units with less than 11 models.\n", RuleViolationLog.getUnitRuleViolationLog());
        RuleViolationLog.clear();
    }
}
