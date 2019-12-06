package com.robosh;

import com.robosh.model.entity.lector.JavaLector;
import com.robosh.model.entity.lector.Lector;
import com.robosh.model.entity.lector.MiddleJavaLector;

public class Main {
    public static void main(String[] args) {
        Lector lector = new MiddleJavaLector(new JavaLector());
        System.out.println(lector.giveLecture());
    }
}
