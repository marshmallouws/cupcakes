package Logic;

import data.Bottom;
import data.DAO;
import data.Odetails;
import data.Order;
import data.Top;
import data.User;
import java.util.ArrayList;

/**
 *
 * @author Vics
 */
public class ShopController {
    private DAO d = new DAO();
    
    /**
     * Gets a list of all bottoms.
     * @return all bottoms from DAO.
     */
    public ArrayList<Bottom> getAllBottoms() {
        return d.getAllBottoms();
    }

    /**
     * Gets a list of all Tops.
     * @return all tops from DAO.
     */
    public ArrayList<Top> getAllTops() {
        return d.getAllTops();
    }
    
    /**
     * Gets a specific Bottom.
     * @param id - the bottom id
     * @return specific bottom from DAO.
     */
    public Bottom getBottom(int id){
        return d.getBottom(id);
    }
    
    /**
     * Gets a specific Top.
     * @param id - the top id
     * @return specific top from DAO.
     */
    public Top getTop(int id){
        return d.getTop(id);
    }
    
    /**
     *
     * @param currentCart - the customers current cart
     * @param bottom - the bottom to add to cart
     * @param top - the top to add to cart
     * @param qty - the amount of the above combination to add to cart
     * @return current cart updated with the new information
     */
    public ArrayList<Odetails> addToCart(ArrayList<Odetails> currentCart, int bottom, int top, int qty){
        if(currentCart == null) currentCart = new ArrayList<Odetails>();
        currentCart.add(d.createOdetailsForCart(bottom,top,qty));
        return currentCart; 
    }
    
    /**
     *
     * @param currentCart - the customers current cart
     * @param index - the index in the array the customer wants to remove
     * @return current cart with the specific item removed.
     */
    public ArrayList<Odetails> removeFromCart(ArrayList<Odetails> currentCart,int index){
        if(currentCart == null) return new ArrayList<Odetails>();
        currentCart.remove(index);
        return currentCart;
    }
    
    /**
     * Adds a complete order object to the database and returns the created order id.
     * @param order - a complete order with added cart
     * @return the id from the completed order from DAO
     */
    public int createOrder(Order order) {
        return d.placeOrder(order);
    }
    
    /**
     * Checks if the user has enough money to make a purchase of the current cart
     * @param user - current user
     * @param currentCart - current users cart
     * @return true or false
     */
    public boolean hasBalance(User user, ArrayList<Odetails> currentCart){
        double price = 0.0;
        for(Odetails item:currentCart){
            price += item.getPrice()*item.getQty();
        }
        
        return user.getBalance() > price;
    }
    
    /**
     *
     * @param id - order id
     * @return a specific order
     */
    public Order getOrder(int id){
        return d.getOrder(id);
    }
}
