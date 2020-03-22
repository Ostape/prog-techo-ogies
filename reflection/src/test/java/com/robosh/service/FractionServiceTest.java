package com.robosh.service;

import com.robosh.entity.Fraction;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class FractionServiceTest {
    private FractionService fractionService = FractionService.getInstance();

    @Test
    public void shouldReturnCorrectValueWhenSumFraction() {
        Fraction firstFraction = new Fraction(5, 9);
        Fraction secondFraction = new Fraction(4, 7);
        Fraction expectedFraction = new Fraction(71, 63);
        Fraction actualFraction = fractionService.sumFraction(firstFraction, secondFraction);
        assertEquals(expectedFraction, actualFraction);
    }

    @Test
    public void shouldReturnIncorrectValueWhenSumFraction() {
        Fraction firstFraction = new Fraction(5, 9);
        Fraction secondFraction = new Fraction(4, 7);
        Fraction expectedFraction = new Fraction(4, 63);
        Fraction actualFraction = fractionService.sumFraction(firstFraction, secondFraction);
        assertNotEquals(expectedFraction, actualFraction);
    }

    @Test
    public void shouldReturnCorrectValueWhenMinusFraction() {
        Fraction firstFraction = new Fraction(12, 123);
        Fraction secondFraction = new Fraction(22, 3);
        Fraction expectedFraction = new Fraction(-2670, 369);
        Fraction actualFraction = fractionService.minusFraction(firstFraction, secondFraction);
        assertEquals(expectedFraction, actualFraction);
    }

    @Test
    public void shouldReturnIncorrectValueWhenMinusFraction() {
        Fraction firstFraction = new Fraction(5, 9);
        Fraction secondFraction = new Fraction(4, 7);
        Fraction expectedFraction = new Fraction(4, 63);
        Fraction actualFraction = fractionService.minusFraction(firstFraction, secondFraction);
        assertNotEquals(expectedFraction, actualFraction);
    }


    @Test
    public void shouldReturnCorrectValueWhenMultiplyFraction() {
        Fraction firstFraction = new Fraction(5, 9);
        Fraction secondFraction = new Fraction(4, 7);
        Fraction expectedFraction = new Fraction(20, 63);
        Fraction actualFraction = fractionService.multiplyFraction(firstFraction, secondFraction);
        assertEquals(expectedFraction, actualFraction);
    }

    @Test
    public void shouldReturnIncorrectValueWhenMultiplyFraction() {
        Fraction firstFraction = new Fraction(5, 9);
        Fraction secondFraction = new Fraction(4, 7);
        Fraction expectedFraction = new Fraction(4, 63);
        Fraction actualFraction = fractionService.multiplyFraction(firstFraction, secondFraction);
        assertNotEquals(expectedFraction, actualFraction);
    }

    @Test
    public void shouldReturnCorrectValueWhenDivideFraction() {
        Fraction firstFraction = new Fraction(5, 9);
        Fraction secondFraction = new Fraction(4, 7);
        Fraction expectedFraction = new Fraction(35, 36);
        Fraction actualFraction = fractionService.divideFraction(firstFraction, secondFraction);
        assertEquals(expectedFraction, actualFraction);
    }

    @Test
    public void shouldReturnIncorrectValueWhenDivideFraction() {
        Fraction firstFraction = new Fraction(5, 9);
        Fraction secondFraction = new Fraction(4, 7);
        Fraction expectedFraction = new Fraction(4, 63);
        Fraction actualFraction = fractionService.divideFraction(firstFraction, secondFraction);
        assertNotEquals(expectedFraction, actualFraction);
    }
}