/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        User u = null;
        try {
            String query = "SELECT * FROM User WHERE username = '" + username + "';";
            ResultSet rs = DBConnector.getConnection().prepareStatement(query).executeQuery();
            while (rs.next()) {
                u = new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"), 
                        rs.getDouble("balance"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
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
        String query = "INSERT INTO User VALUES ('" + username + "' , '" + email + "' , '" + password + "' , " + 0 + ");";
        boolean succes = false;
        
        try {
            Connection connection = DBConnector.getConnection();
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate(query);
            if(rs == 1) succes = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return succes;
    }

    @Override
    public boolean addBalance(String username, double amount) {
        String sql = "UPDATE User SET balance = (balance + " + amount + ") WHERE username = '" + username + "'";
        boolean succes = false;
        
        try {
            Connection connection = DBConnector.getConnection();
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate(sql);
            if(rs == 1) succes = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return succes;
    }
    
    @Override
    public String getTopIdName(int id) {
        String query = "SELECT `name` FROM `Top` WHERE `Top`.`id` = " + id + ";"; 
        ResultSet rs;
        String res = null;
        try {
            rs = DBConnector.getConnection().prepareStatement(query).executeQuery();
            res = rs.getString("name");
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return res;
    }
    
    @Override
    public String getBottomIdName(int id) {
        String query = "SELECT `name` FROM `Bottom` WHERE `Bottom`.`id` = " + id + ";"; 
        ResultSet rs;
        String res = null;
        try {
            rs = DBConnector.getConnection().prepareStatement(query).executeQuery();
            res = rs.getString("name");
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return res;
    }

    @Override
    public ArrayList<Order> getOrders(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Odetails> getOrderDetails(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Odetails getOrderDetail(int orderid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
