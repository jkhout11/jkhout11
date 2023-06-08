package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileHandler {
    private static final String FILE_PATH = "users.txt";

    public static User loginUser(String username, String password) {
        List<User> users = readUsersFromFile();

        // Find the user with the matching username and password
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // User found, return the User object
            }
        }

        return null; // User not found
    }

    public static boolean registerUser(String username, String password) {
        List<User> users = readUsersFromFile();

        // Check if the username already exists
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Username already exists
            }
        }

        // Create a new User object
        User newUser = new User(username, password);
        users.add(newUser);

        // Save the updated user list to the file
        saveUsersToFile(users);

        return true; // Registration successful
    }

    private static List<User> readUsersFromFile() {
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    User user = new User(username, password);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    private static void saveUsersToFile(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users) {
                writer.write(user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}