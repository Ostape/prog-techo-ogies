package com.robosh.entity;


public class NumberWithFraction extends NumberDecorator {
    private int intNumber;

    public NumberWithFraction(Number number, int intNumber) {
        super(number);
        this.intNumber = intNumber;
    }

    @Override
    public String showNumber() {
        return intNumber + "|" + super.showNumber();
    }

    public int getIntNumber() {
        return intNumber;
    }
}
