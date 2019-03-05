package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
                u = new User(rs.getInt("id"),
                        rs.getString("username"),
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
    public User getUser(int id) {
        User u = null;
        try {
            String query = "SELECT * FROM User WHERE id = '" + id + "';";
            ResultSet rs = DBConnector.getConnection().prepareStatement(query).executeQuery();
            while (rs.next()) {
                u = new User(rs.getInt("id"),
                        rs.getString("username"),
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
                User user = new User(rs.getInt("id"),
                        rs.getString("username"), 
                        rs.getString("password"), 
                        rs.getString("email"), 
                        rs.getDouble("balance"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return users;
    }

    @Override
    public boolean insertUser(String username, String password, String email) {
        String query = "INSERT INTO User (username, email, password, balance) VALUES ('" + username + "' , '" + email + "' , '" + password + "' , " + 0 + ");";
        boolean succes = false;

        try {
            Connection connection = DBConnector.getConnection();
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate(query);
            if (rs == 1) {
                succes = true;
            }

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
            if (rs == 1) {
                succes = true;
            }
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
            rs.next();
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
            rs.next();
            res = rs.getString("name");
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return res;
    }

    // Get All Orders
    public List<Order> getOrders() {
        List<Order> orders = new ArrayList();
        String sql = "SELECT * FROM `order`";
        
        try {
            ResultSet rs = DBConnector.getConnection().prepareStatement(sql).executeQuery();
            while (rs.next()) {
                orders.add(new Order(rs.getInt("id"), rs.getInt("User_id"), rs.getString("date")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return orders;
    }
    @Override
    public ArrayList<Order> getOrders(int id) {
        String query = "SELECT * FROM `order` WHERE User_id = '" + id + "';";
        ArrayList<Order> ord = new ArrayList<>();

        try {
            ResultSet rs = DBConnector.getConnection().prepareStatement(query).executeQuery();
            while (rs.next()) {
                ord.add(new Order(rs.getInt("id"),
                        rs.getInt("User_id"),
                        rs.getString("date"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ord;
    }

    @Override
    public ArrayList<Odetails> getOrderDetails(int id) {
        String query = "SELECT * FROM odetails "
                + "JOIN `order` ON order_id = id "
                + "JOIN Bottom ON Bottom_id = Bottom.id "
                + "JOIN Top ON Top_id = Top.id "
                + "WHERE User_id = '" + id + "';";
        ArrayList<Odetails> od = new ArrayList<>();
        try {
            ResultSet rs = DBConnector.getConnection().prepareStatement(query).executeQuery();

            while (rs.next()) {
                od.add(new Odetails(rs.getInt("id"),
                        rs.getString("Top.name"),
                        rs.getString("Bottom.name"),
                        rs.getDouble("price"),
                        rs.getInt("qty")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return od;
    }

    @Override
    public ArrayList<Odetails> getOrderDetail(int orderid) {
        String query = "SELECT * FROM odetails "
                + "JOIN Top ON Top.id = Top_id "
                + "JOIN Bottom ON Bottom.id = Bottom_id "
                + "WHERE order_id = " + orderid + ";";

        ArrayList<Odetails> od = new ArrayList<>();
        try {
            ResultSet rs = DBConnector.getConnection().prepareStatement(query).executeQuery();

            while (rs.next()) {
                od.add(new Odetails(rs.getInt("order_id"),
                        rs.getString("Top.name"),
                        rs.getString("Bottom.name"),
                        rs.getDouble("price"),
                        rs.getInt("qty")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return od;
    }

    @Override
    public ArrayList<Bottom> getAllBottoms() {

        ResultSet rs;
        ArrayList result = new ArrayList<>();
        String query = "SELECT * FROM `Bottom`;";

        try {
            rs = DBConnector.getConnection().prepareStatement(query).executeQuery();

            while (rs.next()) {
                result.add(new Bottom(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }

        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return result;

    }

    @Override
    public ArrayList<Top> getAllTops() {

        ResultSet rs;
        ArrayList result = new ArrayList<>();
        String query = "SELECT * FROM `Top`;";

        try {
            rs = DBConnector.getConnection().prepareStatement(query).executeQuery();

            while (rs.next()) {
                result.add(new Top(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }

        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return result;
    }

    @Override
    public boolean placeOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
