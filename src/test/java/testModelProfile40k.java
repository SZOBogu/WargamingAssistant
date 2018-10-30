import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testModelProfile40k {
    Entity ent = new Entity("Spess Mehreene", "We fight in da name of de emprah");
    Stats40k stats40k = new Stats40k("7\"","3+","3+","3","3","1",
            "1","7","5+");
    ModelProfile40k profile = new ModelProfile40k(ent, stats40k);
    @Test
    public void testGetEntity(){
        Entity enti = new Entity("Spess Mehreene", "We fight in da name of de emprah");
    }
    @Test
    public void testGetStats(){   //TODO: refactor
        Stats40k regular = new Stats40k("7\"","3+","3+","3","3","1",
                "1","7","5+");
        assertEquals(regular, profile.getStats());
    }
}