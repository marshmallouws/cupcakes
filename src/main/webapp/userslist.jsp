<%-- 
    Document   : userslist
    Created on : Mar 6, 2019, 12:04:22 PM
    Author     : caspe
--%>

<%@page import="java.util.List"%>
<%@page import="data.User"%>
<% List<User> users = (List<User>) request.getAttribute("users"); %>

<jsp:include page="header.jsp"></jsp:include>

<div class="cc_nav_margin cc_main"><br>
<table class="table" id="myTable">
        <thead>
        <th>id</th>
        <th>Brugernavn</th>
        <th>Email</th>
        <th>Balance</th>
        <th>Adgang</th>
    </thead>
    <tbody>

    <% for (User u : users) { %>

    <tr>
        <td><%= u.getUserID() %></td>
        <td><a href="./AdminAddBalance.jsp?username=<%= u.getUsername() %>"> <%= u.getUsername() %></a></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getBalance() %> kr.</td>
        <td><%= u.getRole() %></td>
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
