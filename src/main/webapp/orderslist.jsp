<%-- 
    Document   : orderslist
    Created on : Mar 5, 2019, 12:36:11 PM
    Author     : caspe
--%>

<%@page import="java.util.List"%>
<%@page import="data.Order"%>
<% List<Order> orders = (List<Order>) request.getAttribute("orders"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="./header.jsp"></jsp:include>
        <h1>Hello World!</h1>
        
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
                
                <% } %>
            </tbody>
        </table>
    </body>
</html>
