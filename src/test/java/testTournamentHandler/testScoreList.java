package testTournamentHandler;

import tournamentHandler.pojos.ScoreList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testScoreList {
    ScoreList scoreList1 = new ScoreList();
    ScoreList scoreList2 = new ScoreList();

    @Test
    void testCompareTo(){
        assertEquals(0, scoreList1.compareTo(scoreList2));
    }

}
