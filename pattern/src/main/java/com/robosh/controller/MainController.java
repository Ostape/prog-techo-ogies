package com.robosh.controller;

import com.robosh.view.MainView;

import java.util.Scanner;

public class MainController {
    private Scanner scanner;
    private MainView mainView;

    public MainController(Scanner scanner, MainView mainView) {
        this.scanner = scanner;
        this.mainView = mainView;
    }

    public int mainMenuInput() {
        mainView.showMainMenu();
        return scanner.nextInt();
    }

    public int subscribeMenuInput() {
        mainView.showCourseMenu();
        return scanner.nextInt();
    }
}
