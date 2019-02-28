/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vics
 */
public class DBConnector {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://138.68.92.25:3306/cupcakes";
    private static final String USER = "testuser";
    private static final String PASSWORD = "password123";
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(DRIVER);
                conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                //se hele sekvenst til det gik galt. Dette kan skrives til logfil.
                ex.printStackTrace();
            }
        }
        return conn;
    }
    
    // Just for testing the connection with the database
    public void testConnection() throws Exception {
        try {
            String sql = "SELECT * FROM odetails";
            ResultSet rs = getConnection().prepareStatement(sql).executeQuery();

            while (rs.next()) {
                System.out.println("id: " + rs.getString("order_i") + " top: " + rs.getString("Top_id") + " bottom: " + rs.getString("Bottom_id") + " qty: " + rs.getString("qty") + " total price: " + rs.getString("price"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Exception fanget og sendt videre..");
        }
    }
    
    
}
