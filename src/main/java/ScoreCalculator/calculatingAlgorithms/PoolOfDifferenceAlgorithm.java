package ScoreCalculator.calculatingAlgorithms;

import TournamentHandler.enums.ScorePointType;
import common.ScorePoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PoolOfDifferenceAlgorithm implements ScoringAlgorithm{
    private int maxDifference;

    public int getMaxDifference() {
        return maxDifference;
    }

    public void setMaxDifference(int maxDifference) {
        this.maxDifference = maxDifference;
    }

    @Override
    public List<ScorePoints> calculateGameScore(ScorePoints homePlayerScore, ScorePoints awayPlayerScore) {
        ScorePoints homePlayerEndScore = new ScorePoints();
        ScorePoints awayPlayerEndScore = new ScorePoints();
        homePlayerEndScore.setPoints(maxDifference);
        awayPlayerEndScore.setPoints(maxDifference);
        homePlayerEndScore.setType(ScorePointType.GAME_POINT);
        awayPlayerEndScore.setType(ScorePointType.GAME_POINT);

       int difference = homePlayerScore.getPoints() - awayPlayerScore.getPoints();

       if(difference > 0 && difference < maxDifference){
            for(int i = 0; i < difference; i++){
                homePlayerEndScore.setPoints(homePlayerEndScore.getPoints() + 1);
                awayPlayerEndScore.setPoints(awayPlayerEndScore.getPoints() - 1);

            }
        }
       else if(difference < 0 && Math.abs(difference) < maxDifference){
           for(int i = 0; i < Math.abs(difference); i++){
               homePlayerEndScore.setPoints(homePlayerEndScore.getPoints() - 1);
               awayPlayerEndScore.setPoints(awayPlayerEndScore.getPoints() + 1);

           }
       }
       else if(difference > maxDifference){
           homePlayerEndScore.setPoints(maxDifference * 2);
           awayPlayerEndScore.setPoints(0);
       }
       else if(difference < -maxDifference){
           homePlayerEndScore.setPoints(0);
           awayPlayerEndScore.setPoints(maxDifference * 2);
       }
        return new ArrayList<>(Arrays.asList(homePlayerEndScore, awayPlayerEndScore));
    }
}
