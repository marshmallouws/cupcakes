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
    
    public void addBalance(String username, double amount) {
        //data.addBalance(username, amount);
    }
}
