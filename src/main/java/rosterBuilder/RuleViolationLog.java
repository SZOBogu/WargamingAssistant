package rosterBuilder;

public class RuleViolationLog {
    private static String unitRuleViolationLog = "";
    private static String rosterRuleViolationLog = "";

    private static class SingletonHolder {
        private static final RuleViolationLog ruleViolationLog = new RuleViolationLog();
    }

    public static RuleViolationLog getInstance(){
        return SingletonHolder.ruleViolationLog;
    }

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