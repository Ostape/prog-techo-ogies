package com.robosh.controller;

import com.robosh.model.course.Course;
import com.robosh.model.course.CourseType;
import com.robosh.model.student.Student;
import com.robosh.repository.CourseRepository;
import com.robosh.view.CoursesView;

public class CoursesController {
    private CoursesView coursesView;
    private CourseRepository repository;

    public CoursesController(CoursesView coursesView, CourseRepository repository) {
        this.coursesView = coursesView;
        this.repository = repository;
    }

    public void showAllCourses() {
        coursesView.showCourse(repository.getCourse(CourseType.INTRO));
        coursesView.showCourse(repository.getCourse(CourseType.MIDDLE));
        coursesView.showCourse(repository.getCourse(CourseType.ADVANCED));
    }

    public void sentNotifications() {
        repository.getCourse(CourseType.INTRO).notifyObserver();
        repository.getCourse(CourseType.MIDDLE).notifyObserver();
        repository.getCourse(CourseType.ADVANCED).notifyObserver();
    }

    public void subscribeOnCourse(Student student, CourseType type) {
        Course course = repository.getCourse(type);
        course.addObserver(student);
        coursesView.showCourse(course);
    }
}
