<%-- 
    Document   : orderslist
    Created on : Mar 5, 2019, 12:36:11 PM
    Author     : caspe
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="data.Order"%>
<% List<Order> orders = (List<Order>) request.getAttribute("orders");
    Collections.sort(orders, Collections.reverseOrder());
%>

<jsp:include page="./header.jsp"></jsp:include>

    <div class="cc_nav_margin cc_main">
    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Søg efter brugernavn">
    <button onclick="sortTableUsername()">Sort by username</button>
    <button onclick="sortTableDate()">Sort by date</button>
    <table class="table" id="myTable">
        <thead>
        <th>id</th>
        <th>Username</th>
        <th>Date</th>
    </thead>
    <tbody>

    <% for (Order order : orders) { %>

    <tr>
        <td><a href="./OdetailServlet?order_id=<%= order.getID() %>"><% out.print(order.getID()); %></a></td>
        <td><% out.print(order.getUsername()); %></td>
        <td><% out.print(order.getDate()); %></td>
    </tr>

    <% }%>
</tbody>
</table>

    </div>

<script>
    function myFunction() {
    // Declare variables 
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    
    // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
    }
</script>

<script>
    function sortTableUsername() {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("myTable");
  switching = true;
  /* Make a loop that will continue until
  no switching has been done: */
  while (switching) {
    // Start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /* Loop through all table rows (except the
    first, which contains table headers): */
    for (i = 1; i < (rows.length - 1); i++) {
      // Start by saying there should be no switching:
      shouldSwitch = false;
      /* Get the two elements you want to compare,
      one from current row and one from the next: */
      x = rows[i].getElementsByTagName("TD")[1];
      y = rows[i + 1].getElementsByTagName("TD")[1];
      // Check if the two rows should switch place:
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        // If so, mark as a switch and break the loop:
        shouldSwitch = true;
        break;
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}
</script>

<script>
    function sortTableDate() {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("myTable");
  switching = true;
  /* Make a loop that will continue until
  no switching has been done: */
  while (switching) {
    // Start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /* Loop through all table rows (except the
    first, which contains table headers): */
    for (i = 1; i < (rows.length - 1); i++) {
      // Start by saying there should be no switching:
      shouldSwitch = false;
      /* Get the two elements you want to compare,
      one from current row and one from the next: */
      x = rows[i].getElementsByTagName("TD")[2];
      y = rows[i + 1].getElementsByTagName("TD")[2];
      // Check if the two rows should switch place:
      if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
        // If so, mark as a switch and break the loop:
        shouldSwitch = true;
        break;
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}
</script>

<div class="cc_footer">
    <footer class="cc_footer-content">
        Happy Cupcakes webshop school project   
    </footer>
</div>
</body>
</html>
