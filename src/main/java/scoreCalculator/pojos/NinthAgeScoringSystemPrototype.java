package scoreCalculator.pojos;

import scoreCalculator.calculatingAlgorithms.PoolOfDifferenceAlgorithm;
import scoreCalculator.rules.PercentageForDifferenceOfLowerTypeRule;
import scoreCalculator.rules.ScoringRule;
import tournamentHandler.enums.ScorePointType;

import java.util.ArrayList;
import java.util.List;

public class NinthAgeScoringSystemPrototype extends ScoringSystem{
    public NinthAgeScoringSystemPrototype(){
        super();
        PoolOfDifferenceAlgorithm algorithm = new PoolOfDifferenceAlgorithm();
        algorithm.setMaxDifference(10);
        this.setAlgorithm(algorithm);

        List<ScoringRule> rules = new ArrayList<>();
        PercentageForDifferenceOfLowerTypeRule rule = new PercentageForDifferenceOfLowerTypeRule();
        rule.setRosterPointCap(4500);
        rule.setInputType(ScorePointType.SECONDARY_SCENARIO_POINT);
        rule.setRuleValue(5);

        rules.add(rule);
        this.setRuleList(rules);
    }
}
