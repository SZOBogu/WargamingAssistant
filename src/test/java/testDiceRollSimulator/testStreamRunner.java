package testDiceRollSimulator;

import diceRollSimulator.DiceRoll;
import diceRollSimulator.StreamRunner;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.text.IsEmptyString.isEmptyString;
import static org.hamcrest.text.MatchesPattern.matchesPattern;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testStreamRunner {
    DiceRoll toHit = new DiceRoll(10, 5, false, false, 6);
    DiceRoll toWound = new DiceRoll(10, 5, true, true, 8);
    DiceRoll toSave = new DiceRoll(10, 5, true, true, 8, 1);
    ArrayList<DiceRoll> testArray = new ArrayList<>(Arrays.asList(toHit, toWound, toSave));
    StreamRunner runner = new StreamRunner();

    @Test
    public void testRunDiceRoll(){
        String tempReport = "";
        int successes = runner.runDiceRoll(toHit, 1);

        assertThat(runner.getReport().length(), greaterThan(tempReport.length()));
        assertThat(successes, lessThanOrEqualTo(toHit.getQuantity()));
    }

    //TODO:fix
    @Test
    public void testRunAll(){
        String report = runner.runAll(testArray);
        assertThat(report, not(isEmptyString()));
    }
}
