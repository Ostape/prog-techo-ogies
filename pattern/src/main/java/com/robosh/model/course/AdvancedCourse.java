package com.robosh.model.course;

import com.robosh.model.lector.Lector;
import com.robosh.model.student.Observer;

import java.util.List;

public class AdvancedCourse extends Course {
    public AdvancedCourse(Lector lector, List<Observer> observers) {
        super(lector, observers);
    }

    @Override
    public String learnJava() {
        return "Repeat Java basics. Learn Spring Framework: Spring MVC, Spring Security. Learn REST.";
    }
}
