import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testStatsBB extends Statline{
    StatsBB stats = new StatsBB("6","3","3","8");

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
        Statistic ma = new Statistic("MA", "6");
        Statistic str = new Statistic("STR", "3");
        Statistic agi = new Statistic("AGI", "3");
        Statistic av = new Statistic("AV", "8");
        assertEquals(stats.getStatistic(0), ma);
        assertEquals(stats.getStatistic(1), str);
        assertEquals(stats.getStatistic(2), agi);
        assertEquals(stats.getStatistic(3), av);
    }

    @Test
    public void testGetStatLine(){
        StatsBB temp = new StatsBB("6","3","3","8");
        assertEquals(temp, stats);
    }
    @Test
    public void testToString(){
        assertEquals(stats.toString(), "MA: 6 STR: 3 AGI: 3 AV: 8 ");
    }

}
