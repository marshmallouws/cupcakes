<%-- 
    Document   : userslist
    Created on : Mar 6, 2019, 12:04:22 PM
    Author     : caspe
--%>

<%@page import="java.util.List"%>
<%@page import="data.User"%>
<% List<User> users = (List<User>) request.getAttribute("users"); %>

<jsp:include page="header.jsp"></jsp:include>

<table class="table" id="myTable">
        <thead>
        <th>user-id</th>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Balance</th>
        <th>Role</th>
    </thead>
    <tbody>

    <% for (User u : users) { %>

    <tr>
        <td><%= u.getUserID() %></td>
        <td><a href="./AdminAddBalance.jsp?username=<%= u.getUsername() %>"> <%= u.getUsername() %></a></td>
        <td><%= u.getPassword() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getBalance() %></td>
        <td><%= u.getRole() %></td>
    </tr>

    <% }%>
</tbody>
</table>

    </body>
</html>
