package testScoreCalculator;

import scoreCalculator.calculatingAlgorithms.CopyPrimaryPointsAlgorithm;
import tournamentHandler.enums.ScorePointType;
import common.ScorePoints;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCopyPrimaryPointsAlgorithm {
    private ScorePoints homeScore = new ScorePoints();
    private ScorePoints awayScore = new ScorePoints();

    @Test
    public void testCalculateGameScore(){
        homeScore.setType(ScorePointType.PRIMARY_SCENARIO_POINT);
        awayScore.setType(ScorePointType.PRIMARY_SCENARIO_POINT);

        homeScore.setPoints(4);
        awayScore.setPoints(16);

        CopyPrimaryPointsAlgorithm algorithm = new CopyPrimaryPointsAlgorithm();
        List<ScorePoints> resultList = algorithm.calculateGameScore(homeScore, awayScore);

        assertEquals(4, resultList.get(0).getPoints());
        assertEquals(16, resultList.get(1).getPoints());

        assertEquals(ScorePointType.GAME_POINT, resultList.get(0).getType());
        assertEquals(ScorePointType.GAME_POINT, resultList.get(1).getType());
    }
}
