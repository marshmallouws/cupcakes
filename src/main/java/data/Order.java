package data;

import java.util.ArrayList;

/**
 *
 * @author vl48
 */
public class Order {
    private int id;
    private String username;
    private String date;
    private ArrayList<Odetails> details;

    public Order(String username, String date) {
        this.username = username;
        this.date = date;
        details = new ArrayList<>();
    }
    
    public Order(int id, String username, String date) {
        this(username, date);
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
}
