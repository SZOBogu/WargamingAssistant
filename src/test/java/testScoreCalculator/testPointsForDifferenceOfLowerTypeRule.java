package testScoreCalculator;

import ScoreCalculator.pojos.PointsForDifferenceOfLowerTypeRule;
import TournamentHandler.enums.ScorePointType;
import common.ScorePoints;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPointsForDifferenceOfLowerTypeRule {
    private PointsForDifferenceOfLowerTypeRule rule = new PointsForDifferenceOfLowerTypeRule();
    private ScorePoints pointsNotOK = new ScorePoints();
    private ScorePoints pointsOK = new ScorePoints();
    private ScorePoints pointsBlatantlyOK = new ScorePoints();

    @BeforeEach
    public void init(){
        rule.setPointDifferenceToChangeScore(450);
        pointsNotOK.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        pointsOK.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        pointsBlatantlyOK.setType(ScorePointType.SECONDARY_SCENARIO_POINT);

        pointsNotOK.setPoints(450);
        pointsOK.setPoints(451);
        pointsBlatantlyOK.setPoints(1000);
    }

    @Test
    public void testRuleImplement(){
        ScorePoints pointCase1 = rule.implementRule(pointsNotOK);
        ScorePoints pointCase2 = rule.implementRule(pointsOK);
        ScorePoints pointCase3 = rule.implementRule(pointsBlatantlyOK);

        assertEquals(ScorePointType.PRIMARY_SCENARIO_POINT, pointCase1.getType());
        assertEquals(0, pointCase1.getPoints());

        assertEquals(ScorePointType.PRIMARY_SCENARIO_POINT, pointCase2.getType());
        assertEquals(1, pointCase2.getPoints());

        assertEquals(ScorePointType.PRIMARY_SCENARIO_POINT, pointCase3.getType());
        assertEquals(2, pointCase3.getPoints());
    }
}
