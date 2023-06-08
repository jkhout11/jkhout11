package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SportsBettingRecordkeepingApp {
    private User loggedInUser;
    private List<SportsBet> sportsBets;
    private Scanner scanner;

    public SportsBettingRecordkeepingApp() {
        this.sportsBets = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void login(String username, String password) {
        User user = UserFileHandler.loginUser(username, password);
        if (user != null) {
            loggedInUser = user;
            System.out.println("Logged in successfully!");
            showMainMenu();
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    public void register(String username, String password) {
        boolean registered = UserFileHandler.registerUser(username, password);
        if (registered) {
            System.out.println("Registration successful!");
            login(username, password);
        } else {
            System.out.println("Username already exists!");
        }
    }

    public void showAddSportsBetMenu() {
        System.out.println("===== Add Sports Bet Menu =====");
        System.out.print("Enter the sport you are betting: ");
        String sport = scanner.nextLine();
        System.out.print("Enter the amount wagered: ");
        double amountWagered = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        SportsBet sportsBet = new SportsBet(sport, amountWagered);
        addSportsBet(sportsBet);

        System.out.println("Sports bet added successfully!");
        showMainMenu();
    }

    public void showMainMenu() {
        System.out.println("===== Sports Betting Record Keeping App =====");
        System.out.println("1. Add Sports Bet");
        System.out.println("2. View Track Records");
        System.out.println("3. Logout");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                showAddSportsBetMenu();
                break;
            case 2:
                showTrackRecordsMenu();
                break;
            case 3:
                loggedInUser = null;
                System.out.println("Logged out successfully!");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void showTrackRecordsMenu() {
        System.out.println("===== Track Records Menu =====");
        System.out.println("1. Daily Track Record");
        System.out.println("2. Weekly Track Record");
        System.out.println("3. Monthly Track Record");
        System.out.println("4. Yearly Track Record");
        System.out.println("5. Go Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                displayTrackRecord("daily");
                break;
            case 2:
                displayTrackRecord("weekly");
                break;
            case 3:
                displayTrackRecord("monthly");
                break;
            case 4:
                displayTrackRecord("yearly");
                break;
            case 5:
                showMainMenu();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void addSportsBet(SportsBet sportsBet) {
        sportsBets.add(sportsBet);
    }

    public void displayTrackRecord(String timeframe) {
        System.out.println("===== " + timeframe + " Track Record =====");
        // Retrieve and display track records based on the specified timeframe
        // You can access the list of sports bets and perform calculations to show the relevant track records

        // Example implementation:
        double totalProfit = 0.0;
        double totalLoss = 0.0;
        double totalWagered = 0.0;

        for (SportsBet sportsBet : sportsBets) {
            totalWagered += sportsBet.getAmountWagered();
            if (sportsBet.getProfitLoss() > 0) {
                totalProfit += sportsBet.getProfitLoss();
            } else {
                totalLoss += Math.abs(sportsBet.getProfitLoss());
            }
        }

        System.out.println("Total Profit: $" + totalProfit);
        System.out.println("Total Loss: $" + totalLoss);
        System.out.println("Total Wagered: $" + totalWagered);

        showTrackRecordsMenu();
    }

    public void run() {
        System.out.println("Welcome to the Sports Betting Record Keeping App!");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        login(username, password);
    }

    public static void main(String[] args) {
        SportsBettingRecordkeepingApp app = new SportsBettingRecordkeepingApp();
        app.run();
    }
}