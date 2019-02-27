package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/recipes_opgave";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                //se hele sekvenst til det gik galt. Dette kan skrives til logfil.
                ex.printStackTrace();
            }
        }
        return conn;
   
    }
}