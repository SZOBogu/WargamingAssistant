package testRosterBuilder.testRules;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rosterBuilder.pojos.Entity;
import rosterBuilder.pojos.SpecialRule;
import rosterBuilder.pojos.Unit;
import rosterBuilder.rules.MustBeTakenTogether;
import rosterBuilder.utility.RuleViolationLog;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMustBeTakenTogether {
    ArrayList<Entity> eq0 = new ArrayList<>(Arrays.asList(new SpecialRule("Wizard Master", ""), new Entity("Talisman", ""), new SpecialRule("Any", "")));
    Unit unit0 = new Unit.UnitBuilder("Wizard", new ArrayList<>())
            .nonBaseEquipment(eq0)
            .pointCost(350)
            .build();

    MustBeTakenTogether ruleOK = new MustBeTakenTogether(new SpecialRule("Wizard Master", ""), new SpecialRule("Any", ""));
    MustBeTakenTogether ruleNotOK = new MustBeTakenTogether(new SpecialRule("Any", ""), new SpecialRule("Not pass", ""));

    @BeforeAll
    static void init(){
        RuleViolationLog.clear();
    }

    @Test
    void testCheck(){
        ruleOK.check(unit0);
        assertEquals("", RuleViolationLog.getUnitRuleViolationLog());
        ruleNotOK.check(unit0);
        assertEquals("Any cannot be taken without Not pass.\n", RuleViolationLog.getUnitRuleViolationLog());
        RuleViolationLog.clear();
    }
}
