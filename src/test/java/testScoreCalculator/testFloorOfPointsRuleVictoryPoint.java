package testScoreCalculator;

import scoreCalculator.rules.FloorOfPointsRule;
import tournamentHandler.enums.ScorePointType;
import common.ScorePoints;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFloorOfPointsRuleVictoryPoint {
    private ScorePoints tooFewPoints = new ScorePoints();
    private ScorePoints wrongTypePoints = new ScorePoints();
    private FloorOfPointsRule rule = new FloorOfPointsRule();

    @Test
    void testImplementRule(){
        rule.setRuleValue(15);
        rule.setInputType(ScorePointType.SECONDARY_SCENARIO_POINT);
        tooFewPoints.setPoints(-342342342);
        wrongTypePoints.setPoints(-534667357);
        tooFewPoints.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        wrongTypePoints.setType(ScorePointType.PRIMARY_SCENARIO_POINT);

        rule.implementRule(new ArrayList<>(Arrays.asList(tooFewPoints, wrongTypePoints)));

        assertEquals(15, tooFewPoints.getPoints());
        assertEquals(-534667357, wrongTypePoints.getPoints());
    }
}
