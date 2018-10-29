import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testStatsT9A_Global {
    StatsT9A_Global stats = new StatsT9A_Global("10\"","20\"","7");

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
        Statistic advance = new Statistic("Adv", "10\"");
        Statistic march = new Statistic("Mar", "20\"");
        Statistic discipline = new Statistic("Dis", "7");

        assertEquals(stats.getStatistic(0), advance);
        assertEquals(stats.getStatistic(1), march);
        assertEquals(stats.getStatistic(2), discipline);
    }

    @Test
    public void testGetStatLine(){
        StatsT9A_Global temp = new StatsT9A_Global("10\"","20\"","7");
        assertEquals(temp, stats);
    }
    @Test
    public void testToString(){
        assertEquals(stats.toString(), "Adv: 10\" Mar: 20\" Dis: 7 ");
    }
}
