<%-- 
    Document   : header
    Created on : Mar 5, 2019, 11:01:20 AM
    Author     : caspe
--%>

<%@page import="data.Role"%>
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
        <div class="cc_navbar">
            <%  session = request.getSession();
                User loggedUser = (User)session.getAttribute("user"); %>
            <div class="cc_nav-wrapper">
            <div class="cc_navigation-logo">
                <img src="./images/cupcake_logo.png" width="50">
                <img src ="./images/cupcake_logo_txt.png" width="250"> 
            </div>
            <div class="cc_navigation">
                <a href="./store.jsp" class="cc_link">Køb Cupcakes</a>
                <a href="./MyOrdersServlet" class="cc_link">Tidligere Ordre</a>
                
                <% if(user != null) { %>
                <a href="./LogoutServlet" class="cc_link">Log ud</a>
                <span class="cc_link">Balance: <%= user.getBalance() %> DKK</span>
                <% } %>
            </div>
            </div>
        </div>
        <div class="clearfix"></div>