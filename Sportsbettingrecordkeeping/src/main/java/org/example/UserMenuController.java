package org.example;

import java.util.Scanner;

public class UserMenuController {
    private static final Scanner scanner = new Scanner(System.in);

    private SportsBettingRecordkeepingApp app;

    public UserMenuController(SportsBettingRecordkeepingApp app) {
        this.app = app;
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
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

    private void showMenu() {
        System.out.println("===== Sports Betting Record Keeping App =====");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        app.login(username, password);
    }

    private void register() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        app.register(username, password);
    }
}