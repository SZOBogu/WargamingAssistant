import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testUnitProfile {
    Entity ent = new Entity("Runner", "A guy who runs");
    ArrayList<SpecialRule> sr = new ArrayList<SpecialRule>();
    UnitProfile profile = new UnitProfile(ent, sr);

    //TODO: before all method that sets up objects above

    @Test
    public void testGetEntity(){
        Entity ent = new Entity("Runner", "A guy who runs");
        assertEquals(ent, profile.getEntity());
    }

    @Test
    public void testGetSpecialRules(){
        SpecialRule dodge = new SpecialRule("Dodge", "descr");
        SpecialRule block = new SpecialRule("Block", "descr");
        SpecialRule tackle = new SpecialRule("Tackle", "descr");
        ArrayList<SpecialRule> srs = profile.getSpecialRules();
        srs.add(dodge);
        srs.add(block);
        srs.add(tackle);

        ArrayList<SpecialRule> temp = new ArrayList<SpecialRule>();

        temp.add(dodge);
        temp.add(block);
        temp.add(tackle);
        assertEquals(temp, profile.getSpecialRules());
    }
}
