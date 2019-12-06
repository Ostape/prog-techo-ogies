package com.robosh.model.entity.lector;

public class LectorDecorator implements Lector {
    private Lector lector;

    public LectorDecorator(Lector lector) {
        this.lector = lector;
    }

    @Override
    public String giveLecture() {
        return lector.giveLecture();
    }
}
