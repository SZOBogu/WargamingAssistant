package testDiceRollSimulator;

import diceRollSimulator.DiceRoll;
import diceRollSimulator.ReportGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testReportGenerator {
        ReportGenerator generator = new ReportGenerator();
        ArrayList<ArrayList<Integer>> results1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> results11 = new ArrayList<>(Arrays.asList(4,1,4,3,6,3,4,2,2,5,4,3,2,5,1,4,3,3,5,2));   //3+
        ArrayList<ArrayList<Integer>> results2 = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> results2notRR = new ArrayList(Arrays.asList(1,4,1,2,3,4,6,1,1,5,1,2,6,6));                  //5+ rr 1
        ArrayList<Integer> results2RR = new ArrayList(Arrays.asList(6,4,4,2,3,4,6,5,5,5,2,2,6,6));                  //5+ rr 1
        ArrayList<ArrayList<Integer>> results3 = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> results3notRR = new ArrayList(Arrays.asList(5,2,4,3,1,5,6));                  //3- rr
        ArrayList<Integer> results3RR = new ArrayList(Arrays.asList(5,6,4,3,5,5,6));                  //3- rr

        ArrayList<DiceRoll> diceRolls = new ArrayList<>();
        DiceRoll diceRoll1 = new DiceRoll(20, 3, false, false, 6);
        DiceRoll diceRoll2 = new DiceRoll(10, 5, true, true, 6);
        DiceRoll diceRoll3 = new DiceRoll(5, 4, true, false, 6, 6);

        @Test
        void testAddDiceRoll(){
                results1.add(results11);
                results2.add(results2notRR);
                results2.add(results2RR);
                results3.add(results3notRR);
                results3.add(results3RR);

                generator.addDiceRoll(results1, 1, 14, 3, false);
                assertEquals("Dice Roll 1: 14 successes (3+). Results:\n4 1 4 3 6 3 4 2 2 5 4 3 2 5 1 4 3 3 5 2 \n", generator.getReport());
                generator.addDiceRoll(results2, 2, 5, 5, false, 1);
                assertEquals("Dice Roll 1: 14 successes (3+). Results:\n4 1 4 3 6 3 4 2 2 5 4 3 2 5 1 4 3 3 5 2 \n" +
                        "Dice Roll 2: 5 successes (5+ with 1s rerolled). Results non rerolled:\n1 4 1 2 3 4 6 1 1 5 1 2 6 6 \n"+
                        "Dice Roll 2: 5 successes (5+ with 1s rerolled). Results rerolled:\n6 4 4 2 3 4 6 5 5 5 2 2 6 6 \n", generator.getReport());
                generator.addDiceRoll(results3, 3, 0, 3, false, -1);
                assertEquals("Dice Roll 1: 14 successes (3+). Results:\n4 1 4 3 6 3 4 2 2 5 4 3 2 5 1 4 3 3 5 2 \n" +
                        "Dice Roll 2: 5 successes (5+ with 1s rerolled). Results non rerolled:\n1 4 1 2 3 4 6 1 1 5 1 2 6 6 \n"+
                        "Dice Roll 2: 5 successes (5+ with 1s rerolled). Results rerolled:\n6 4 4 2 3 4 6 5 5 5 2 2 6 6 \n" +
                        "Dice Roll 3: 0 successes (3+ rerolled). Results non rerolled:\n5 2 4 3 1 5 6 \n" +
                        "Dice Roll 3: 0 successes (3+ rerolled). Results rerolled:\n5 6 4 3 5 5 6 \n", generator.getReport()
                );
        }
        @Test
        void testGenerateReport(){
            generator.setReport("test");

            diceRolls.add(diceRoll1);
            diceRolls.add(diceRoll2);
            diceRolls.add(diceRoll3);

            assertEquals("TOTAL RESULT: 3 SUCCESSES" +
                    "\n" + diceRoll1.getQuantity() + " dices\n"
                    + "1." + diceRoll1.toString() + "\n"
                    + "2." + diceRoll2.toString() + "\n"
                    + "3." + diceRoll3.toString() + "\ntest"
                    , generator.generateReport(diceRolls, 3)
            );
        }
    }