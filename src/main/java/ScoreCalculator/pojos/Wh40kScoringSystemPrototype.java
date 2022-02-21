package ScoreCalculator.pojos;

import ScoreCalculator.calculatingAlgorithms.PoolOfDifferenceAlgorithm;
import ScoreCalculator.rules.PointsForDifferenceOfLowerTypeRule;
import ScoreCalculator.rules.ScoringRule;
import TournamentHandler.enums.ScorePointType;

import java.util.ArrayList;
import java.util.List;

public class Wh40kScoringSystemPrototype extends ScoringSystem{
    public Wh40kScoringSystemPrototype(){
        super();
        PoolOfDifferenceAlgorithm algorithm = new PoolOfDifferenceAlgorithm();
        algorithm.setMaxDifference(10);
        this.setAlgorithm(algorithm);

        List<ScoringRule> rules = new ArrayList<>();
        PointsForDifferenceOfLowerTypeRule rule = new PointsForDifferenceOfLowerTypeRule();
        rule.setInputType(ScorePointType.SECONDARY_SCENARIO_POINT);
        rule.setRuleValue(2);
        rules.add(rule);
        this.setRuleList(rules);
    }
}
