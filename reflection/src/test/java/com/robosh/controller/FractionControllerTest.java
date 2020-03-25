package com.robosh.controller;

import com.robosh.entity.Fraction;
import com.robosh.service.FractionService;
import com.robosh.view.FractionView;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class FractionControllerTest {
    @Mock
    private FractionService fractionService;
    @Mock
    private FractionView fractionView;

    private FractionController fractionController;

    @Test
    public void whenAddTwoNumbersCall_givenFractionController_thenShouldReturnFraction() {
        givenMockedDependencies();
        givenFractionController();
        whenOnAddTwoNumbersMethodInvoke();
        thenShouldReturnFraction();
    }

    @Test
    public void whenCreateAndShowFractionFromParametersCall_givenFractionController_thenShouldShowFraction() {
        givenMockedDependencies();
        givenFractionController();
        whenOnCreateAndShowFractionFromParameters();
        thenShouldShowFraction();
    }

    /**
     * GIVEN
     */

    private void givenMockedDependencies() {
        fractionService = mock(FractionService.class);
        fractionView = mock(FractionView.class);
    }

    private void givenFractionController() {
        fractionController = new FractionController(fractionService, fractionView);
    }

    /**
     * WHEN
     */

    private void whenOnAddTwoNumbersMethodInvoke() {
        when(fractionService.getFraction(1, 1)).thenReturn(new Fraction(1, 1));
        when(fractionService.sumFraction(new Fraction(1, 1), new Fraction(1, 1))).thenReturn(new Fraction(2, 2));
    }

    private void whenOnCreateAndShowFractionFromParameters() {
        when(fractionService.getFraction(1, 1)).thenReturn(new Fraction(1, 1));
        fractionController.createAndShowFractionFromParameters(1, 1);
    }

    /**
     * THEN
     */

    private void thenShouldReturnFraction() {
        val res = fractionController.addTwoFractions(1, 1, 1, 1);
        assertEquals(res, new Fraction(2, 2));
    }

    private void thenShouldShowFraction() {
        then(fractionView).should().showFraction(new Fraction(1, 1));
    }
}