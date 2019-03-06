package Logic;

import data.Bottom;
import data.DAO;
import data.Odetails;
import data.Order;
import data.Top;
import java.util.ArrayList;

public class ShopController {
    private DAO d = new DAO();
    
    public ArrayList<Bottom> getAllBottoms() {
        return d.getAllBottoms();
    }
    public ArrayList<Top> getAllTops() {
        return d.getAllTops();
    }
    
    public Bottom getBottom(int id){
        return d.getBottom(id);
    }
    
    public Top getTop(int id){
        return d.getTop(id);
    }
    
    public ArrayList<Odetails> addToCart(ArrayList<Odetails> currentCart, int bottom, int top, int qty){
        if(currentCart == null) currentCart = new ArrayList<Odetails>();
        currentCart.add(d.createOdetailsForCart(bottom,top,qty));
        return currentCart; 
    }
    
    public ArrayList<Odetails> removeFromCart(ArrayList<Odetails> currentCart,int index){
        if(currentCart == null) return new ArrayList<Odetails>();
        currentCart.remove(index);
        return currentCart;
    }
    
    public boolean createOrder(Order order) {
        return d.placeOrder(order);
    }
}
