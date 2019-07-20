package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testSingleChoiceOptionSet {
    Option option0 = new Option(new Weapon("Pala", "bum bum"), 20);
    Option option1 = new Option(new SpecialRule("skrmish", "asdas"), 50);
    Option option2 = new Option(new Entity("plaszcz", "asd"), 10);
    SingleChoiceOptionSet optionSet0 = new SingleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option0, option1, option2)));
    SingleChoiceOptionSet optionSet1 = new SingleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option0, option1, option2)), true);
    SingleChoiceOptionSet optionSet2 = new SingleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option0, option1, option2)), "Special Equipment", "get");
    SingleChoiceOptionSet optionSet3 = new SingleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option0, option1, option2)), "Wizard", "become", true);

    @Test
    void testGetEntity(){
        assertTrue(option0.getEntity().equals(optionSet0.getEntity(0)));
        assertTrue(option1.getEntity().equals(optionSet0.getEntity(1)));
        assertTrue(option2.getEntity().equals(optionSet0.getEntity(2)));
    }

    @Test
    void testGetCost(){
        assertEquals(20, optionSet0.getCost(0));
        assertEquals(50, optionSet0.getCost(1));
        assertEquals(10, optionSet0.getCost(2));
    }

    @Test
    void testGetDescription(){
        assertEquals("May take (one choice only):", optionSet0.getDescription());
        assertEquals("Must take (one choice only):", optionSet1.getDescription());
        assertEquals("May get Special Equipment (one choice only):", optionSet2.getDescription());
        assertEquals("Must become Wizard (one choice only):", optionSet3.getDescription());
    }

    @Test
    void testGetOptions(){
        assertEquals(option0, optionSet0.getOptions().get(0));
        assertEquals(option1, optionSet0.getOptions().get(1));
        assertEquals(option2, optionSet0.getOptions().get(2));
    }

    @Test
    void testGetKeyVerb(){
        assertEquals("take", optionSet0.getKeyVerb());
        assertEquals("take", optionSet1.getKeyVerb());
        assertEquals("get", optionSet2.getKeyVerb());
        assertEquals("become", optionSet3.getKeyVerb());
    }

    @Test
    void testGetItemListName(){
        assertEquals("", optionSet0.getItemListName());
        assertEquals("", optionSet1.getItemListName());
        assertEquals("Special Equipment", optionSet2.getItemListName());
        assertEquals("Wizard", optionSet3.getItemListName());
    }
}
