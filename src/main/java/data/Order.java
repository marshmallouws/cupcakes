package data;

import java.util.ArrayList;

/**
 *
 * @author vl48
 */
public class Order {
    private int id;
    private int userID;
    private String username;
    private String date;
    private ArrayList<Odetails> details;

    
    // Full - no odetails
    public Order(int id, int userID, String username, String date) {
        this.id = id;
        this.userID = userID;
        this.username = username;
        this.date = date;
    }
    
    public Order(int userID, String date) {
        //this.username = username
        this.userID = userID;
        this.date = date;
        details = new ArrayList<>();
    }
    
    public Order(int userID, ArrayList<Odetails> details) {
        //this.username = username
        this.userID = userID;
        this.details = details;
    }
    
    public Order(int id, int userID, String date) {
        this(userID, date);
        this.id = id;
    }

    
    public int getID() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    
    

    public String getDate() {
        return date;
    }
    
    public ArrayList<Odetails> getDetails() {
        return details;
    }
    
    public int getUserID() {
        return userID;
    }
}
