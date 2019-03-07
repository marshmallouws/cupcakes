<%-- 
    Document   : orderdetails
    Created on : 07-Mar-2019, 11:26:50
    Author     : Casper
--%>

<%@page import="java.util.List"%>
<%@page import="data.Odetails"%>
<% List<Odetails> odetails = (List<Odetails>) request.getAttribute("odetails"); %>

<jsp:include page="header.jsp"></jsp:include>

<div class="cc_nav_margin cc_main">
    
    <% for (Odetails o : odetails) { %>
    
    <p><%= o.getQty() %> x <%= o.getTop_name() %>/<%= o.getBottom_name() %> á <%= o.getPrice() %> kr = <%= (o.getPrice()*o.getQty()) %></p>
    
    <% } %>
    
    <% 
        double total = 0;
        for (Odetails o : odetails) { 
        total += o.getPrice()*o.getQty();
        }
    %>
    
    <% if (total == 0) { %>
    <p>Ingen bestillinger på ordren..</p>
    <%} else {  %>
    <p>Total = <%= total %></p>
    <% } %>
    
</div>

    </body>
</html>
