package testDiceRollSimulator;

import diceRollSimulator.utility.DiceRoll;
import diceRollSimulator.pojos.NonRandomReportGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testNonRandomReportGenerator {
    ArrayList<DiceRoll> diceRolls = new ArrayList<>();
    DiceRoll diceRoll1 = new DiceRoll.DiceRollBuilder(20, 3).build();
    DiceRoll diceRoll2 = new DiceRoll.DiceRollBuilder(12, 5).reroll(true).failures(true).build();
    DiceRoll diceRoll3 = new DiceRoll.DiceRollBuilder(5, 4).valueToReRoll(6).build();

    @Test
    void testAddDiceRolls(){
        diceRolls.add(diceRoll1);
        diceRolls.add(diceRoll2);
        diceRolls.add(diceRoll3);

        assertEquals("TOTAL RESULT: 2.3045267489711936 SUCCESSES\n" +
        "20 dices\n" +
        "1.D6 roll on 3+\n" +
        "2.D6 roll on 5- with reroll\n" +
        "3.D6 roll on 4+ with reroll of 6s\n" +
        "common.Dice Roll 1: probability of single dice success: 0.6666666666666666\n" +
        "common.Dice Roll 2: probability of single dice success: 0.4444444444444444\n" +
        "common.Dice Roll 3: probability of single dice success: 0.38888888888888895\n" +
        "Probability of Total Success: 0.11522633744855969",
        NonRandomReportGenerator.generateReport(diceRolls));
    }
}
