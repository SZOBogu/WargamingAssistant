package rosterBuilder;

public class RuleViolationLog {
//    RuleViolationLog ruleViolationLog = new RuleViolationLog();
    private static String unitRuleViolationLog = "";
    private static String rosterRuleViolationLog = "";

//    private static class RuleViolationLogHolder{
//        private static final RuleViolationLog INSTANCE = new RuleViolationLog();
//    }

//    private RuleViolationLog() {
//        this.unitRuleViolationLog = "";
//        this.rosterRuleViolationLog = "";
//    }
//    public RuleViolationLog getInstance(){
//        return RuleViolationLogHolder.INSTANCE;
//    }

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