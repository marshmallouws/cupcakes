/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Logic.UserController;
import data.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bitten
 */
@WebServlet(name = "AddBalanceServlet", urlPatterns = {"/AddBalanceServlet"})
public class AddBalanceServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        UserController u = new UserController();
        
        String username = request.getParameter("username");
        double amount = Double.parseDouble(request.getParameter("DKK"));
        ArrayList<User> users = u.getUsers();
        String errMsg = "";
        
        for(User us: users) {
            if (us.getUsername().equals(username)) {
                if(amount < 0) {
                    errMsg = "Beløbet der bliver indsat skal være større end 0";
                } else if (u.addBalance(username, amount)) {
                    errMsg = username + "'s saldo er nu opdateret";
                }
            }
        }
        
        if(errMsg.isEmpty()) {
            errMsg = username + " findes ikke i databasen";
        }
        
        request.setAttribute("errMsg", errMsg);
        request.getRequestDispatcher("./AdminAddBalance.jsp").forward(request, response);
        
        //response.sendRedirect("./AdminAddBalance.jsp");
        
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
