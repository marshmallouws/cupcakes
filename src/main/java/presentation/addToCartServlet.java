/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Logic.ShopController;
import data.Odetails;
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
@WebServlet(name = "addToCartServlet", urlPatterns = {"/addToCart"})
public class addToCartServlet extends HttpServlet {

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
        if(session.getAttribute("cart")!=null)
            currentCart = (ArrayList<Odetails>)session.getAttribute("cart");    
            
        if(request.getParameter("remove") != null){
            int remove = Integer.parseInt(request.getParameter("remove"));
            session.setAttribute("cart", sc.removeFromCart(currentCart, remove));
            response.sendRedirect("./store.jsp");
            return;
        }    
            
        int bottom_id = Integer.parseInt(request.getParameter("addBottom"));
        int top_id = Integer.parseInt(request.getParameter("addTop"));
        int qty = Integer.parseInt(request.getParameter("addQTY"));
        if(qty<1 || bottom_id<1 || top_id < 1) throw new Exception();        
        session.setAttribute("cart", sc.addToCart(currentCart, bottom_id, top_id, qty));
        response.sendRedirect("./store.jsp");
        return;
        }catch(Exception e){
             request.setAttribute("errorMsg", "Kunne ikke tilføje til kurv");
             view = request.getRequestDispatcher("./store.jsp");
             view.forward(request, response);    
             return;
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
