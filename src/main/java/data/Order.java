package data;

import java.util.ArrayList;

/**
 *
 * @author vl48
 */
public class Order {
    private int id;
    private int userID;
    private String date;
    private ArrayList<Odetails> details;

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

//    public String getUsername() {
//        return user.getUsername();
//    }

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
