/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Bitten
 */
public class UserDAO {
    private DBConnector conn = null;
    
    public UserDAO() {
        conn = new DBConnector();
    }
    
}
