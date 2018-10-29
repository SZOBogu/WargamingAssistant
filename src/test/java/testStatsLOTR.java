import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testStatsLOTR {
    StatsLOTR stats = new StatsLOTR("4/5+","3","3","1","2","4");

    @Test
    public void testAddStatistic(){
        Statistic stat = new Statistic("asf", "rtr");
        ArrayList<Statistic> temp = stats.getStatline();
        int index = temp.size();
        stats.addStatistic(stat);
        assertEquals(stat, stats.getStatistic(index));
    }

    @Test
    public void testGetStatistic(){
        Statistic fight = new Statistic("F", "4/5+");
        Statistic str = new Statistic("S", "3");
        Statistic def = new Statistic("D", "3");
        Statistic att = new Statistic("A", "1");
        Statistic wound = new Statistic("W", "2");
        Statistic courage = new Statistic("C", "4");
        assertEquals(stats.getStatistic(0), fight);
        assertEquals(stats.getStatistic(1), str);
        assertEquals(stats.getStatistic(2), def);
        assertEquals(stats.getStatistic(3), att);
        assertEquals(stats.getStatistic(4), wound);
        assertEquals(stats.getStatistic(5), courage);
    }

    @Test
    public void testGetStatLine(){
        StatsLOTR temp = new StatsLOTR("4/5+","3","3","1","2","4");
        assertEquals(temp, stats);
    }
    @Test
    public void testToString(){
        assertEquals(stats.toString(), "F: 4/5+ S: 3 D: 3 A: 1 W: 2 C: 4 ");
    }
}