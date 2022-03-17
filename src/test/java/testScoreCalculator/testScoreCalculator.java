package testScoreCalculator;

import scoreCalculator.helpers.GameScoreCalculator;
import scoreCalculator.pojos.NinthAgeScoringSystemPrototype;
import scoreCalculator.rules.PercentageForDifferenceOfLowerTypeRule;
import scoreCalculator.rules.PointsForDifferenceOfLowerTypeRule;
import scoreCalculator.pojos.Wh40kScoringSystemPrototype;
import tournamentHandler.enums.ScorePointType;
import common.ScorePoints;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testScoreCalculator {
    private Wh40kScoringSystemPrototype scoringSystem40k = new Wh40kScoringSystemPrototype();
    private NinthAgeScoringSystemPrototype scoringSystem9th = new NinthAgeScoringSystemPrototype();

    private ScorePoints scorePoints0 = new ScorePoints();
    private ScorePoints scorePoints1 = new ScorePoints();
    private ScorePoints scorePoints2 = new ScorePoints();
    private ScorePoints scorePoints3 = new ScorePoints();
    private ScorePoints scorePoints4 = new ScorePoints();
    private ScorePoints scorePoints5 = new ScorePoints();
    private ScorePoints scorePoints6 = new ScorePoints();
    private ScorePoints scorePoints7 = new ScorePoints();

    private List<ScorePoints> homeScoreList = new ArrayList<>();
    private List<ScorePoints> awayScoreList = new ArrayList<>();


    @BeforeEach
    public void init(){
        scorePoints0.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        scorePoints1.setType(ScorePointType.PRIMARY_SCENARIO_POINT);
        scorePoints2.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        scorePoints3.setType(ScorePointType.EVENT_POINT);
        scorePoints4.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        scorePoints5.setType(ScorePointType.GAME_POINT);
        scorePoints6.setType(ScorePointType.SECONDARY_SCENARIO_POINT);
        scorePoints7.setType(ScorePointType.SECONDARY_SCENARIO_POINT);

        homeScoreList.add(scorePoints0);
        homeScoreList.add(scorePoints2);
        homeScoreList.add(scorePoints4);
        homeScoreList.add(scorePoints6);

        awayScoreList.add(scorePoints1);
        awayScoreList.add(scorePoints3);
        awayScoreList.add(scorePoints5);
        awayScoreList.add(scorePoints7);
    }

    @Test
    public void test40kScoringSystemCalculation(){
        scorePoints0.setPoints(2);
        scorePoints1.setPoints(3);
        scorePoints2.setPoints(5);
        scorePoints3.setPoints(7);
        scorePoints4.setPoints(11);
        scorePoints5.setPoints(13);

        List<ScorePoints> result = GameScoreCalculator.calculateGameScore(homeScoreList, awayScoreList, scoringSystem40k, new ArrayList<>());

        assertEquals(ScorePointType.GAME_POINT, result.get(0).getType());
        assertEquals(ScorePointType.GAME_POINT, result.get(1).getType());
        assertEquals(scoringSystem40k.getRuleList().get(0).getClass(), PointsForDifferenceOfLowerTypeRule.class);

        assertEquals(40, result.get(0).getPoints());     //40
        assertEquals(0, result.get(1).getPoints());    //32
    }

    @Test
    public void testT9AScoringSystemCalculation(){
        scorePoints0.setPoints(501);
        scorePoints1.setPoints(3);
        scorePoints2.setPoints(2251);
        scorePoints3.setPoints(7);
        scorePoints4.setPoints(-226);
        scorePoints5.setPoints(13);

        assertEquals(scoringSystem9th.getRuleList().get(0).getClass(), PercentageForDifferenceOfLowerTypeRule.class);
        List<ScorePoints> result = GameScoreCalculator.calculateGameScore(homeScoreList, awayScoreList, scoringSystem9th, new ArrayList<>());

        assertEquals(ScorePointType.GAME_POINT, result.get(0).getType());
        assertEquals(ScorePointType.GAME_POINT, result.get(1).getType());

        assertEquals(0, result.get(0).getPoints());     //0
        assertEquals(32, result.get(1).getPoints());   //32
    }
}
