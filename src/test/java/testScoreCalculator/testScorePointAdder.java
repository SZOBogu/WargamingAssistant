package testScoreCalculator;

import ScoreCalculator.helpers.ScorePointAdder;
import TournamentHandler.enums.ScorePointType;
import common.ScorePoints;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testScorePointAdder {
    private ScorePoints points0 = new ScorePoints();
    private ScorePoints points1 = new ScorePoints();
    private ScorePoints points2 = new ScorePoints();
    private ScorePoints points3 = new ScorePoints();

    private List<ScorePoints> pointList = new ArrayList<>(Arrays.asList(points0, points1, points2, points3));
    //SECONDARY_SCENARIO_POINT, PRIMARY_SCENARIO_POINT, GAME_POINT, TEAM_POINT, EVENT_POINT

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
    public void testAddPointsTogether(){
        List<ScorePoints> pointSumList = ScorePointAdder.addPointsTogether(pointList);

        assertEquals(5, pointSumList.size());

        assertEquals(20, pointSumList.get(0).getPoints());
        assertEquals(3, pointSumList.get(1).getPoints());
        assertEquals(0, pointSumList.get(2).getPoints());
        assertEquals(0, pointSumList.get(3).getPoints());
        assertEquals(9, pointSumList.get(4).getPoints());

        assertEquals(ScorePointType.SECONDARY_SCENARIO_POINT, pointSumList.get(0).getType());
        assertEquals(ScorePointType.PRIMARY_SCENARIO_POINT, pointSumList.get(1).getType());
        assertEquals(ScorePointType.GAME_POINT, pointSumList.get(2).getType());
        assertEquals(ScorePointType.TEAM_POINT, pointSumList.get(3).getType());
        assertEquals(ScorePointType.EVENT_POINT, pointSumList.get(4).getType());
    }

    @Test
    public void testAddPoints(){
        List<ScorePoints> pointSumList = ScorePointAdder.addPoints(pointList, ScorePointType.SECONDARY_SCENARIO_POINT, 11);

        assertEquals(31, pointSumList.get(0).getPoints());
        assertEquals(3, pointSumList.get(1).getPoints());
        assertEquals(0, pointSumList.get(2).getPoints());
        assertEquals(0, pointSumList.get(3).getPoints());
        assertEquals(9, pointSumList.get(4).getPoints());

        assertEquals(ScorePointType.SECONDARY_SCENARIO_POINT, pointSumList.get(0).getType());
        assertEquals(ScorePointType.PRIMARY_SCENARIO_POINT, pointSumList.get(1).getType());
        assertEquals(ScorePointType.GAME_POINT, pointSumList.get(2).getType());
        assertEquals(ScorePointType.TEAM_POINT, pointSumList.get(3).getType());
        assertEquals(ScorePointType.EVENT_POINT, pointSumList.get(4).getType());
    }
}
