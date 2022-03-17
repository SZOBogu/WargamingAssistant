package testScoreCalculator;

import scoreCalculator.calculatingAlgorithms.DifferenceOfSumsScoringAlgorithm;
import tournamentHandler.enums.ScorePointType;
import common.ScorePoints;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDifferenceOfSumsScoringAlgorithm {
        private ScorePoints homeScore = new ScorePoints();
        private ScorePoints awayScore = new ScorePoints();

        @Test
        public void testCalculateGameScore(){
                homeScore.setType(ScorePointType.PRIMARY_SCENARIO_POINT);
                awayScore.setType(ScorePointType.PRIMARY_SCENARIO_POINT);

                homeScore.setPoints(4);
                awayScore.setPoints(16);

                DifferenceOfSumsScoringAlgorithm algorithm = new DifferenceOfSumsScoringAlgorithm();
                List<ScorePoints> resultList = algorithm.calculateGameScore(homeScore, awayScore);

                assertEquals(0, resultList.get(0).getPoints());
                assertEquals(12, resultList.get(1).getPoints());

                assertEquals(ScorePointType.GAME_POINT, resultList.get(0).getType());
                assertEquals(ScorePointType.GAME_POINT, resultList.get(1).getType());
        }
}
