import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class testWeapon {
    @Test
    void testGetName(){
        Statistic str = new Statistic("Strength", "User");
        Statistic ap = new Statistic("Armour Piercing", "-");
        ArrayList<Statistic> stats = new ArrayList<>();
        stats.add(str);
        stats.add(ap);
        Weapon weapon = new Weapon("CCW", "-", stats);
        assertEquals("CCW", weapon.getName());
    }
    @Test
    void testGetDescription(){
        Statistic str = new Statistic("Strength", "User");
        Statistic ap = new Statistic("Armour Piercing", "-");
        ArrayList<Statistic> stats = new ArrayList<>();
        stats.add(str);
        stats.add(ap);
        Weapon weapon = new Weapon("CCW", "-", stats);
        assertEquals("-", weapon.getDescription());
    }
    @Test
    void testGetStatisticsArray(){
        Statistic str = new Statistic("Strength", "User");
        Statistic ap = new Statistic("Armour Piercing", "-");
        ArrayList<Statistic> stats = new ArrayList<>();
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

