package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;
    private static final String USERS_FILE = "users.txt";

    public UserManager() {
        this.users = loadUsersFromFile();
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(String username, String password, String role) {
        users.add(new User(username, password, role));
        saveUsersToFile();
    }

    public boolean removeUser(String username) {
        boolean removed = users.removeIf(user -> user.getUsername().equals(username));
        if (removed) {
            saveUsersToFile();
        }
        return removed;
    }

    public List<User> getUsersByRole(String role) {
        List<User> usersByRole = new ArrayList<>();
        for (User user : users) {
            if (user.getRole().equals(role)) {
                usersByRole.add(user);
            }
        }
        return usersByRole;
    }

    private List<User> loadUsersFromFile() {
        List<User> loadedUsers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    loadedUsers.add(new User(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("No existing users file found. Starting fresh.");
        }
        return loadedUsers;
    }

    private void saveUsersToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE))) {
            for (User user : users) {
                writer.printf("%s,%s,%s%n", user.getUsername(), user.getPassword(), user.getRole());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}