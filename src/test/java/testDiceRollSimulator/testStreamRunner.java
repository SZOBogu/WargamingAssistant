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
        String tempReport = new String();
        int successes = runner.runDiceRoll(toHit, 1);

        assertThat(runner.getReport().length(), greaterThan(tempReport.length()));
        assertThat(successes, lessThanOrEqualTo(toHit.getQuantity()));
    }

    @Test
    public void testRunAll(){
        String report = runner.runAll(testArray);
//        Pattern regex = Pattern.compile("TOTAL RESULT: " + "\\d+" + " SUCCESSES\n" + "\\d+" + " dices\n1.D6 roll on 5\\+\n2.D8 roll on 5- with reroll\n3.D8 roll on 5- with reroll of 1s\\." + "[\\s\\S]*");
//        assertThat(report, matchesPattern("TOTAL RESULT: " + "\\d+" + " SUCCESSES\n" + "\\d+" + " dices\n1.D6 roll on 5\\+\n2.D8 roll on 5- with reroll\n3.D8 roll on 5- with reroll of 1s\\." + "[\\s\\S]*"));
        assertThat(report, not(isEmptyString()));
    }
}
