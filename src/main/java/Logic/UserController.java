package Logic;

import data.DAO;
import data.User;
import java.util.ArrayList;

/**
 *
 * @author caspe
 */
public class UserController {
    
    DAO data = new DAO();
    
    /**
     * Gets a list of all users
     * @return all users from DAO.
     */
    public ArrayList<User> getUsers() {
        ArrayList<User> users = data.getUsers();
        
        return users;
    }
    
    /**
     * Adds an amount to a users balance
     * @param username
     * @param amount
     * @return true if success, otherwise false
     */
    public boolean addBalance(String username, double amount) {
        return data.addBalance(username, amount);
    }
    
    /**
     * Gets a specific user
     * @param username
     * @return a specific user
     */
    public User getUser(String username){
        return data.getUser(username);
    }
    
    /**
     * Attemps to log the user in
     * @param username
     * @param password
     * @return true if success, otherwise false
     */
    public boolean login(String username, String password){
        User user = data.getUser(username);
        return password.equals(user.getPassword());
    }
    
    /**
     * Creates a new user in database.
     * @param username
     * @param password
     * @param email
     * @return true if success, otherwise false
     */
    public boolean newUser(String username, String password, String email){
        return data.insertUser(username, password, email);
    }
}
