package testScoreCalculator;

import ScoreCalculator.pojos.CeilingOfPointsRuleVictoryPoint;
import common.ScorePoints;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCeilingOfPointsRuleVictoryPoint {
    private ScorePoints tooHighPoints = new ScorePoints();
    private CeilingOfPointsRuleVictoryPoint rule = new CeilingOfPointsRuleVictoryPoint();

    @Test
    void testImplementRule(){
        rule.setPointCeiling(55);
        tooHighPoints.setPoints(342342342);

        rule.implementRule(tooHighPoints);

        assertEquals(55, tooHighPoints.getPoints());
    }

}
