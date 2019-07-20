package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.SpecialRule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testSpecialRule {
    SpecialRule sr = new SpecialRule("Chosen of Ashuruk", "The model automatically passes all Fear Tests (but still suffers -1 Discipline from Fear) and considers all units\n" +
            "without Chosen of Ashuruk as Insignificant. Furthermore, model parts without Harnessed gain Battle Focus, which\n" +
            "cannot be used during the first Round of Combat. R&F models with Chosen of Ashuruk cannot be joined by\n" +
            "Characters without Chosen of Ashuruk.");
    SpecialRule sr0 = new SpecialRule("Ward", "The model automatically passes all Fear Tests (but still suffers -1 Discipline from Fear) and considers all units\n" +
            "without Chosen of Ashuruk as Insignificant. Furthermore, model parts without Harnessed gain Battle Focus, which\n" +
            "cannot be used during the first Round of Combat. R&F models with Chosen of Ashuruk cannot be joined by\n" +
            "Characters without Chosen of Ashuruk.", "5+");
    @Test
    public void testGetName(){
        assertEquals("Chosen of Ashuruk", sr.getName());
    }
    @Test
    public void testGetDescription(){
        assertEquals("The model automatically passes all Fear Tests (but still suffers -1 Discipline from Fear) and considers all units\n" +
                "without Chosen of Ashuruk as Insignificant. Furthermore, model parts without Harnessed gain Battle Focus, which\n" +
                "cannot be used during the first Round of Combat. R&F models with Chosen of Ashuruk cannot be joined by\n" +
                "Characters without Chosen of Ashuruk.", sr.getDescription());
    }
    @Test
    public void testToString(){
        assertEquals("Chosen of Ashuruk", sr.toString());
        assertEquals("Ward(5+)", sr0.toString());
    }

    @Test
    void testGetParameter(){
        assertTrue(sr.getParameter().isEmpty());
        assertEquals("5+", sr0.getParameter());
    }

    @Test
    void testSetParameter(){
        sr.setParameter("5+");
        sr0.setParameter("against Flaming Attacks");

        assertEquals("5+", sr.getParameter());
        assertEquals("against Flaming Attacks", sr0.getParameter());
    }
}
