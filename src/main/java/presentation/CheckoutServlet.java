/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Logic.ShopController;
import data.Odetails;
import data.Order;
import data.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vl48
 */
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/checkout"})
public class CheckoutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShopController sc = new ShopController();
        RequestDispatcher view;
        try {
            HttpSession session = request.getSession();
            ArrayList<Odetails> currentCart = new ArrayList();
            if (session.getAttribute("cart") != null) {
                currentCart = (ArrayList<Odetails>) session.getAttribute("cart");
            }

            User user = (User) session.getAttribute("user");
            if (currentCart.isEmpty() || user == null) {
                throw new Exception();
            }

            if (!sc.hasBalance(user, currentCart)) {
                request.setAttribute("errorMsg", "Konto har ikke penge nok til at gennemføre ordre");
                view = request.getRequestDispatcher("./store.jsp");
                view.forward(request, response);
            }

            Order order = new Order(user.getUserID(), currentCart);
            int orderid = sc.createOrder(order);
            
            if (orderid < 0) {
                throw new Exception();
            }
            session.removeAttribute("cart");
            request.setAttribute("orderid", orderid);
            request.setAttribute("currCart", currentCart);
            request.setAttribute("errorMsg", "Din ordre er nu gennemført");
            view = request.getRequestDispatcher("./orderConfirmation.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMsg", "Kunne ikke gennemføre ordre");
            view = request.getRequestDispatcher("./store.jsp");
            view.forward(request, response);
        }
        /*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        } */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
