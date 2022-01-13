package ScoreCalculator.pojos;

import ScoreCalculator.calculatingAlgorithms.CopyPrimaryPointsAlgorithm;
import ScoreCalculator.calculatingAlgorithms.ScoringAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class ScoringSystem {
    private ScoringAlgorithm algorithm;
    private List<IVictoryPointScoringRule> ruleList;

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

    public List<IVictoryPointScoringRule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<IVictoryPointScoringRule> ruleList) {
        this.ruleList = ruleList;
    }
}
