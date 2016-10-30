package ua.training.gamingjava;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vlad on 30.10.16.
 */
public class TestNumberGuessingGame {

    private static final int PROPOSED_NUMBER = 10;
    private static final int LOWER_GUESSED_NUMBER = 5;
    private static final int GREATER_GUESSED_NUMBER = 15;
    private static final int EQUAL_GUESSED_NUMBER = 10;
    private static final int OUT_OF_RANGE_NUMBER = 200;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;

    private static CheatedNumberGuessingGame game;

    @BeforeClass
    public static void initializeTester() {
        game = new CheatedNumberGuessingGame();
    }

    @Before
    public void initializeGame() {
        game.initializeGame(MIN_NUMBER, MAX_NUMBER);
        game.setProposedNumber(PROPOSED_NUMBER);
    }

    @Test
    public void testProposeNumber() {
        int proposedNumber = game.getProposedNumber();

        assertTrue(proposedNumber >= MIN_NUMBER && proposedNumber <= MAX_NUMBER);
    }

    @Test
    public void testMakeGuessWithLowerNumber() {
        int actualValue = game.makeGuess(LOWER_GUESSED_NUMBER);
        int expectedValue = -1;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testMakeGuessWithGreaterNumber() {
        int actualValue = game.makeGuess(GREATER_GUESSED_NUMBER);
        int expectedValue = 1;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testMakeGuessWithEqualNumber() {
        int actualNumber = game.makeGuess(EQUAL_GUESSED_NUMBER);
        int expectedNumber = 0;

        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void testMakeGuessWithOutOfRangeNumber() {
        int actualNumber = game.makeGuess(OUT_OF_RANGE_NUMBER);
        int expectedNumber = 2;

        assertEquals(expectedNumber, actualNumber);
    }

    @Ignore
    @Test
    public void testMakeGuessUsingBinarySearch() {

    }

    @Test
    public void testGetRange() {
        int[] actualRange = game.getRange();
        int[] expectedRange = new int[] {MIN_NUMBER, MAX_NUMBER};
        assertArrayEquals(expectedRange, actualRange);
    }

    @Test
    public void testGetGuesses() {
        game.makeGuess(LOWER_GUESSED_NUMBER);
        game.makeGuess(GREATER_GUESSED_NUMBER);
        game.makeGuess(EQUAL_GUESSED_NUMBER);
        List<Integer> actualGuesses = game.getGuesses();

        List<Integer> expectedGuesses = new ArrayList<>();
        expectedGuesses.add(LOWER_GUESSED_NUMBER);
        expectedGuesses.add(GREATER_GUESSED_NUMBER);
        expectedGuesses.add(EQUAL_GUESSED_NUMBER);

        assertEquals(expectedGuesses, actualGuesses);
    }
}
