package ua.training.gamingjava;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by vlad on 30.10.16.
 */
public class TestModel {

    private static final int OUT_OF_RANGE_NUMBER = 200;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;
    private static final int NUMBER_OF_ITERATIONS = 1000;

    private static Model model;

    @BeforeClass
    public static void initializeTester() {
        model = new Model();
    }

    @Before
    public void initializeGame() {
        model.setPrimaryBarrier(MIN_NUMBER, MAX_NUMBER);
        model.setSecretNumber();
    }

    @Test
    public void testSetSecretNumber() {
        boolean noGreaterOrLowerValues = true;
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            model.setSecretNumber();
            int secretNumber = model.getSecretNumber();
            if (secretNumber <= model.getMinBarrier() || secretNumber >= model.getMaxBarrier()) {
                noGreaterOrLowerValues = false;
                break;
            }
        }

        assertTrue(noGreaterOrLowerValues);
    }

    @Test
    public void testCompareValueWithOutOfRangeValue() {
        assertFalse(model.checkValue(OUT_OF_RANGE_NUMBER));
    }

    @Test
    public void testCompareValueWithLoverValue() {
        int secretNumber = model.getSecretNumber();
        //generate pseudo random number in range from minBarrier (exclusive)
        //to secretNumber (exclusive)
        int lowerValue = (int) (model.getMinBarrier() + 1
                + Math.random() * (secretNumber - model.getMinBarrier() - 1));
        assertFalse(model.checkValue(lowerValue));
    }

    @Test
    public void testCompareValueWithGreaterValue() {
        int secretNumber = model.getSecretNumber();
        //generate pseudo random number in range from secretNumber (exclusive)
        //to maxBarrier (exclusive)
        int greaterValue = (int) (secretNumber + 1
                + Math.random() * (model.getMaxBarrier() - secretNumber - 1));
        assertFalse(model.checkValue(greaterValue));
    }

    @Test
    public void testCompareValueWithEqualValue() {
        int secretNumber = model.getSecretNumber();
        assertTrue(model.checkValue(secretNumber));
    }


}
