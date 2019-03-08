/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

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
    private Role role;
    private ArrayList<Order> orders;

    // With Role
    public User(int id, String username, String password, String email, double balance, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.role = role;
    }
    
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
    
    public int getUserID() {
        return id;
    }

    public Role getRole() {
        return role;
    }
    
    public ArrayList<Order> getOrders() {
        return orders;
    }
    
    public void setOrders(Order order) {
        orders.add(order);
    }
    
    public void setBalance(double price) {
        balance -= price;
    }
    
}
