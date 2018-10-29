import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class testWeapon {
    Weapon weapon = new Weapon("CCW", "-");

    @Test
    public void testGetName(){
        assertEquals("CCW", weapon.getName());
    }
    @Test
    public void testGetDescription(){
        Weapon weapon = new Weapon("CCW", "-");
        assertEquals("-", weapon.getDescription());
    }
}

