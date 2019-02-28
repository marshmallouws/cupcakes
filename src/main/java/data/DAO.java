/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bitten
 */
public class DAO implements DAOInterface {

    @Override
    public User getUser(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> getUsers() {
        
        ArrayList<User> users = new ArrayList();
        
        try {
            String sql = "SELECT * FROM `User`";
            ResultSet rs = DBConnector.getConnection().prepareStatement(sql).executeQuery();
            
            while (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getDouble("balance"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return users;
    }

    @Override
    public boolean insertUser(String username, String password, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addBalance(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
}
