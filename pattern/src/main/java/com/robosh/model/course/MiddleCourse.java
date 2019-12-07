package com.robosh.model.course;

import com.robosh.model.lector.Lector;
import com.robosh.model.student.Observer;

import java.util.List;

public class MiddleCourse extends Course {
    public MiddleCourse(Lector lector, List<Observer> observers) {
        super(lector, observers);
    }

    @Override
    public String learnJava() {
        return "Learn Java basic. Learn Java Collection framework advanced. Learn java concurrency package.";
    }
}
