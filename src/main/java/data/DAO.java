package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                        rs.getDouble("balance"),
                        Role.valueOf(rs.getString("role").toUpperCase()));
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
                        rs.getDouble("balance"),
                        Role.valueOf(rs.getString("role").toUpperCase()));
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
                        rs.getDouble("balance"),
                        Role.valueOf(rs.getString("role").toUpperCase()));
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
                        rs.getInt("Top.name"),
                        rs.getInt("Bottom.name"),
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
                        rs.getInt("Top.id"),
                        rs.getInt("Bottom.id"),
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

    private int insertOrder(Order order) {
        String query = "INSERT INTO `order` (date, User_id) VALUES (now(), ?);";
        int id = 0;

        try {
            Connection connection = DBConnector.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, order.getUserID());

            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    @Override
    public int placeOrder(Order order) {
        String queryDet = "INSERT INTO odetails (order_id, Top_id, Bottom_id, price, qty) "
                + "VALUES (?, ?, ?, ?, ?);";
        int orderid = insertOrder(order);
        //TODO: Make query to change user's balance.
        double price = 0;

        Connection conn = DBConnector.getConnection();
        ArrayList<Odetails> details = order.getDetails();

        try {
            conn.setAutoCommit(false);
            PreparedStatement pso = conn.prepareStatement(queryDet);

            for (Odetails o : details) {

                pso.setInt(1, orderid); //orderid
                pso.setInt(2, o.getTop_id()); //top
                pso.setInt(3, o.getBottom_id()); //bottom
                pso.setDouble(4, o.getPrice()); //price
                pso.setInt(5, o.getQty()); //qty
                System.out.println(o);
                pso.addBatch();
                price += o.getPrice()*o.getQty();
            }
            pso.executeBatch();

        } catch (SQLException ex) {
            price = 0;
            try {
                conn.rollback();
                String query = "DELETE FROM `order` WHERE id = " + orderid + ";";
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(price == 0) {
            return -1;
        }
        
        deductBalance(price, order.getUserID());
        System.out.println(orderid);
        return orderid;
    }
    
    private boolean deductBalance(double amount, int userid) {
        String sql = "UPDATE User SET balance = (balance - " + amount + ") WHERE id = '" + userid + "'";
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

    public Bottom getBottom(int id) {
        ResultSet rs;
        Bottom bottom = null;
        String query = "SELECT * FROM `Bottom` WHERE id=" + id + ";";
        try {
            rs = DBConnector.getConnection().prepareStatement(query).executeQuery();
            while (rs.next()) {
                bottom = new Bottom(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
            }
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return bottom;
    }

    public Top getTop(int id) {
        ResultSet rs;
        Top top = null;
        String query = "SELECT * FROM `Top` WHERE id=" + id + ";";
        try {
            rs = DBConnector.getConnection().prepareStatement(query).executeQuery();
            while (rs.next()) {
                top = new Top(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
            }
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return top;
    }

    public Odetails createOdetailsForCart(int bottom, int top, int qty) {
        double price = (getTop(top).getPrice() + getBottom(bottom).getPrice());
        return new Odetails(top, bottom, price, qty);
    }
    
    public Order getOrder(int id) {
        String query = "SELECT * FROM `order` WHERE id = " + id + ";";
        Order o = null;
        try {
            ResultSet rs = DBConnector.getConnection().prepareStatement(query).executeQuery();
            while (rs.next()) {
                o = new Order(rs.getInt("id"),
                        rs.getInt("User_id"),
                        rs.getString("date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }
}
