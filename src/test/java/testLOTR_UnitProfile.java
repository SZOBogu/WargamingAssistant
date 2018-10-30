import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testLOTR_UnitProfile {
    Entity entlotr = new Entity("Warrior", "a guy who fights");
    StatsLOTR statslotr = new StatsLOTR("4/5+","3","3","1","2","4");
    ArrayList<SpecialRule> srlotr = new ArrayList<SpecialRule>();
    LOTR_UnitProfile LOTRprofile = new LOTR_UnitProfile(entlotr, statslotr, srlotr);

    @Test
    public void testGetEntity(){
        Entity lotr = new Entity("Warrior", "a guy who fights");
        assertEquals(lotr, LOTRprofile.getEntity());
    }

    @Test
    public void testGetSpecialRules(){
        ArrayList<SpecialRule> coo = new ArrayList<SpecialRule>();
        SpecialRule er = new SpecialRule("Expert Rider", "descr");
        SpecialRule van = new SpecialRule("Vanguard", "descr");
        SpecialRule wc = new SpecialRule("Woodland Creature", "descr");

        //TODO:Do beforeAll
        srlotr.add(er);
        srlotr.add(van);
        srlotr.add(wc);

        coo.add(er);
        coo.add(van);
        coo.add(wc);
        assertEquals(coo, LOTRprofile.getSpecialRules());
    }

    @Test
    public void testGetStats(){
        StatsLOTR lotr = new StatsLOTR("4/5+","3","3","1","2","4");
        assertEquals(lotr, LOTRprofile.getStats());
    }
}
