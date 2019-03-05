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
        <h1> <% out.print(user.getUsername()); %>'s Ordre</h1>
        
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
