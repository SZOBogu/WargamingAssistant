import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testUnitProfileLOTR {
    Entity entlotr = new Entity("Warrior", "a guy who fights");
    StatsLOTR statslotr = new StatsLOTR("4/5+","3","3","1","2","4");
    ArrayList<SpecialRule> srlotr = new ArrayList<SpecialRule>();

    Entity entlotrh = new Entity("Hero", "a guy who's being heroic");
    StatsLOTR statslotrh = new StatsLOTR_Hero("4/5+","3","3","1","2","4",
            "2", "3", "0");
    ArrayList<SpecialRule> srlotrh = new ArrayList<SpecialRule>();

    UnitProfileLOTR LOTRprofile = new UnitProfileLOTR(entlotr, statslotr, srlotr);
    UnitProfileLOTR LOTRprofileHero = new UnitProfileLOTR(entlotrh, statslotrh, srlotrh);

    @Test
    public void testGetEntity(){
        Entity lotr = new Entity("Warrior", "a guy who fights");
        Entity hero = new Entity("Hero", "a guy who's being heroic");
        assertEquals(lotr, LOTRprofile.getEntity());
        assertEquals(hero, LOTRprofileHero.getEntity());
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

        srlotrh.add(er);
        srlotrh.add(van);
        srlotrh.add(wc);

        coo.add(er);
        coo.add(van);
        coo.add(wc);

        assertEquals(coo, LOTRprofile.getSpecialRules());
        assertEquals(coo, LOTRprofileHero.getSpecialRules());
    }

    @Test
    public void testGetStats(){
        StatsLOTR lotr = new StatsLOTR("4/5+","3","3","1","2","4");
        StatsLOTR_Hero hero = new StatsLOTR_Hero("4/5+","3","3","1","2","4",
                "2", "3", "0");
        assertEquals(lotr, LOTRprofile.getStats());
        assertEquals(hero, LOTRprofileHero.getStats());
    }
}
