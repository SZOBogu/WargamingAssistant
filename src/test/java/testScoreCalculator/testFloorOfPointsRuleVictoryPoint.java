package testScoreCalculator;

import ScoreCalculator.pojos.CeilingOfPointsRuleVictoryPoint;
import ScoreCalculator.pojos.FloorOfPointsRuleVictoryPoint;
import common.ScorePoints;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFloorOfPointsRuleVictoryPoint {
    private ScorePoints tooFewPoints = new ScorePoints();
    private FloorOfPointsRuleVictoryPoint rule = new FloorOfPointsRuleVictoryPoint();

    @Test
    void testImplementRule(){
        rule.setPointFloor(15);
        tooFewPoints.setPoints(-342342342);

        rule.implementRule(tooFewPoints);

        assertEquals(15, tooFewPoints.getPoints());
    }
}
