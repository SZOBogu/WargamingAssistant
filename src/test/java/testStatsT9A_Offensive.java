import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class testStatsT9A_Offensive {
    StatsT9A_Offensive stats = new StatsT9A_Offensive("3","5","4","1","5");

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
        Statistic attacks = new Statistic("Att", "3");
        Statistic offensive_skill = new Statistic("Off", "5");
        Statistic str = new Statistic("Str", "4");
        Statistic ap = new Statistic("AP", "1");
        Statistic agility = new Statistic("Agi", "5");
        assertEquals(stats.getStatistic(0), attacks);
        assertEquals(stats.getStatistic(1), offensive_skill);
        assertEquals(stats.getStatistic(2), str);
        assertEquals(stats.getStatistic(3), ap);
        assertEquals(stats.getStatistic(4), agility);
    }

    @Test
    public void testGetStatLine(){
        StatsT9A_Offensive temp = new StatsT9A_Offensive("3","5","4","1","5");
        assertEquals(temp, stats);
    }
    @Test
    public void testToString(){
        assertEquals(stats.toString(), "Att: 3 Off: 5 Str: 4 AP: 1 Agi: 5 ");
    }
}
