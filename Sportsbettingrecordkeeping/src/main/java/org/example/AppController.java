package org.example;

import java.util.Scanner;

public class AppController {
    private User loggedInUser;
    private Scanner scanner;
    private UserFileHandler userFileHandler;

    public AppController() {
        this.scanner = new Scanner(System.in);
        this.userFileHandler = new UserFileHandler();
    }

    public void run() {
        showWelcomeMessage();

        boolean exit = false;
        while (!exit) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    loginUser();
                    break;
                case 2:
                    registerUser();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private void showWelcomeMessage() {
        System.out.println("Welcome to the Sports Betting Record Keeping App!");
    }

    private void showMainMenu() {
        System.out.println("===== Main Menu =====");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private void loginUser() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        User user = userFileHandler.loginUser(username, password);
        if (user != null) {
            loggedInUser = user;
            System.out.println("Logged in successfully!");
            // Call the appropriate method to show user menu or perform further actions
            showUserMenu();
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    private void registerUser() {
        System.out.print("Enter your desired username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your desired password: ");
        String password = scanner.nextLine();

        boolean registered = userFileHandler.registerUser(username, password);
        if (registered) {
            System.out.println("Registration successful!");
            loginUser(); // Automatically log in the registered user
        } else {
            System.out.println("Username already exists!");
        }
    }

    private void showUserMenu() {
        UserMenuController userMenuController = new UserMenuController();
        userMenuController.run();
    }
}