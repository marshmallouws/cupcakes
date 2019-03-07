package data;

/**
 *
 * @author vl48
 */
public class Odetails {
    private int order_id = -1;
    private int top_id;
    private int bottom_id;
    private double price;
    private int qty;
    String top_name;
    String bottom_name;

    public Odetails(int order_id, String top_name, String bottom_name, double price, int qty) {
        this.order_id = order_id;
        this.top_name = top_name;
        this.bottom_name = bottom_name;
        this.price = price;
        this.qty = qty;
    }
    
    
    
    public Odetails(int top, int bottom, double price, int qty){
        this.top_id = top;
        this.bottom_id = bottom;
        this.price = price;
        this.qty = qty;
    }
    
    public Odetails(int order, int top, int bottom, double price, int qty){
        this(top, bottom, price, qty);
        this.order_id = order;
    }

    public int getOrderID() {
        return order_id;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public int getTop_id() {
        return top_id;
    }

    public int getBottom_id() {
        return bottom_id;
    }

    public String getTop_name() {
        return top_name;
    }

    public String getBottom_name() {
        return bottom_name;
    }
    
    public void addToQty(int qty) {
        this.qty += qty;
    }
    
    
}
