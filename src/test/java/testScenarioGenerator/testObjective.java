package testScenarioGenerator;

import org.junit.jupiter.api.Test;
import scenarioGenerator.Objective;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class testObjective {
    Objective obj0 = new Objective("Załóż więcej farm", 10);
    Objective obj1 = new Objective();
    Objective obj2 = new Objective("Trza nam więcej legowisk");

    @Test
    void testGetName(){
        assertEquals("Załóż więcej farm", obj0.getName());
        assertEquals("Objective", obj1.getName());
        assertEquals("Trza nam więcej legowisk", obj2.getName());
    }

    @Test
    void getVictoryPoints(){
        assertEquals(10, obj0.getVictoryPoints());
        assertEquals(1, obj1.getVictoryPoints());
        assertEquals(1, obj2.getVictoryPoints());
    }

}
