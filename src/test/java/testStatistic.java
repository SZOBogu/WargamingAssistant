import org.junit.Test;

import static org.junit.Assert.assertEquals;

class testStatistic {

    Statistic stat = new Statistic("Strength", "2D6");

    @Test
    public void testGetName() {
        assertEquals("Strength", stat.getName());
    }

    @Test
    public void testGetValue() {
        assertEquals("2D6", stat.getValue());
    }

    @Test
    public void testToString() {
        assertEquals("Strength: 2D6", stat.toString());
    }
}
