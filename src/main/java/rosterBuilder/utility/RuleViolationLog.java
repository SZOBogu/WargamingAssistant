package rosterBuilder.utility;

public class RuleViolationLog {

    private RuleViolationLog(){}

    private static String unitRuleViolationLog = "";
    private static String rosterRuleViolationLog = "";

    public static void appendUnitRuleViolationLog(String string) {
        unitRuleViolationLog += string + "\n";
    }

    public static void appendRosterRuleViolationLog(String string) {
        rosterRuleViolationLog += string + "\n";
    }

    public static String getUnitRuleViolationLog() {
        return  unitRuleViolationLog;
    }

    public static String getRosterRuleViolationLog() {
        return  rosterRuleViolationLog;
    }

    public static void clear() {
        unitRuleViolationLog = "";
        rosterRuleViolationLog = "";
    }
}