import org.junit.Test;

import static org.junit.Assert.assertEquals;

class testStatistic {
    @Test
    void testGetName() {
        Statistic stat = new Statistic("Strength", "2D6");
        assertEquals("Strength", stat.getName());
    }

    @Test
    void testGetValue() {
        Statistic stat = new Statistic("Strength", "2D6");
        assertEquals("2D6", stat.getValue());
    }

    @Test
    void testToString() {
        Statistic stat = new Statistic("Strength", "2D6");
        assertEquals("Strength: 2D6", stat.toString());
    }
}
