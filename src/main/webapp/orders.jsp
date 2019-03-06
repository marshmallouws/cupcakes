<%-- 
    Document   : orders
    Created on : Mar 5, 2019, 9:52:08 AM
    Author     : caspe
--%>

<%@page import="data.User"%>
<%@page import="java.util.List"%>
<%@page import="data.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User user = (User) request.getSession().getAttribute("user");
    List<Order> orders = ((List<Order>) request.getSession().getAttribute("orders"));
%>
<jsp:include page="./header.jsp"></jsp:include>
    <div class="cc_nav_margin">
        <h1> <% out.print(user.getUsername()); %>'s Ordre</h1>

    <div class="card">
        <div class="card-body">
            <p class="card-text">Brugernavn: <% out.print(user.getUsername()); %></p>
            <p class="card-text">Email: <% out.print(user.getEmail()); %></p>
            <p class="card-text">Balance: <% out.print(user.getBalance()); %></p>
            <p class="card-text">Antal ordrer: <% out.print(orders.size()); %></p>
        </div>
    </div>

    <table class="table">
        <thead>
        <th>id</th>
        <th>Username</th>
        <th>Date</th>
        </thead>
        <tbody>

            <% for (Order order : orders) { %>

            <tr>
                <td><% out.print(order.getID()); %></td>
                <td><% out.print(order.getUserID()); %></td>
                <td><% out.print(order.getDate()); %></td>
            </tr>

            <% }%>
        </tbody>
    </table>

</div>
</body>
</html>
