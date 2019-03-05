<%-- 
    Document   : orders
    Created on : Mar 5, 2019, 9:52:08 AM
    Author     : caspe
--%>

<%@page import="java.util.List"%>
<%@page import="data.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Order> orders = ((List<Order>) request.getSession().getAttribute("orders")); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tidligere Ordre</title>
    </head>
    <body>
        <h1>Mine Ordre</h1>
        
        <table>
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
