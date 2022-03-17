package scoreCalculator.pojos;

import scoreCalculator.calculatingAlgorithms.CopyPrimaryPointsAlgorithm;
import scoreCalculator.calculatingAlgorithms.ScoringAlgorithm;
import scoreCalculator.rules.ScoringRule;

import java.util.ArrayList;
import java.util.List;

public class ScoringSystem {
    private ScoringAlgorithm algorithm;
    private List<ScoringRule> ruleList;

    public ScoringSystem() {
        this.algorithm = new CopyPrimaryPointsAlgorithm();
        this.ruleList = new ArrayList<>();
    }

    public ScoringAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(ScoringAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public List<ScoringRule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<ScoringRule> ruleList) {
        this.ruleList = ruleList;
    }
}
