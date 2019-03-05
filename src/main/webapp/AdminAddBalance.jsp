<%-- 
    Document   : AdminAddBalance
    Created on : 05-Mar-2019, 10:07:46
    Author     : Bitten
--%>
<%@page import="data.User"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/cupcakes.css">
        <title>Add Balance</title>
        <jsp:include page="./header.jsp"></jsp:include>
    </head>
    <body>

        <h1>Tilføj til en brugers saldo</h1>
        <form action="./AddBalanceServlet" method="POST">
            <input name="username" type="text" placeholder="Brugernavn" required>
            <input name="DKK" type="number" placeholder="DKK" required> <br><br>
            <input type="submit" class="btn" value="Tilføj til saldo">
        </form>

        <% if (request.getAttribute("errMsg") != null) {
                out.println("<p>" + request.getAttribute("errMsg") + "</p>");
            }%>

    </body>
</html>
