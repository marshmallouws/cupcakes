<%-- 
    Document   : orderdetails
    Created on : 07-Mar-2019, 11:26:50
    Author     : Casper
--%>

<%@page import="data.Order"%>
<%@page import="Logic.ShopController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="data.Odetails"%>
<%  ShopController u = new ShopController();
    ArrayList<Odetails> odetails = (ArrayList<Odetails>) request.getAttribute("odetails");
    int id = (int)request.getAttribute("id");
    Order o = u.getOrder(id);
    o.getDetails().addAll(odetails);
    double total = o.getPrice();
    %>

<jsp:include page="header.jsp"></jsp:include>

            <div class="cc_nav_margin cc_main">
    


    <div class="card">
        <div class="card-body">
            <p class="card-text"><% out.println("<h4> Ordre #" + id + " </h1>"); %></p>
            <p class="card-text"><% out.println("<h4> Samlet pris #" + total + " </h1>"); %></p>
    </div>
    
        <table class="table">
        <thead>
        <th>Bund</th>
        <th>Top</th>
        <th>Antal</th>
        <th>Pris</th>
        </thead>
        <tbody>

            <% for (Odetails or : odetails) { %>
            <tr>
                <td><% out.print(or.getBottom_name()); %></td>
                <td><% out.print(or.getTop_name()); %></td>
                <td><% out.print(or.getQty()); %></td>
                <td><% out.print(or.getPrice()*or.getQty());%></td>
            </tr>

            <% }%>
        </tbody>
    </table>    
</div>

<div class="cc_footer">
    <footer class="cc_footer-content">
        Happy Cupcakes webshop school project   
    </footer>
</div>
    </body>
</html>
