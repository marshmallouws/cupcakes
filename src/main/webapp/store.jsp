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
        <jsp:include page="./header.jsp"></jsp:include>
        <div class="cc_header">Dine gladeste cupcakes</div>
        <div class="cc_main">
            <%  ShopController sc = new ShopController();
                ArrayList<Top> tops = sc.getAllTops();
                ArrayList<Bottom> bottoms = sc.getAllBottoms(); %>                  
            <div class="cc_add-to-cart-wrapper">
            <h2 class="cc_shop-title">Tilføj Cupcakes Til Indkøbskurv</h2>
            <form action="./addToCart" method="POST">
            <table class="cc_shop-table">
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
                            <input type="submit" class="cc_btn" value="Læg i Indkøbskurv">
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
            <h1 class="cc_shop-title">Din indkøbskurv er tom</h1> 
            <% } else { %>
            <div class="cc_cart-wrapper">
            <h1 class="cc_shop-title">Indkøbskurv</h1>
            <table class="cc_shop-table">
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
                        <td class="cc_product-remove">
                            <a href="./addToCart?remove=<%= index++ %>" class="cc_remove">×</a>
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
             <div class="cc_shop-checkout">
                 <form action="./checkout" method="POST">
                 <h3 class="cc_shop-title">Pris i alt</h3>
                 <h4>Subtotal: <%= totalPrice %> DKK</h4>
                 <h4>Levering: gratis afhentning</h4>
                 <h4>Total: <%= totalPrice %> DKK</h4>
                 <input type="submit" class="cc_btn cc_checkoutbtn" value="Videre til kassen">
                 </form>
            </div>
            <div class="clearfix"></div>
            <% } %>
        </div>
        
        <div class="cc_footer">
            <footer class="cc_footer-content">
                Happy Cupcakes webshop school project   
            </footer>
        </div>
    </body>
</html>