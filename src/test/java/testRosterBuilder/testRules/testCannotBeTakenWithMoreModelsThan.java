package testRosterBuilder.testRules;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rosterBuilder.*;
import rosterBuilder.rules.CannotBeTakenTogether;
import rosterBuilder.rules.CannotBeTakenWithMoreThanModels;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCannotBeTakenWithMoreModelsThan {
    ArrayList<Entity> eq0 = new ArrayList<>(Arrays.asList(new SpecialRule("Wizard Master", ""), new Entity("Talisman", ""), new SpecialRule("Any", "")));
    Unit unit0 = new Unit("Wizard", 2, eq0, new ArrayList<>(),350);
    RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();
    CannotBeTakenWithMoreThanModels ruleOK = new CannotBeTakenWithMoreThanModels(new SpecialRule("Any", ""), 100);
    CannotBeTakenWithMoreThanModels ruleNotOK = new CannotBeTakenWithMoreThanModels(new SpecialRule("Any", ""), 1);

    @BeforeAll
    static void init(){
        RuleViolationLog.clear();
    }

    @Test
    void testCheck(){
        ruleOK.check(unit0);
        assertEquals("", ruleViolationLog.getUnitRuleViolationLog());
        ruleNotOK.check(unit0);
        assertEquals("Any cannot be taken on units with more than 1 models.\n", ruleViolationLog.getUnitRuleViolationLog());
        ruleViolationLog.clear();
    }
}
