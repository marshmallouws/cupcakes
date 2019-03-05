package Logic;

import data.Bottom;
import data.DAO;
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
    
    public boolean createOrder(Order order) {
        return d.placeOrder(order);
    }
}
