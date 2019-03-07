<%-- 
    Document   : AdminAddBalance
    Created on : 05-Mar-2019, 10:07:46
    Author     : Bitten
--%>
<%@page import="data.User"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String username = request.getParameter("username"); %>
        <jsp:include page="./header.jsp"></jsp:include>
<div class="cc_nav_margin cc_main">
        <h1>Tilføj til en brugers saldo</h1>
        <form action="./AddBalanceServlet" method="POST">
            <input name="username" type="text" value="<%= username %>" required>
            <input name="DKK" type="number" placeholder="DKK" required> <br><br>
            <input type="submit" class="btn" value="Tilføj til saldo">
        </form>

        <% if (request.getAttribute("errMsg") != null) {
                out.println("<p>" + request.getAttribute("errMsg") + "</p>");
            }%>
</div>
    </body>
</html>
