<%-- 
    Document   : store
    Created on : 05-Mar-2019, 12:00:18
    Author     : vl48
--%>

<%@page import="data.Odetails"%>
<%@page import="Logic.ShopController"%>
<%@page import="data.Bottom"%>
<%@page import="data.Top"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cupcakes - Store</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/cupcakes.css">
    </head>
    <body>
        <div class="navbar">
            <%  session = request.getSession();
                User loggedUser = (User)session.getAttribute("user"); %>
            <div class="nav-wrapper">
            <div class="navigation-logo">
                <img src="./images/cupcake_logo.png" width="50">
                <img src ="./images/cupcake_logo_txt.png" width="250"> 
            </div>
            <div class="navigation">
                <a href="#" class="link">Køb Cupcakes</a>
                <a href="#" class="link">Tidligere Ordre</a>
                <a href="#" class="link">Log ud</a>
                <% if(loggedUser != null) { %>
                <span class="link">Balance: <%= loggedUser.getBalance() %> DKK</span>
                <% } %>
            </div>
            </div>
        </div>
        <div class="clearfix"></div>
        <div class="header">Dine gladeste cupcakes</div>
        <div class="main">
            <%  ShopController sc = new ShopController();
                ArrayList<Top> tops = sc.getAllTops();
                ArrayList<Bottom> bottoms = sc.getAllBottoms(); %>                  
            <div class="add-to-cart-wrapper">
            <h2 class="shop-title">Tilføj Cupcakes Til Indkøbskurv</h2>
            <form action="./addToCart" method="POST">
            <table class="shop-table">
                <thead>
                    <tr>
                        <th>Bund</th>
                        <th>Top</th>
                        <th>Antal</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <select name="addBottom">
                                <option value="0">Vælg Bund</option>
                                <% for(Bottom bottom: bottoms){
                                out.println("<option value='"+bottom.getId()+"'>"+bottom.getName()+" - "+bottom.getPrice()+"DKK</option>");
                                } %>
                            </select>
                        </td>
                        <td>
                            <select name="addTop">
                                <option value="0">Vælg Top</option>
                                <% for(Top top: tops){
                                out.println("<option value='"+top.getId()+"'>"+top.getName()+" - "+top.getPrice()+"DKK</option>");
                                } %>
                            </select>
                        </td>
                        <td>
                            <input name="addQTY" type="number" value="1" min="1" max="100">
                        </td>
                        <td>
                            <input type="submit" class="btn" value="Læg i Indkøbskurv">
                        </td>
                    </tr>
                </tbody>
            </table>
            </form>
            <% if(request.getAttribute("errorMsg") != null) {out.println("<div class='errorMsg'>"+request.getAttribute("errorMsg")+"</div>");} %>
            </div>
            <%  ArrayList<Odetails> currentCart = new ArrayList();
                if(session.getAttribute("cart")!=null){
                    currentCart = (ArrayList<Odetails>)session.getAttribute("cart");}
                if(session.getAttribute("cart")==null || currentCart.isEmpty()) {%>
            <h1 class="shop-title">Din indkøbskurv er tom</h1> 
            <% } else { %>
            <div class="cart-wrapper">
            <h1 class="shop-title">Indkøbskurv</h1>
            <table class="shop-table">
                <thead>
                    <tr>
                        <th></th>
                        <th>Produkt</th>
                        <th>Pris</th>
                        <th>Antal</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <% double totalPrice = 0.0;
                       int index = 0;
                        for(Odetails item : currentCart){ %>
                    <tr>
                        <td class="product-remove">
                            <a href="./addToCart?remove=<%= index++ %>" class="remove">×</a>
                        </td>
                        <td>
                            <%= sc.getBottom(item.getBottom_id()).getName() + " med " + sc.getTop(item.getTop_id()).getName() %>
                        </td>
                        <td>
                            <%= item.getPrice() %> DKK
                        </td>
                        <td>
                            <%= item.getQty() %>
                        </td>
                        <td>
                            <%= item.getPrice()*(double)item.getQty() %> DKK
                        </td>
                    </tr>
                    <% totalPrice += item.getPrice()*item.getQty(); } %>
                </tbody>
            </table>
            </div>
             <div class="shop-checkout">
                 <form action="./checkout" method="POST">
                 <h3 class="shop-title">Pris i alt</h3>
                 <h4>Subtotal: <%= totalPrice %> DKK</h4>
                 <h4>Levering: gratis afhentning</h4>
                 <h4>Total: <%= totalPrice %> DKK</h4>
                 <input type="submit" class="btn checkoutbtn" value="Videre til kassen">
                 </form>
            </div>
            <div class="clearfix"></div>
            <% } %>
        </div>
        
        <div class="footer">
            <footer class="footer-content">
                Happy Cupcakes webshop school project   
            </footer>
        </div>
    </body>
</html>