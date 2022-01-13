package testScoreCalculator;

import ScoreCalculator.calculatingAlgorithms.DifferenceOfSumsScoringAlgorithm;
import ScoreCalculator.calculatingAlgorithms.PoolOfDifferenceAlgorithm;
import TournamentHandler.enums.ScorePointType;
import common.ScorePoints;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPoolOfDifferenceAlgorithm {
    private ScorePoints homeScore = new ScorePoints();
    private ScorePoints awayScore = new ScorePoints();

    @BeforeEach
    public void init(){
        homeScore.setType(ScorePointType.PRIMARY_SCENARIO_POINT);
        awayScore.setType(ScorePointType.PRIMARY_SCENARIO_POINT);
    }

    @Test
    public void testCalculateGameScoreCappedForAway(){
        homeScore.setPoints(4);
        awayScore.setPoints(16);

        PoolOfDifferenceAlgorithm algorithm = new PoolOfDifferenceAlgorithm();
        algorithm.setMaxDifference(10);
        List<ScorePoints> resultList = algorithm.calculateGameScore(homeScore, awayScore);

        assertEquals(0, resultList.get(0).getPoints());
        assertEquals(20, resultList.get(1).getPoints());

        assertEquals(ScorePointType.GAME_POINT, resultList.get(0).getType());
        assertEquals(ScorePointType.GAME_POINT, resultList.get(1).getType());
    }

    @Test
    public void testCalculateGameScoreCappedForHome(){
        homeScore.setPoints(24);
        awayScore.setPoints(6);

        PoolOfDifferenceAlgorithm algorithm = new PoolOfDifferenceAlgorithm();
        algorithm.setMaxDifference(10);
        List<ScorePoints> resultList = algorithm.calculateGameScore(homeScore, awayScore);

        assertEquals(20, resultList.get(0).getPoints());
        assertEquals(0, resultList.get(1).getPoints());

        assertEquals(ScorePointType.GAME_POINT, resultList.get(0).getType());
        assertEquals(ScorePointType.GAME_POINT, resultList.get(1).getType());
    }

    @Test
    public void testCalculateGameScoreUncappedForHome(){
        homeScore.setPoints(4);
        awayScore.setPoints(12);

        PoolOfDifferenceAlgorithm algorithm = new PoolOfDifferenceAlgorithm();
        algorithm.setMaxDifference(10);
        List<ScorePoints> resultList = algorithm.calculateGameScore(homeScore, awayScore);

        assertEquals(2, resultList.get(0).getPoints());
        assertEquals(18, resultList.get(1).getPoints());

        assertEquals(ScorePointType.GAME_POINT, resultList.get(0).getType());
        assertEquals(ScorePointType.GAME_POINT, resultList.get(1).getType());
    }

    @Test
    public void testCalculateGameScoreUncappedForAway(){
        homeScore.setPoints(12);
        awayScore.setPoints(4);

        PoolOfDifferenceAlgorithm algorithm = new PoolOfDifferenceAlgorithm();
        algorithm.setMaxDifference(10);
        List<ScorePoints> resultList = algorithm.calculateGameScore(homeScore, awayScore);

        assertEquals(18, resultList.get(0).getPoints());
        assertEquals(2, resultList.get(1).getPoints());

        assertEquals(ScorePointType.GAME_POINT, resultList.get(0).getType());
        assertEquals(ScorePointType.GAME_POINT, resultList.get(1).getType());
    }
}
