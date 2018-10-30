import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testModelProfileT9A {
    Entity ent = new Entity("Spess Mehreene", "We fight in da name of de emprah");
    StatsT9A_Global gstats = new StatsT9A_Global("10\"","20\"","7");
    StatsT9A_Offensive ostats = new StatsT9A_Offensive("3","5","4","1","5");
    StatsT9A_Defensive dstats = new StatsT9A_Defensive("3","3","4","1");
    ArrayList<SpecialRule> specialRules = new ArrayList<SpecialRule>();
    ModelProfileT9A profile = new ModelProfileT9A(ent, gstats, ostats, dstats, specialRules);


    @Test
    public void testGetEntity(){
        Entity enti = new Entity("Siren", " ");
    }
    @Test
    public void testGetGlobalStats(){
        StatsT9A_Global stat = new StatsT9A_Global("10\"","20\"","7");
        assertEquals(stat, profile.getGlobalStats());
    }
    @Test
    public void testGetOffensiveStats(){
        StatsT9A_Offensive stat = new StatsT9A_Offensive("3","5","4","1","5");
        assertEquals(stat, profile.getOffensiveStats());
    }
    @Test
    public void testGetDefensiveStats() {
        StatsT9A_Defensive stat = new StatsT9A_Defensive("3", "3", "4", "1");
        assertEquals(stat, profile.getDefensiveStats());
    }
    @Test
    public void testGetSpecialRules(){
        ArrayList<SpecialRule> temp = new ArrayList<SpecialRule>();
        SpecialRule sr1 = new SpecialRule("Distracting", "descr");
        SpecialRule sr2 = new SpecialRule("Ambush", "descr");
        SpecialRule sr3 = new SpecialRule("Vanguard", "descr");

        temp.add(sr1);
        temp.add(sr2);
        temp.add(sr3);

        specialRules.add(sr1);
        specialRules.add(sr2);
        specialRules.add(sr3);

        assertEquals(temp, profile.getSpecialRules());
        }

}
