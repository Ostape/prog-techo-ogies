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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.Scanner;

public class Main {
    private MainController mainController;
    private CoursesController coursesController;
    private Student student;
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final Marker USER_MARKER = MarkerManager.getMarker("USER");

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            logger.error(USER_MARKER,"Starting application");
            logger.trace(USER_MARKER,"trace" + i);
            logger.fatal(USER_MARKER,"fatal" + i);
            logger.debug(USER_MARKER,"debug" + i);
            logger.info(USER_MARKER,"sssssssss" + i);
        }
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
        logger.debug("Init classes");
        student = new Student("New Student", "New Student");
        mainController = new MainController(new Scanner(System.in), new MainView());
        CoursesView coursesView = new CoursesView();
        CourseRepository courseRepository = new CourseRepository(new StudentRepository(), new LectorRepository());
        coursesController = new CoursesController(coursesView, courseRepository);
    }

    private void showAllCourses() {
        logger.debug("showing all courses");
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
