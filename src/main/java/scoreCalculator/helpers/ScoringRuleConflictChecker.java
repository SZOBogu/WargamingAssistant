package scoreCalculator.helpers;

import scoreCalculator.rules.ScoringRule;

public class ScoringRuleConflictChecker {
    public static boolean areConflicting(ScoringRule rule1, ScoringRule rule2){
        if (rule1.getClass().equals(rule1.getClass()) && rule1.getInputType() == rule2.getInputType()){
            return true;
        }
        return false;
    }
}
