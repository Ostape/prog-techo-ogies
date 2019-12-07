package com.robosh.model.course;

import com.robosh.model.lector.Lector;
import com.robosh.model.student.Observable;
import com.robosh.model.student.Observer;
import lombok.Data;

import java.util.List;

@Data
public abstract class Course implements Observable {
    private Lector lector;
    private List<Observer> observers;

    public Course(Lector lector, List<Observer> observers) {
        this.lector = lector;
        this.observers = observers;
    }

    public abstract String learnJava();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.handleEvent("do your homework!!!");
        }
    }
}
