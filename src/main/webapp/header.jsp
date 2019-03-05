<%-- 
    Document   : header
    Created on : Mar 5, 2019, 11:01:20 AM
    Author     : caspe
--%>

<%@page import="data.User"%>
<% User user = (User) request.getSession().getAttribute("user"); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/cupcakes.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar bg-light">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="./store.html"><img src ="./images/cupcake_logo_txt.png" width="340" height="66"></a>
                </li>
            <a id="logo"><img src="./images/cupcake_logo.png" width="75" height="75"> </a>
            <a href="./MyOrdersServlet">TIDLIGERE BESTILLINGER</a>
            <a id="saldo">SALDO: <% out.print(user.getBalance()); %></a>
            
            <% if (user != null) { %>
            
            <form method="POST" action="./LogoutServlet">
                <button type="submit" class="btn btn-danger">Logout</button>
            </form>
            <% } %>
            </ul>
        </nav>
