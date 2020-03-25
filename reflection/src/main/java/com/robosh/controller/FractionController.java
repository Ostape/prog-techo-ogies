package com.robosh.controller;

import com.robosh.entity.Fraction;
import com.robosh.service.FractionService;
import com.robosh.view.FractionView;

public class FractionController {
    private FractionService fractionService;
    private FractionView fractionView;

    public FractionController(FractionService fractionService, FractionView fractionView) {
        this.fractionService = fractionService;
        this.fractionView = fractionView;
    }

    public Fraction addTwoFractions(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator) {
        Fraction firstFraction = fractionService.getFraction(firstNumerator, firstDenominator);
        Fraction secondFraction = fractionService.getFraction(secondNumerator, secondDenominator);
        return fractionService.sumFraction(firstFraction, secondFraction);
    }

    public void createAndShowFractionFromParameters(int numerator, int denominator) {
        fractionView.showFraction(fractionService.getFraction(numerator, denominator));
    }
}
