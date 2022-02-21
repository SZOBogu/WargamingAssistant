package testScoreCalculator;

import TournamentHandler.enums.ScorePointType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testScorePointType {
    ScorePointType type1 = ScorePointType.SECONDARY_SCENARIO_POINT;
    ScorePointType type2 = ScorePointType.PRIMARY_SCENARIO_POINT;
    ScorePointType type3 = ScorePointType.GAME_POINT;
    ScorePointType type4 = ScorePointType.MATCH_POINT;
    ScorePointType type5 = ScorePointType.EVENT_POINT;

    @Test
    public void tesGetValue(){
        assertEquals(0, type1.ordinal());
        assertEquals(1, type2.ordinal());
        assertEquals(2, type3.ordinal());
        assertEquals(3, type4.ordinal());
        assertEquals(4, type5.ordinal());
    }
}
