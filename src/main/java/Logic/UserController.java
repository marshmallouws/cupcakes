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
    
    public ArrayList<User> getUsers() {
        ArrayList<User> users = data.getUsers();
        
        return users;
    }
    
    public boolean addBalance(String username, double amount) {
        return data.addBalance(username, amount);
    }
    
    public User getUser(String username){
        return data.getUser(username);
    }
    
    public boolean login(String username, String password){
        User user = data.getUser(username);
        return user.getPassword().equals(password);
    }
    
    public boolean newUser(String username, String password, String email){
        return data.insertUser(username, password, email);
    }
}
