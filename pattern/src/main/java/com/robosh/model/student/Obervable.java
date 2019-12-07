package com.robosh.model.student;

public interface Obervable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
