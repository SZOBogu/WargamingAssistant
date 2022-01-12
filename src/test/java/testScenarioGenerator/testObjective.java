package testScenarioGenerator;

import common.ScorePoints;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scenarioGenerator.pojos.Objective;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class testObjective {
    Objective obj = new Objective();
    ScorePoints scorePoints = new ScorePoints();

    @Test
    void testGetName(){
        assertEquals("Objective 0", obj.getName());
    }

    @Test
    void getVictoryPoints(){
        assertEquals(new ScorePoints().getPoints(), obj.getVictoryPoints().getPoints());
        assertEquals(new ScorePoints().getType(), obj.getVictoryPoints().getType());
    }

    @Test
    void setVictoryPoints(){
        obj.setVictoryPoints(scorePoints);
        assertEquals(scorePoints, obj.getVictoryPoints());
    }

}
