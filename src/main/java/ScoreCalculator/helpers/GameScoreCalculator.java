package ScoreCalculator.helpers;

import ScoreCalculator.calculatingAlgorithms.ScoringAlgorithm;
import ScoreCalculator.pojos.IVictoryPointScoringRule;
import ScoreCalculator.pojos.VictoryPointScoringRule;
import TournamentHandler.enums.ScorePointType;
import common.ScorePoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameScoreCalculator {
    private GameScoreCalculator(){}

    public static List<ScorePoints> calculateGameScore(List<ScorePoints> homePlayerScore, List<ScorePoints> awayPlayerScore,
                                                   List<VictoryPointScoringRule> rules, ScoringAlgorithm algorithm){
        ScorePoints homeEndScore;
        ScorePoints awayEndScore;

        homePlayerScore = ScorePointAdder.addPointsTogether(homePlayerScore);
        awayPlayerScore = ScorePointAdder.addPointsTogether(awayPlayerScore);

        for(VictoryPointScoringRule rule : rules){
            if(rule.getInputType() == ScorePointType.SECONDARY_SCENARIO_POINT)
                rule.implementRule(homePlayerScore);
                rule.implementRule(awayPlayerScore);
        }

        homeEndScore = SumOfScorePointsOfTypeGetter.getSumOfPointsOfType(homePlayerScore, ScorePointType.PRIMARY_SCENARIO_POINT);
        awayEndScore = SumOfScorePointsOfTypeGetter.getSumOfPointsOfType(awayPlayerScore, ScorePointType.PRIMARY_SCENARIO_POINT);

        List<ScorePoints> calculatedGameScore = algorithm.calculateGameScore(homeEndScore, awayEndScore);

        for(ScorePoints points: homePlayerScore){
            if(points.getType() == ScorePointType.PRIMARY_SCENARIO_POINT){
                points.setPoints(calculatedGameScore.get(0).getPoints());
            }
        }

        for(ScorePoints points: awayPlayerScore){
            if(points.getType() == ScorePointType.PRIMARY_SCENARIO_POINT){
                points.setPoints(calculatedGameScore.get(1).getPoints());
            }
        }

        for(VictoryPointScoringRule rule : rules){
            if(rule.getInputType() != ScorePointType.SECONDARY_SCENARIO_POINT)
                rule.implementRule(homePlayerScore);
                rule.implementRule(awayPlayerScore);
        }

        return new ArrayList<>(Arrays.asList(homeEndScore, awayEndScore));
    }

}
