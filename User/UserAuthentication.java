package User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserAuthentication {
    private List<User> users;
    private static final String usersFile = "users.txt";

    public UserAuthentication() {
        this.users = new ArrayList<>();
        this.loadUsersFromFile();
    }

    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(":");
                if (values.length == 2) {
                    users.add(new User(values[0], values[1]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading users from file: " + e.getMessage());
        }
    }

    private void saveUserToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile, true))) {
            writer.write(user.getUsername() + ":" + user.getPassword());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving users to file: " + e.getMessage());
        }
    }

    public boolean registerAUser(String username, String password) {
        for (User user :
                users) {
            if(user.getUsername().equals(username)) {
                System.out.println("User already exists");
                return false;
            }
        }
        User user = new User(username, password);
        users.add(user);
        this.saveUserToFile(user);
        return true;
    }

    public boolean validateUser(String username, String password) {
        for (User user :
                users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
