package com.robosh.model.student;

import com.robosh.model.course.Course;
import lombok.Data;

@Data
public class Student implements Observer {
    private String name;
    private String surname;
    private Course course;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public void handleEvent(String homeWork) {
        System.out.println(name + " " + surname + " is doing homework: " + homeWork);
    }
}
