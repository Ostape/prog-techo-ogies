package com.robosh.model.entity.lector;

public class MiddleJavaLector extends LectorDecorator {

    public MiddleJavaLector(Lector lector) {
        super(lector);
    }

    public String makeKnowledgeReview() {
        return "Asking student about java theory ";
    }

    @Override
    public String giveLecture() {
        return super.giveLecture() + makeKnowledgeReview();
    }
}
