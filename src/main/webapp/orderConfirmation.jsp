<%-- 
    Document   : orderConfirmation
    Created on : 07-Mar-2019, 09:58:28
    Author     : Annika
--%>

<%@page import="Logic.ShopController"%>
<%@page import="data.Odetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="./header.jsp"></jsp:include>
    <div class="cc_header">Dine gladeste cupcakes</div>
<%
    ShopController sc = new ShopController();
    Order order = sc.getOrder((int) request.getAttribute("orderid"));
    order.getDetails().addAll((ArrayList<Odetails>) request.getAttribute("currCart"));

    String date = order.getDate();
    int id = order.getID();
    //ArrayList<Odetails> details = order.getDetails();
    double price = order.getPrice();
%>
<div class="cc_main">
    <div class="card">
        <div class="card-body">
            <p class="card-text"><% out.println("<h1> Ordre #" + id + " er nu gennemført! </h1>"); %></p>
            <p class="card-text"><% out.println("<h4> Samlet pris: " + price); %></p>
            <p class="card-text"><% out.println("<h4> Afhentningstidspunkt: " + date); %></p>
        </div>
    </div>

    <table class="table">
        <thead>
        <th>Bund</th>
        <th>Top</th>
        <th>Antal</th>
        </thead>
        <tbody>

            <% for (Odetails o : order.getDetails()) { %>
            <tr>
                <td><% out.print(sc.getBottom(o.getBottom_id()).getName()); %></td>
                <td><% out.print(sc.getTop(o.getTop_id()).getName()); %></td>
                <td><% out.print(o.getQty()); %></td>
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
