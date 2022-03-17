package testScoreCalculator;

import scoreCalculator.rules.PercentageForDifferenceOfLowerTypeRule;
import tournamentHandler.enums.ScorePointType;
import common.ScorePoints;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class testPercentageForDifferenceOfLowerTypeRule {
    private PercentageForDifferenceOfLowerTypeRule rule = new PercentageForDifferenceOfLowerTypeRule();
    private ScorePoints pointsNotOK = new ScorePoints();
    private ScorePoints pointsOK = new ScorePoints();
    private ScorePoints pointsBlatantlyOK = new ScorePoints();
    private ScorePoints pointsNotOKWrongType = new ScorePoints();
    private ScorePoints pointsOKWrongType = new ScorePoints();
    private ScorePoints pointsBlatantlyOKWrongType = new ScorePoints();

    @BeforeEach
    public void init(){
        rule.setRuleValue(5);
        rule.setRosterPointCap(4500);

        pointsNotOK.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        pointsOK.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        pointsBlatantlyOK.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        pointsNotOKWrongType.setType(ScorePointType.PRIMARY_SCENARIO_POINT);
        pointsOKWrongType.setType(ScorePointType.PRIMARY_SCENARIO_POINT);
        pointsBlatantlyOKWrongType.setType(ScorePointType.PRIMARY_SCENARIO_POINT);

        pointsNotOK.setPoints(225);
        pointsOK.setPoints(226);
        pointsBlatantlyOK.setPoints(1000);
        pointsNotOKWrongType.setPoints(225);
        pointsOKWrongType.setPoints(226);
        pointsBlatantlyOKWrongType.setPoints(1000);
    }

    @Test
    public void testRuleImplement(){
        List<ScorePoints> pointCase1 = rule.implementRule(new ArrayList<>(Arrays.asList(pointsNotOK, pointsNotOKWrongType)));
        List<ScorePoints> pointCase2 = rule.implementRule(new ArrayList<>(Arrays.asList(pointsOK, pointsOKWrongType)));
        List<ScorePoints> pointCase3 = rule.implementRule(new ArrayList<>(Arrays.asList(pointsBlatantlyOK, pointsBlatantlyOKWrongType)));

        fail();
    }

}
