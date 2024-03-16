package User;

import java.util.ArrayList;
import java.util.List;

public class UserAuthentication {
    private List<User> users;

    public UserAuthentication() {
        this.users = new ArrayList<>();
    }

    public void registerAUser(String username, String password) {
        users.add(new User(username, password));
    }

    public boolean validateUser(String username, String password) {
        for (User user :
                users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
