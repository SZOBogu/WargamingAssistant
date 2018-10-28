import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testSpecialRule {
    @Test
    void testGetName(){
        SpecialRule sr = new SpecialRule("Chosen of Ashuruk", "The model automatically passes all Fear Tests (but still suffers -1 Discipline from Fear) and considers all units\n" +
                "without Chosen of Ashuruk as Insignificant. Furthermore, model parts without Harnessed gain Battle Focus, which\n" +
                "cannot be used during the first Round of Combat. R&F models with Chosen of Ashuruk cannot be joined by\n" +
                "Characters without Chosen of Ashuruk.");
        assertEquals("Chosen of Ashuruk", sr.getName());
    }
    @Test
    void testGetDescription(){
        SpecialRule sr = new SpecialRule("Chosen of Ashuruk", "The model automatically passes all Fear Tests (but still suffers -1 Discipline from Fear) and considers all units\n" +
                "without Chosen of Ashuruk as Insignificant. Furthermore, model parts without Harnessed gain Battle Focus, which\n" +
                "cannot be used during the first Round of Combat. R&F models with Chosen of Ashuruk cannot be joined by\n" +
                "Characters without Chosen of Ashuruk.");
        assertEquals("The model automatically passes all Fear Tests (but still suffers -1 Discipline from Fear) and considers all units\n" +
                "without Chosen of Ashuruk as Insignificant. Furthermore, model parts without Harnessed gain Battle Focus, which\n" +
                "cannot be used during the first Round of Combat. R&F models with Chosen of Ashuruk cannot be joined by\n" +
                "Characters without Chosen of Ashuruk.", sr.getDescription());
    }
}
