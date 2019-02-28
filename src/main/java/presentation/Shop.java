/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Logic.ShopController;
import data.Bottom;
import data.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import data.DAO;
import data.Top;
import java.util.ArrayList;

/**
 *
 * @author Martin
 */
@WebServlet(name = "Shop", urlPatterns = {"/Shop"})
public class Shop extends HttpServlet {

    private ShopController sc = new ShopController();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User loggedUser = (User)session.getAttribute("user");
        ArrayList<Top> tops = sc.getAllTops();
        ArrayList<Bottom> bottoms = sc.getAllBottoms();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Shop</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Currently logged in as: " + loggedUser.getUsername() + "</h1>");
            out.println("<h1>Current balance: " + loggedUser.getBalance() + "</h1>");
            out.println("<br><br>");
            for (Top t : tops) {
                out.println("<p> Top:" + t.getName() + " - " + t.getPrice() + "</p>");
            }
            for (Bottom b : bottoms) {
                out.println("<p> Bottom: " + b.getName() + " - " + b.getPrice() +  "</p>");
            }
//            out.println("<h1 style=\"font-family:verdana;\"> Currently logged in as: " + loggedUser + "</h1>");
//            out.println("<h1 style=\"font-family:courier;\">Current balance: " + loggedUser.getBalance() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
