package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testMultipleChoiceOptionSet {
    Weapon eq0 = new Weapon("Pala", "bum bum");
    SpecialRule eq1 = new SpecialRule("skrmish", "asdas");
    Entity eq2 = new Entity("plaszcz", "asd");
    Option option0 = new Option(eq0, 20);
    Option option1 = new Option(eq1, 50);
    Option option2 = new Option(eq2, 10);
    MultipleChoiceOptionSet optionSet = new MultipleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option0, option1, option2)));
    MultipleChoiceOptionSet optionSet1 = new MultipleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option0, option1, option2)), true);
    MultipleChoiceOptionSet optionSet2 = new MultipleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option0, option1, option2)), "Special Equipment", "get");
    MultipleChoiceOptionSet optionSet3 = new MultipleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option0, option1, option2)), "Wizard", "become", true);

    ArrayList<Integer> indexes = new ArrayList<>(Arrays.asList(0, 2));
    @Test
    void testGetEntity(){
        assertEquals( new ArrayList<Entity>(Arrays.asList(eq0, eq2)), optionSet.getEntities(indexes));
    }

    @Test
    void testGetCost(){
        assertEquals(30, optionSet.getCost(indexes));
    }

    @Test
    void testGetDescription(){
        assertEquals("May take:", optionSet.getDescription());
        assertEquals("Must take:", optionSet1.getDescription());
        assertEquals("May get Special Equipment:", optionSet2.getDescription());
        assertEquals("Must become Wizard:", optionSet3.getDescription());
    }

    @Test
    void testGetKeyVerb(){
        assertEquals("take", optionSet.getKeyVerb());
        assertEquals("take", optionSet1.getKeyVerb());
        assertEquals("get", optionSet2.getKeyVerb());
        assertEquals("become", optionSet3.getKeyVerb());
    }

    @Test
    void testGetItemListName(){
        assertEquals("", optionSet.getItemListName());
        assertEquals("", optionSet1.getItemListName());
        assertEquals("Special Equipment", optionSet2.getItemListName());
        assertEquals("Wizard", optionSet3.getItemListName());
    }
}
