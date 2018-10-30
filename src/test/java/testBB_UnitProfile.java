import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class testBB_UnitProfile {
    Entity entbb = new Entity("Runner", "A guy who runs");
    StatsBB statsbb = new StatsBB("6","3","3","8");
    ArrayList<SpecialRule> srbb = new ArrayList<SpecialRule>();
    BB_UnitProfile BBprofile = new BB_UnitProfile(entbb, statsbb, srbb);


    //TODO: before all method that sets up objects above

    @Test
    public void testGetEntity(){
        Entity bb = new Entity("Runner", "A guy who runs");
        assertEquals(bb, BBprofile.getEntity());

    }

    @Test
    public void testGetSpecialRules(){
        ArrayList<SpecialRule> bb = new ArrayList<SpecialRule>();
        SpecialRule dodge = new SpecialRule("Dodge", "descr");
        SpecialRule block = new SpecialRule("Block", "descr");
        SpecialRule tackle = new SpecialRule("Tackle", "descr");

        bb.add(dodge);
        bb.add(block);
        bb.add(tackle);
        assertEquals(bb, BBprofile.getSpecialRules());
    }

    @Test
    public void testGetStats(){
        StatsBB bb = new StatsBB("6","3","3","8");

        assertEquals(bb, BBprofile.getStats());
    }
}
