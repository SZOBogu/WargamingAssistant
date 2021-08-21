package testDiceRollSimulator;

import diceRollSimulator.utility.DiceRoll;
import diceRollSimulator.pojos.StreamRunner;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testStreamRunner {
    DiceRoll toHit = new DiceRoll.DiceRollBuilder(10, 5).build();
    DiceRoll toWound = new DiceRoll.DiceRollBuilder(10, 5).reroll(true).failures(true).diceSides(8).build();
    DiceRoll toSave = new DiceRoll.DiceRollBuilder(10, 5).reroll(true).failures(true).diceSides(8).valueToReRoll(1).build();

    ArrayList<DiceRoll> testArray = new ArrayList<>(Arrays.asList(toHit, toWound, toSave));
    StreamRunner runner = new StreamRunner();

    @Test
    public void testRunDiceRoll(){
        int successes = runner.runDiceRoll(toHit, 1);

        assertThat(runner.getReport().length(), greaterThan(0));
        assertThat(successes, lessThanOrEqualTo(toHit.getQuantity()));
    }

    //TODO:fix
    @Test
    public void testRunAll(){
        String report = runner.runAll(testArray);
        assertTrue(report.length() > 0);
    }
}
