package data;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bitten
 */
public interface DAOInterface {
    
    public User getUser(String username);
    public ArrayList<User> getUsers();
    public boolean insertUser(String username, String password, String email);
    public boolean addBalance(String username, double amount);
    
}
