import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testStats40kWeapon extends Statline{
    Stats40kWeapon stats = new Stats40kWeapon("24\"", "Rapid Fire 1", "*", "-", "1");

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
        Statistic range = new Statistic("Range", "24\"");
        Statistic type = new Statistic("Type", "Rapid Fire 1");
        Statistic str = new Statistic("S", "*");
        Statistic ap = new Statistic("AP", "-");
        Statistic dmg = new Statistic("D", "1");
        assertEquals(stats.getStatistic(0), range);
        assertEquals(stats.getStatistic(1), type);
        assertEquals(stats.getStatistic(2), str);
        assertEquals(stats.getStatistic(3), ap);
        assertEquals(stats.getStatistic(4), dmg);
    }

    @Test
    public void testGetStatLine(){
        Stats40kWeapon temp = new Stats40kWeapon("24\"", "Rapid Fire 1", "*", "-", "1");
        assertEquals(temp, stats);
    }
    @Test
    public void testToString(){
        assertEquals(stats.toString(), "Range\tType\tS\tAP\tD\t\n24\"\tRapid Fire 1\t*\t-\t1\t");
    }
}
