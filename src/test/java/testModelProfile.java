import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testModelProfile {
    Entity ent = new Entity("Runner", "A guy who runs");
    ModelProfile profile = new ModelProfile(ent);

    //TODO: before all method that sets up objects above

    @Test
    public void testGetEntity(){
        Entity ent = new Entity("Runner", "A guy who runs");
        assertEquals(ent, profile.getEntity());
    }

}
