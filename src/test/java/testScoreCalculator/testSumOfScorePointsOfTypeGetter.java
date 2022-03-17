package testScoreCalculator;

import scoreCalculator.helpers.SumOfScorePointsOfTypeGetter;
import tournamentHandler.enums.ScorePointType;
import common.ScorePoints;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testSumOfScorePointsOfTypeGetter {
    private ScorePoints points0 = new ScorePoints();
    private ScorePoints points1 = new ScorePoints();
    private ScorePoints points2 = new ScorePoints();
    private ScorePoints points3 = new ScorePoints();

    private List<ScorePoints> pointList = new ArrayList<>(Arrays.asList(points0, points1, points2, points3));

    @BeforeEach
    public void init(){
        points0.setPoints(5);
        points1.setPoints(3);
        points2.setPoints(15);
        points3.setPoints(9);

        points0.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        points1.setType(ScorePointType.PRIMARY_SCENARIO_POINT);
        points2.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        points3.setType(ScorePointType.EVENT_POINT);
    }

    @Test
    public void testAddingWith2OKTypes(){
        ScorePoints addedScores = SumOfScorePointsOfTypeGetter.getSumOfPointsOfType(pointList, ScorePointType.SECONDARY_SCENARIO_POINT);
        assertEquals(20, addedScores.getPoints());
        assertEquals(ScorePointType.SECONDARY_SCENARIO_POINT, addedScores.getType());
    }

    @Test
    public void testAddingWith1OKType(){
        ScorePoints addedScores = SumOfScorePointsOfTypeGetter.getSumOfPointsOfType(pointList, ScorePointType.EVENT_POINT);
        assertEquals(9, addedScores.getPoints());
        assertEquals(ScorePointType.EVENT_POINT, addedScores.getType());
    }

    @Test
    public void testAddingWithNoOKTypes(){
        ScorePoints addedScores = SumOfScorePointsOfTypeGetter.getSumOfPointsOfType(pointList, ScorePointType.MATCH_POINT);
        assertEquals(0, addedScores.getPoints());
        assertEquals(ScorePointType.MATCH_POINT, addedScores.getType());
    }
}
