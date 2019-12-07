package com.robosh.repository;

import com.robosh.model.lector.JavaLector;
import com.robosh.model.lector.Lector;
import com.robosh.model.lector.MiddleJavaLector;
import com.robosh.model.lector.SeniorJavaLector;

public class LectorRepository {
    public Lector getJavaLector() {
        return new JavaLector("Olha", "Petrovna");
    }

    public Lector getMiddleJavaLector() {
        return new MiddleJavaLector(new JavaLector("Dmitriy", "Viktorovich"));
    }

    public Lector getSeniorLector() {
        return new SeniorJavaLector(new MiddleJavaLector(new JavaLector("Andriy", "Petrovich")));
    }
}
