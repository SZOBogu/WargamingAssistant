package testDiceRollSimulator;

import diceRollSimulator.DiceRoll;
import diceRollSimulator.ProbabilityCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testProbabilityCalculator {
    ProbabilityCalculator calculator = new ProbabilityCalculator();
    DiceRoll testRoll0 = new DiceRoll(10, 6, false, false, 6);
    DiceRoll testRoll1 = new DiceRoll(40, 5, true, false, 6);
    DiceRoll testRoll2 = new DiceRoll(50, 4, false, false, 6, 1);
    DiceRoll testRoll3 = new DiceRoll(40, 3, true, true, 6 );
    DiceRoll testRoll4 = new DiceRoll(50, 2, false, true, 6, 6);

    DiceRoll testRoll10 = new DiceRoll(10, 6, false, false, 11);
    DiceRoll testRoll11 = new DiceRoll(40, 5, true, false, 11);
    DiceRoll testRoll12 = new DiceRoll(50, 4, false, false, 11, 1);
    DiceRoll testRoll13 = new DiceRoll(40, 3, true, true, 11);
    DiceRoll testRoll14 = new DiceRoll(50, 2, false, true, 11, 6);

    @Test
    void testCalculateChanceOfNonRerolledSuccess(){
        assertEquals(1./6, calculator.calculateChanceOfNonRerolledSuccess(testRoll0));
        assertEquals(2./6, calculator.calculateChanceOfNonRerolledSuccess(testRoll1));
        assertEquals(3./6, calculator.calculateChanceOfNonRerolledSuccess(testRoll2));
        assertEquals(4./6, calculator.calculateChanceOfNonRerolledSuccess(testRoll3));
        assertEquals(5./6, calculator.calculateChanceOfNonRerolledSuccess(testRoll4));

        assertEquals(6./11, calculator.calculateChanceOfNonRerolledSuccess(testRoll10));
        assertEquals(7./11, calculator.calculateChanceOfNonRerolledSuccess(testRoll11));
        assertEquals(8./11, calculator.calculateChanceOfNonRerolledSuccess(testRoll12));
        assertEquals(9./11, calculator.calculateChanceOfNonRerolledSuccess(testRoll13));
        assertEquals(10./11, calculator.calculateChanceOfNonRerolledSuccess(testRoll14));
    }

    @Test
    void testCalculateChanceOfRerolledSuccess(){
        assertEquals(1./6 + (1 - 1./6) * 1./6, calculator.calculateChanceOfRerolledSuccess(testRoll0));
        assertEquals(2./6 + (1 - 2./6) * 2./6, calculator.calculateChanceOfRerolledSuccess(testRoll1));
        assertEquals(3./6 + (1 - 3./6) * 3./6, calculator.calculateChanceOfRerolledSuccess(testRoll2));
        assertEquals(4./6 + (1 - 4./6) * 4./6, calculator.calculateChanceOfRerolledSuccess(testRoll3));
        assertEquals(5./6 + (1 - 5./6) * 5./6, calculator.calculateChanceOfRerolledSuccess(testRoll4));

        assertEquals(6./11 + (1 - 6./11) * 6./11, calculator.calculateChanceOfRerolledSuccess(testRoll10));
        assertEquals(7./11 + (1 - 7./11) * 7./11, calculator.calculateChanceOfRerolledSuccess(testRoll11));
        assertEquals(8./11 + (1 - 8./11) * 8./11, calculator.calculateChanceOfRerolledSuccess(testRoll12));
        assertEquals(9./11 + (1 - 9./11) * 9./11, calculator.calculateChanceOfRerolledSuccess(testRoll13));
        assertEquals(10./11 + (1 - 10./11) * 10./11, calculator.calculateChanceOfRerolledSuccess(testRoll14));
    }

    @Test
    void testCalculateChanceOfSuccessAfterFavourableSingleValueReRoll(){
        assertEquals(1./6 + ((1 - 1./6) * 1./6) * 1./6, calculator.calculateChanceOfSuccessAfterFavourableSingleValueReRoll(testRoll0));
        assertEquals(2./6 + ((1 - 2./6) * 1./6) * 2./6, calculator.calculateChanceOfSuccessAfterFavourableSingleValueReRoll(testRoll1));
        assertEquals(3./6 + ((1 - 3./6) * 1./6) * 3./6, calculator.calculateChanceOfSuccessAfterFavourableSingleValueReRoll(testRoll2));
        assertEquals(4./6 + ((1 - 4./6) * 1./6) * 4./6, calculator.calculateChanceOfSuccessAfterFavourableSingleValueReRoll(testRoll3));
        assertEquals(5./6 + ((1 - 5./6) * 1./6) * 5./6, calculator.calculateChanceOfSuccessAfterFavourableSingleValueReRoll(testRoll4));

        assertEquals(6./11 + ((1 - 6./11) * 1./11) * 6./11, calculator.calculateChanceOfSuccessAfterFavourableSingleValueReRoll(testRoll10));
        assertEquals(7./11 + ((1 - 7./11) * 1./11) * 7./11, calculator.calculateChanceOfSuccessAfterFavourableSingleValueReRoll(testRoll11));
        assertEquals(8./11 + ((1 - 8./11) * 1./11) * 8./11, calculator.calculateChanceOfSuccessAfterFavourableSingleValueReRoll(testRoll12));
        assertEquals(9./11 + ((1 - 9./11) * 1./11) * 9./11, calculator.calculateChanceOfSuccessAfterFavourableSingleValueReRoll(testRoll13));
        assertEquals(10./11 + ((1 - 10./11) * 1./11) * 10./11, calculator.calculateChanceOfSuccessAfterFavourableSingleValueReRoll(testRoll14));
    }

    @Test
    void testCalculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(){
        assertEquals((1./6 - 1./6) + (((1 - (1./6 - 1./6)) * 1./6) * 1./6), calculator.calculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(testRoll0));
        assertEquals((2./6 - 1./6) + (((1 - (2./6 - 1./6)) * 1./6) * 2./6), calculator.calculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(testRoll1));
        assertEquals((3./6 - 1./6) + (((1 - (3./6 - 1./6)) * 1./6) * 3./6), calculator.calculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(testRoll2));
        assertEquals((4./6 - 1./6) + (((1 - (4./6 - 1./6)) * 1./6) * 4./6), calculator.calculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(testRoll3));
        assertEquals((5./6 - 1./6) + (((1 - (5./6 - 1./6)) * 1./6) * 5./6), calculator.calculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(testRoll4));

        assertEquals((6./11 - 1./11) + (((1 - (6./11 - 1./11)) * 1./11) * 6./11), calculator.calculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(testRoll10));
        assertEquals((7./11 - 1./11) + (((1 - (7./11 - 1./11)) * 1./11) * 7./11), calculator.calculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(testRoll11));
        assertEquals((8./11 - 1./11) + (((1 - (8./11 - 1./11)) * 1./11) * 8./11), calculator.calculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(testRoll12));
        assertEquals((9./11 - 1./11) + (((1 - (9./11 - 1./11)) * 1./11) * 9./11), calculator.calculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(testRoll13));
        assertEquals((10./11 - 1./11) + (((1 - (10./11 - 1./11)) * 1./11) * 10./11), calculator.calculateChanceOfSuccessAfterNonFavourableSingleValueReRoll(testRoll14));
    }

    @Test
    void testCaluculateProbaility(){
        assertEquals(1./6, calculator.calculateProbability(testRoll0));                                     //6+
        assertEquals(1./3 + (1 - 1./3) * 1./3, calculator.calculateProbability(testRoll1));                 //5+ z re rollem
        assertEquals((1./2) + ((1 - 1./2) * 1./6) * 1./2, calculator.calculateProbability(testRoll2));       //4+ z re rollem gał
        assertEquals(1. - (2./3 + (1. - 2./3) * 2./3), calculator.calculateProbability(testRoll3));          //3- z re rollem
        assertEquals(1. - ((5./6 - 1./6) + ((1 - (5./6 - 1./6)) * 1./6) * 5./6), calculator.calculateProbability(testRoll4));                      //2- z re rollem 6tek

    }

}
