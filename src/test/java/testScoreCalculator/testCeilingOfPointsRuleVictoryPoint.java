package testScoreCalculator;

import scoreCalculator.rules.CeilingOfPointsRule;
import tournamentHandler.enums.ScorePointType;
import common.ScorePoints;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCeilingOfPointsRuleVictoryPoint {
    private ScorePoints tooHighPoints = new ScorePoints();
    private ScorePoints wrongTypePoints = new ScorePoints();
    private CeilingOfPointsRule rule = new CeilingOfPointsRule();

    @Test
    void testImplementRule(){
        rule.setRuleValue(55);
        rule.setInputType(ScorePointType.SECONDARY_SCENARIO_POINT);
        tooHighPoints.setPoints(342342342);
        wrongTypePoints.setPoints(534667357);
        tooHighPoints.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        wrongTypePoints.setType(ScorePointType.PRIMARY_SCENARIO_POINT);

        rule.implementRule(new ArrayList<>(Arrays.asList(tooHighPoints, wrongTypePoints)));

        assertEquals(55, tooHighPoints.getPoints());
        assertEquals(534667357, wrongTypePoints.getPoints());
    }

}
