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
}
