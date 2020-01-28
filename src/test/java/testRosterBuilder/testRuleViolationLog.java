package testRosterBuilder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rosterBuilder.RuleViolationLog;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testRuleViolationLog {
//    @Test
//    public void testAppendUnitRuleViolationLog(String string) {
//        RuleViolationLog.appendUnitRuleViolationLog("test");
//        assertEquals("test\n", RuleViolationLog.getUnitRuleViolationLog());
//        RuleViolationLog.clear();
//    }
//
//    @Test
//    public void testAppendRosterRuleViolationLog(String string) {
//        RuleViolationLog.appendRosterRuleViolationLog("test");
//        assertEquals("test\n", RuleViolationLog.getRosterRuleViolationLog());
//        RuleViolationLog.clear();
//    }
    RuleViolationLog ruleViolationLog = RuleViolationLog.getInstance();

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
