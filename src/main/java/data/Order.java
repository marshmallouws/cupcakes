package data;

/**
 *
 * @author caspe
 */
public class Order {
    private int id;
    private String username;
    private String date;

    public Order(int id, String username, String date) {
        this.id = id;
        this.username = username;
        this.date = date;
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
    
    
}
