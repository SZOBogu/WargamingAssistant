package ScoreCalculator.calculatingAlgorithms;

import TournamentHandler.enums.ScorePointType;
import common.ScorePoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PoolOfDifferenceAlgorithm implements ScoringAlgorithm{
    @Override
    public List<ScorePoints> calculateGameScore(ScorePoints homePlayerScore, ScorePoints awayPlayerScore) {
        ScorePoints homePlayerEndScore = new ScorePoints();
        ScorePoints awayPlayerEndScore = new ScorePoints();
        homePlayerEndScore.setPoints(10);
        awayPlayerEndScore.setPoints(10);
        homePlayerEndScore.setType(ScorePointType.GAME_POINT);
        awayPlayerEndScore.setType(ScorePointType.GAME_POINT);

       int difference = homePlayerScore.getPoints() - awayPlayerScore.getPoints();
       if(difference > 0 && difference < 10){
            for(int i = 0; i < difference; i++){
                homePlayerEndScore.setPoints(homePlayerEndScore.getPoints() + 1);
                awayPlayerEndScore.setPoints(awayPlayerEndScore.getPoints() - 1);

            }
        }
       else if(difference < 0 && difference < 10){
           for(int i = 0; i < difference; i++){
               homePlayerEndScore.setPoints(homePlayerEndScore.getPoints() - 1);
               awayPlayerEndScore.setPoints(awayPlayerEndScore.getPoints() + 1);

           }
       }
       else if(difference > 10){
           homePlayerEndScore.setPoints(0);
           awayPlayerEndScore.setPoints(20);
       }
       else if(difference < 10){
           homePlayerEndScore.setPoints(20);
           awayPlayerEndScore.setPoints(0);
       }
        return new ArrayList<>(Arrays.asList(homePlayerEndScore, awayPlayerEndScore));
    }
}
