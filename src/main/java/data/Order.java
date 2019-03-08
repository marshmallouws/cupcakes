package data;

import java.util.ArrayList;

/**
 *
 * @author vl48
 */
public class Order implements Comparable<Order> {
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
        String year = "";
        String month = "";
        String day = "";
        String time = "";
        
        String[] sp1 = date.split(" ");
        time = sp1[1].substring(0,5);
        
        String[] dates = sp1[0].split("-");
        year = dates[0];
        month = dates[1];
        day = dates[2];
        
        return day + "-" + month + "-" + year + "   kl. " + time;
    }
    
    public ArrayList<Odetails> getDetails() {
        return details;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public double getPrice() {
        double price = 0;
        for(Odetails o: details) {
            price += o.getPrice()*o.getQty();
        }
        return price;
    }

    @Override
    public int compareTo(Order o) {
        int compareId = o.getID();
        return this.id - compareId;
    }
}
