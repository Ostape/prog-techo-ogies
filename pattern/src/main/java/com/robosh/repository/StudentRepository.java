package com.robosh.repository;

import com.robosh.model.student.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public List<Student> getIntoCourseStudents() {
        List<Student> students = new ArrayList<>();
        Student firstStudent = new Student("Orest", "Shemeliuk");
        Student secondStudent = new Student("Petro", "Pavlovich");
        students.add(firstStudent);
        students.add(secondStudent);
        return students;
    }

    public List<Student> getMiddleCourseStudents() {
        List<Student> students = new ArrayList<>();
        Student firstStudent = new Student("Yulia", "Andriivna");
        Student secondStudent = new Student("Yak", "Papa");
        students.add(firstStudent);
        students.add(secondStudent);
        return students;
    }

    public List<Student> getAdvancedCourseStudents() {
        List<Student> students = new ArrayList<>();
        Student firstStudent = new Student("Alex", "Mar");
        Student secondStudent = new Student("Yegor", "Mol");
        students.add(firstStudent);
        students.add(secondStudent);
        return students;
    }
}
