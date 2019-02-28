package Logic;

import data.DAO;
import data.User;
import java.util.ArrayList;

/**
 *
 * @author caspe
 */
public class Controller {
    
    DAO data = new DAO();
    
    public ArrayList<User> getUsers() {
        ArrayList<User> users = data.getUsers();
        
        for (User user : users) {
            System.out.println(user.getUsername());
        }
        
        return users;
    }
}
