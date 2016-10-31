package ua.training.gamingjava;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 30.10.16.
 */
public class TestModel {

    private static final int PROPOSED_NUMBER = 10;
    private static final String LOWER_GUESSED_NUMBER = "5";
    private static final String GREATER_GUESSED_NUMBER = "15";
    private static final String EQUAL_GUESSED_NUMBER = "10";
    private static final String OUT_OF_RANGE_NUMBER = "200";
    private static final String INCORRECT_NUMBER = "100d";
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;

    private static Model game;

    @BeforeClass
    public static void initializeTester() {
        game = new Model();
    }

    @Before
    public void initializeGame() {
        game.initializeGame(MIN_NUMBER, MAX_NUMBER);
        game.setProposedNumber(PROPOSED_NUMBER);
    }

    @Test
    public void testGuessNumberWithLowerNumber() throws OutOfRangeException {
        StatusCode actualValue = game.guessNumber(LOWER_GUESSED_NUMBER);
        StatusCode expectedValue = StatusCode.NUMBER_IS_LOWER;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGuessNumberWithGreaterNumber() throws OutOfRangeException {
        StatusCode actualValue = game.guessNumber(GREATER_GUESSED_NUMBER);
        StatusCode expectedValue = StatusCode.NUMBER_IS_GREATER;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGuessNumberWithEqualNumber() throws OutOfRangeException {
        StatusCode actualNumber = game.guessNumber(EQUAL_GUESSED_NUMBER);
        StatusCode expectedNumber = StatusCode.NUMBERS_ARE_EQUAL;

        assertEquals(expectedNumber, actualNumber);
    }

    @Test(expected = OutOfRangeException.class)
    public void testGuessNumberWithOutOfRangeNumber() throws OutOfRangeException {
        game.guessNumber(OUT_OF_RANGE_NUMBER);
    }

    @Test(expected = NumberFormatException.class)
    public void testGuessNumberWithIncorrectNumber()
            throws NumberFormatException, OutOfRangeException {
        game.guessNumber(INCORRECT_NUMBER);
    }

}
