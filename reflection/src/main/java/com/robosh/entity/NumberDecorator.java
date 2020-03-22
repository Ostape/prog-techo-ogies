package com.robosh.entity;

public class NumberDecorator implements Number {
    private Number number;

    public NumberDecorator(Number number) {
        this.number = number;
    }

    @Override
    public String showNumber() {
        return number.showNumber();
    }
}
