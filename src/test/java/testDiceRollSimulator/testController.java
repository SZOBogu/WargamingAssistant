package testDiceRollSimulator;

import diceRollSimulator.DiceRoll;
import diceRollSimulator.Controller;
import diceRollSimulator.FormEvent;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.text.IsEmptyString.isEmptyString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testController {
    Controller controller = new Controller();
    DiceRoll testRoll0 = new DiceRoll(10, 5, false, false, 6);
    FormEvent formObject0 = new FormEvent(new Object(), testRoll0);
    DiceRoll testRoll1 = new DiceRoll(40, 3, false, false, 6);
    FormEvent formObject1 = new FormEvent(new Object(), testRoll1);
    DiceRoll testRoll2 = new DiceRoll(50, 4, false, false, 6);
    FormEvent formObject2 = new FormEvent(new Object(), testRoll2);

    @Test
    void testGetDiceRolls(){
        assertEquals(controller.getDiceRolls().size(), 0);
    }

    @Test
    void testAddDiceRoll(){
        assertEquals(controller.getDiceRolls().size(), 0);
        controller.addDiceRoll(formObject0);
        assertEquals(controller.getDiceRolls().size(), 1);
        controller.addDiceRoll(formObject1);
        assertEquals(controller.getDiceRolls().size(), 2);
        controller.addDiceRoll(formObject2);
        assertEquals(controller.getDiceRolls().size(), 3);
    }

    @Test
    void testRemoveDiceRoll(){
        controller.addDiceRoll(formObject0);
        controller.addDiceRoll(formObject1);
        controller.addDiceRoll(formObject2);

        assertEquals(controller.getDiceRolls().size(), 3);
        controller.removeDiceRoll(1);
        assertEquals(controller.getDiceRolls().size(), 2);

        //assertEquals(controller.getDiceRolls().get(0), testRoll0);
        assertEquals(controller.getDiceRolls().get(1), testRoll2);
    }

    @Test
    void testClear(){
        controller.addDiceRoll(formObject0);
        controller.addDiceRoll(formObject1);
        controller.addDiceRoll(formObject2);

        assertEquals(controller.getDiceRolls().size(), 3);
        controller.clear();
        assertEquals(controller.getDiceRolls().size(), 0);
    }

    @Test
    void testRun(){
       String report = controller.run();
       assertThat(report, not(isEmptyString()));
    }

    @Test
    void testRunNonRandom(){
        String report = controller.runNonRandom();
        assertThat(report, not(isEmptyString()));
    }
}
