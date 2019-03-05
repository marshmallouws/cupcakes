/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author caspe
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private double balance;
    
    public User(int id, String username, String password, String email, double balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }
    
    
}
