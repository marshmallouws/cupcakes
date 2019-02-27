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
public class DAO {
    private DBConnector conn = null;
    
    public DAO() {
        conn = new DBConnector();
    }
    
}
