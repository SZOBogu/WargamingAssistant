import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testStatline {
    Statistic str = new Statistic("Strength", "User");
    Statistic ap = new Statistic("Armour Piercing", "-");
    Statline stats = new Statline();

    @Test
    public void testAddStatistic(){
        stats.addStatistic(str);
        assertEquals(str, stats.getStatistic(0));
    }

    @Test
    public void testGetStatistic(){
        stats.addStatistic(str);
        stats.addStatistic(ap);
        Statistic str1 = new Statistic("Strength", "User");
        Statistic ap1 = new Statistic("Armour Piercing", "-");
        assertEquals(stats.getStatistic(0), str1);
        assertEquals(stats.getStatistic(1), ap1);
    }

    @Test
    public void testGetStatLine(){
        stats.addStatistic(str);
        stats.addStatistic(ap);
        Statline stats1 = new Statline();
        Statistic str1 = new Statistic("Strength", "User");
        Statistic ap1 = new Statistic("Armour Piercing", "-");
        stats1.addStatistic(str1);          //i may have screwed up,
        stats1.addStatistic(ap1);
        assertEquals(stats, stats1);
    }
    @Test
    public void testToString(){
        stats.addStatistic(str);
        stats.addStatistic(ap);
        assertEquals(stats.toString(), "Strength: User Armour Piercing: - ");
    }
}
