import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testStats40k {
    Stats40k stats = new Stats40k("7\"","3+","3+","3","3","1",
            "1","7","5+");

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
        Statistic movement = new Statistic("M", "7\"");
        Statistic weapon_skill = new Statistic("WS", "3+");
        Statistic ballistic_skill = new Statistic("BS", "3+");
        Statistic str = new Statistic("S", "3");
        Statistic toughness = new Statistic("T", "3");
        Statistic wounds = new Statistic("W", "1");
        Statistic attacks = new Statistic("A", "1");
        Statistic leadership = new Statistic("Ld", "7");
        Statistic armour_save = new Statistic("Sv", "5+");
        assertEquals(stats.getStatistic(0), movement);
        assertEquals(stats.getStatistic(1), weapon_skill);
        assertEquals(stats.getStatistic(2), ballistic_skill);
        assertEquals(stats.getStatistic(3), str);
        assertEquals(stats.getStatistic(4), toughness);
        assertEquals(stats.getStatistic(5), wounds);
        assertEquals(stats.getStatistic(6), attacks);
        assertEquals(stats.getStatistic(7), leadership);
        assertEquals(stats.getStatistic(8), armour_save);
    }

    @Test
    public void testGetStatLine(){
        Stats40k temp = new Stats40k("7\"","3+","3+","3","3","1","1","7","5+");
        assertEquals(temp, stats);
    }
    @Test
    public void testToString(){
        assertEquals(stats.toString(), "M: 7\" WS: 3+ BS: 3+ S: 3 T: 3 W: 1 A: 1 Ld: 7 Sv: 5+ ");
    }
}
