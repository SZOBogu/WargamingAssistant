import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class testStatsT9A_Defensive {
    StatsT9A_Defensive stats = new StatsT9A_Defensive("1","5","3","1");

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
        Statistic hp = new Statistic("HP", "1");
        Statistic defensive_skill = new Statistic("Def", "5");
        Statistic resilience = new Statistic("Res", "3");
        Statistic armour = new Statistic("Arm", "1");
        assertEquals(stats.getStatistic(0), hp);
        assertEquals(stats.getStatistic(1), defensive_skill);
        assertEquals(stats.getStatistic(2), resilience);
        assertEquals(stats.getStatistic(3), armour);
    }

    @Test
    public void testGetStatLine(){
        StatsT9A_Defensive temp = new StatsT9A_Defensive("1","5","3","1");
        assertEquals(temp, stats);
    }
    @Test
    public void testToString(){
        assertEquals(stats.toString(), "HP: 1 Def: 5 Res: 3 Arm: 1 ");
    }
}
