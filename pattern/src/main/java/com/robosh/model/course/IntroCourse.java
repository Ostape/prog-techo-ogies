package com.robosh.model.course;

import com.robosh.model.lector.Lector;
import com.robosh.model.student.Observer;

import java.util.List;

public class IntroCourse extends Course {
    public IntroCourse(Lector lector, List<Observer> observers) {
        super(lector, observers);
    }

    @Override
    public String learnJava() {
        return "Learn Java Basic";
    }
}
