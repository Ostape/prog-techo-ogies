package com.robosh.model.student;

import com.robosh.model.student.Observer;

public class Student implements Observer {
    private String name;
    private String surname;

    @Override
    public void handleEvent(String homeWork) {
        System.out.println(name + " " + surname + " is doing homework: " + homeWork);
    }
}
