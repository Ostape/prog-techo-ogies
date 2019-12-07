package com.robosh.repository;

import com.robosh.model.course.*;
import com.robosh.model.exception.NoSuchCourseException;

public class CourseRepository {
    //getting course from the database.
    public Course getCourse(CourseType type) {
        switch (type) {
            case INTRO:
                return getIntroCourse();
            case MIDDLE:
                return new MiddleCourse();
            case ADVANCED:
                return new AdvancedCourse();
            default:
                throw new NoSuchCourseException("No course found");
        }
    }

    private Course getIntroCourse() {
        Course course = new IntroCourse();
        return course;
    }
}
