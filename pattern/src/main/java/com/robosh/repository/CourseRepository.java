package com.robosh.repository;

import com.robosh.model.course.*;
import com.robosh.model.exception.NoSuchCourseException;
import com.robosh.model.lector.Lector;
import com.robosh.model.student.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private StudentRepository studentRepository;
    private LectorRepository lectorRepository;

    public CourseRepository(StudentRepository studentRepository, LectorRepository lectorRepository) {
        this.studentRepository = studentRepository;
        this.lectorRepository = lectorRepository;
    }

    //getting course from the database.
    public Course getCourse(CourseType type) {
        switch (type) {
            case INTRO:
                return getIntroCourse();
            case MIDDLE:
                return getMiddleCourse();
            case ADVANCED:
                return getAdvancedCourse();
            default:
                throw new NoSuchCourseException("No course found");
        }
    }

    private Course getIntroCourse() {
        Lector lector = lectorRepository.getJavaLector();
        List<Student> students = studentRepository.getIntoCourseStudents();
        Course course = new IntroCourse(lector, new ArrayList<>());
        for (Student student: students) {
            course.addObserver(student);
        }
        return course;
    }

    private Course getMiddleCourse() {
        Lector lector = lectorRepository.getMiddleJavaLector();
        List<Student> students = studentRepository.getMiddleCourseStudents();
        Course course = new MiddleCourse(lector, new ArrayList<>());
        for (Student student: students) {
            course.addObserver(student);
        }
        return course;
    }

    private Course getAdvancedCourse() {
        Lector lector = lectorRepository.getSeniorLector();
        List<Student> students = studentRepository.getAdvancedCourseStudents();
        Course course = new AdvancedCourse(lector, new ArrayList<>());
        for (Student student: students) {
            course.addObserver(student);
        }
        return course;
    }
}
