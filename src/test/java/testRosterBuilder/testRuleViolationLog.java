package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.utility.RuleViolationLog;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testRuleViolationLog {
//TODO: co to maja byc za testy?
    @Test
    public void testGetUnitRuleViolationLog() {
        assertEquals("", RuleViolationLog.getUnitRuleViolationLog());
    }

    @Test
    public void testGetRosterRuleViolationLog() {
        assertEquals("", RuleViolationLog.getRosterRuleViolationLog());
    }

    @Test
    public void testClear() {
        RuleViolationLog.appendUnitRuleViolationLog("test");
        RuleViolationLog.appendRosterRuleViolationLog("test");

        RuleViolationLog.clear();

        assertEquals("", RuleViolationLog.getUnitRuleViolationLog());
        assertEquals("", RuleViolationLog.getRosterRuleViolationLog());
    }
}
