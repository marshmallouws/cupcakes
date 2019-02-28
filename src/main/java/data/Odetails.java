package data;

/**
 *
 * @author vl48
 */
public class Odetails {
    private int order_id = -1;
    private String top_name;
    private String bottom_name;
    private double price;
    private int qty;
    
    public Odetails(String top, String bottom, double price, int qty){
        this.top_name = top;
        this.bottom_name = bottom;
        this.price = price;
        this.qty = qty;
    }
    
    public Odetails(int order, String top, String bottom, double price, int qty){
        this.order_id = order;
        this.top_name = top;
        this.bottom_name = bottom;
        this.price = price;
        this.qty = qty;
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

    public String getTop_name() {
        return top_name;
    }

    public String getBottom_name() {
        return bottom_name;
    }
    
     
}
