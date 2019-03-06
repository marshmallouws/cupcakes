<%-- 
    Document   : index
    Created on : 04-Mar-2019, 10:13:21
    Author     : vl48
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cupcakes - Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/cupcakes.css">
    </head>
    <body>
        <div class="login-background">
        <div class="login-wrapper cc_center-wrapper">
            <a href="./">
            <div class="login-image-wrapper">
                <img src="./images/cupcake_logo.png" width="100"><br>
                <img src="./images/cupcake_logo_txt.png" alt="Happy Cupcake">
            </div>
            </a>
            <div class="formstyle">
                <% if(request.getAttribute("errorMsg") != null) {out.println("<div class='cc_errorMsg'>"+request.getAttribute("errorMsg")+"</div>");} %>
        <form action="./login" method="POST">
            <input name="username" type="text" placeholder="Brugernavn" required>
            <input name="password" class="inputSplit" type="password" placeholder="Password" required><br>
            <input type="submit" class="btn" value="Log ind">
        </form>
                <div class="register_link">
                    <a href="./register">Har du ikke en bruger? Opret en bruger her!</a>
                </div>
            </div>
        </div>
        </div>
    </body>
</html>

