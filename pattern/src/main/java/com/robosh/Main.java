package com.robosh;

import com.robosh.controller.CoursesController;
import com.robosh.controller.MainController;
import com.robosh.model.course.CourseType;
import com.robosh.model.student.Student;
import com.robosh.repository.CourseRepository;
import com.robosh.repository.LectorRepository;
import com.robosh.repository.StudentRepository;
import com.robosh.view.CoursesView;
import com.robosh.view.MainView;

import java.util.Scanner;

public class Main {
    private MainController mainController;
    private CoursesController coursesController;
    private Student student;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        init();
        int choose = 0;
        while (choose != 4) {
            choose = mainController.mainMenuInput();
            switch (choose) {
                case 1:
                    showAllCourses();
                    break;
                case 2:
                    showSubscribeMenu();
                    break;
                case 3:
                    sentNotificationsForAllStudents();
                    break;
            }
        }
    }

    private void init() {
        student = new Student("New Student", "New Student");
        mainController = new MainController(new Scanner(System.in), new MainView());
        CoursesView coursesView = new CoursesView();
        CourseRepository courseRepository = new CourseRepository(new StudentRepository(), new LectorRepository());
        coursesController = new CoursesController(coursesView, courseRepository);
    }

    private void showAllCourses() {
        coursesController.showAllCourses();
    }

    private void showSubscribeMenu() {
        int menuInput = mainController.subscribeMenuInput();

        switch (menuInput) {
            case 1:
                coursesController.subscribeOnCourse(student, CourseType.INTRO);
                break;
            case 2:
                coursesController.subscribeOnCourse(student, CourseType.MIDDLE);
                break;
            case 3:
                coursesController.subscribeOnCourse(student, CourseType.ADVANCED);
                break;
        }
    }

    private void sentNotificationsForAllStudents() {
        coursesController.sentNotifications();
    }
}
