package com.robosh;

import com.robosh.model.lector.JavaLector;
import com.robosh.model.lector.Lector;
import com.robosh.model.lector.MiddleJavaLector;

public class Main {
    public static void main(String[] args) {
        Lector lector = new MiddleJavaLector(new JavaLector("Petro", "Pushkin"));
        System.out.println(lector.giveLecture());
    }
}
