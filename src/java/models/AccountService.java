package models;

/**
 *
 * @author 794473
 */
public class AccountService {

    public User login(String username, String password) {
        User user;

        if (username.equals("adam") && password.equals("password")) {
            user = new User(username, null);
        } else if (username.equals("betty") && password.equals("password")) {
            user = new User(username, null);
        } else {
            user = null;
        }

        return user;
    }

}
