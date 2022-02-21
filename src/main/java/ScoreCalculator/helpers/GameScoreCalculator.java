package ScoreCalculator.helpers;

import ScoreCalculator.pojos.ScoringSystem;
import ScoreCalculator.rules.ScoringRule;
import TournamentHandler.enums.ScorePointType;
import common.ScorePoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameScoreCalculator {
    private GameScoreCalculator(){}

    public static List<ScorePoints> calculateGameScore(List<ScorePoints> homePlayerScore, List<ScorePoints> awayPlayerScore,
                                                       ScoringSystem scoringSystem, List<ScoringRule> eventRules){
        ScorePoints homeEndScore;
        ScorePoints awayEndScore;

        List<ScorePoints> homePostFirstRuleResultList = new ArrayList<>();
        List<ScorePoints> awayPostFirstRuleResultList = new ArrayList<>();
        List<ScoringRule> allRules = scoringSystem.getRuleList();

        for(ScoringRule i : scoringSystem.getRuleList()){
            for(ScoringRule j : eventRules){
                if(ScoringRuleConflictChecker.areConflicting(i, j))
                    allRules.remove(i);
            }
        }

        allRules.addAll(eventRules);

        for(ScoringRule rule : allRules){
            if(rule.getInputType() == ScorePointType.SECONDARY_SCENARIO_POINT) {
                homePostFirstRuleResultList.addAll(rule.implementRule(homePlayerScore));
                awayPostFirstRuleResultList.addAll(rule.implementRule(awayPlayerScore));
            }
        }
        homePlayerScore.addAll(homePostFirstRuleResultList);
        awayPlayerScore.addAll(awayPostFirstRuleResultList);
        homeEndScore = SumOfScorePointsOfTypeGetter.getSumOfPointsOfType(homePlayerScore, ScorePointType.PRIMARY_SCENARIO_POINT);
        awayEndScore = SumOfScorePointsOfTypeGetter.getSumOfPointsOfType(awayPlayerScore, ScorePointType.PRIMARY_SCENARIO_POINT);

        List<ScorePoints> calculatedGameScore = scoringSystem.getAlgorithm().calculateGameScore(homeEndScore, awayEndScore);

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
        homePostFirstRuleResultList.clear();
        awayPostFirstRuleResultList.clear();

        for(ScoringRule rule : scoringSystem.getRuleList()){
            if(rule.getInputType() == ScorePointType.PRIMARY_SCENARIO_POINT) {
                homePostFirstRuleResultList.addAll(rule.implementRule(homePlayerScore));
                awayPostFirstRuleResultList.addAll(rule.implementRule(awayPlayerScore));
            }
        }
        homePlayerScore.addAll(homePostFirstRuleResultList);
        awayPlayerScore.addAll(awayPostFirstRuleResultList);

        List<ScorePoints> finalHomeResults = ScorePointAdder.addPointsTogether(homePlayerScore);
        List<ScorePoints> finalAwayResults = ScorePointAdder.addPointsTogether(awayPlayerScore);

        for(ScorePoints scorePoints : finalHomeResults){
            if(scorePoints.getType() == ScorePointType.PRIMARY_SCENARIO_POINT){
                homeEndScore = scorePoints;
            }
        }

        for(ScorePoints scorePoints : finalAwayResults){
            if(scorePoints.getType() == ScorePointType.PRIMARY_SCENARIO_POINT){
                awayEndScore = scorePoints;
            }
        }

        homeEndScore.setType(ScorePointType.GAME_POINT);
        awayEndScore.setType(ScorePointType.GAME_POINT);

        return new ArrayList<>(Arrays.asList(homeEndScore, awayEndScore));
    }

}
