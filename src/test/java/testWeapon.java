import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class testWeapon {
    Statistic str = new Statistic("Strength", "User");
    Statistic ap = new Statistic("Armour Piercing", "-");
    ArrayList<Statistic> stats = new ArrayList<>();
    Weapon weapon = new Weapon("CCW", "-", stats);

    @Test
    public void testGetName(){
        stats.add(str);
        stats.add(ap);
        assertEquals("CCW", weapon.getName());
    }
    @Test
    public void testGetDescription(){
        stats.add(str);
        stats.add(ap);
        Weapon weapon = new Weapon("CCW", "-", stats);
        assertEquals("-", weapon.getDescription());
    }
    @Test
    public void testGetStatisticsArray(){
        stats.add(str);
        stats.add(ap);
        Weapon weapon = new Weapon("CCW", "-", stats);

        Statistic str1 = new Statistic("Strength", "User");
        Statistic ap1 = new Statistic("Armour Piercing", "-");
        ArrayList<Statistic> temp = new ArrayList<>();
        temp.add(str);
        temp.add(ap);
        assertEquals(temp, weapon.getStatLine());
    }
}

