package com.robosh.service;

import com.robosh.entity.Fraction;

public class FractionService {
    private static FractionService instance = new FractionService();

    public static FractionService getInstance() {
        return instance;
    }

    public Fraction sumFraction(Fraction firstFraction, Fraction secondFraction) {
        int newNumerator = firstFraction.getNumerator() * secondFraction.getDenominator() +
                secondFraction.getNumerator() * firstFraction.getDenominator();
        int newDenominator = firstFraction.getDenominator() * secondFraction.getDenominator();
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction minusFraction(Fraction firstFraction, Fraction secondFraction) {
        int newNumerator = firstFraction.getNumerator() * secondFraction.getDenominator() -
                secondFraction.getNumerator() * firstFraction.getDenominator();
        int newDenominator = firstFraction.getDenominator() * secondFraction.getDenominator();
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiplyFraction(Fraction firstFraction, Fraction secondFraction) {
        int newNumerator = firstFraction.getNumerator() * secondFraction.getNumerator();
        int newDenominator = firstFraction.getDenominator() * secondFraction.getDenominator();
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divideFraction(Fraction firstFraction, Fraction secondFraction) {
        int newNumerator = firstFraction.getNumerator() * secondFraction.getDenominator();
        int newDenominator = firstFraction.getDenominator() * secondFraction.getNumerator();
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction getFraction(int numerator, int denominator) {
        return new Fraction(numerator, denominator);
    }
}
