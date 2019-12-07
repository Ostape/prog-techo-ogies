package com.robosh.repository;

import com.robosh.model.course.AdvancedCourse;
import com.robosh.model.course.IntroCourse;
import com.robosh.model.course.MiddleCourse;
import com.robosh.model.student.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Student firstStudent = new Student("Orest", "Shemeliuk");
        firstStudent.setCourse(new IntroCourse());
        Student secondStudent = new Student("Petro", "Pavlovich");
        secondStudent.setCourse(new MiddleCourse());
        Student thirdStudent = new Student("Olya", "Ishchenko");
        thirdStudent.setCourse(new AdvancedCourse());

        students.add(firstStudent);
        students.add(secondStudent);
        students.add(thirdStudent);
        return students;
    }
}
