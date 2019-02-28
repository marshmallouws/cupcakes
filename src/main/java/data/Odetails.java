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
    
    public Odetails(int top, int bottom, double price, int qty){
        this.top_id = top;
        this.bottom_id = bottom;
        this.price = price;
        this.qty = qty;
    }
    
    public Odetails(int order, int top, int bottom, double price, int qty){
        this.order_id = order;
        this.top_id = top;
        this.bottom_id = bottom;
        this.price = price;
        this.qty = qty;
    }

    public int getOrderID() {
        return order_id;
    }

    public int getTopID() {
        return top_id;
    }

    public int getBottomID() {
        return bottom_id;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }
    
     
}
