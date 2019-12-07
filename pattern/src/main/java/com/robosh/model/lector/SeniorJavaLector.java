package com.robosh.model.lector;

public class SeniorJavaLector extends LectorDecorator {
    public SeniorJavaLector(Lector lector) {
        super(lector);
    }

    public String makeCodeReview() {
        return "Making code review. ";
    }

    @Override
    public String giveLecture() {
        return super.giveLecture() + makeCodeReview();
    }
}
