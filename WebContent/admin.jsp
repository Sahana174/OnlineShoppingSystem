<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List,com.shop.models.Product" %>
<%
    com.shop.models.User u = (com.shop.models.User) session.getAttribute("user");
    if (u == null || !"admin".equals(u.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
    List<Product> products = (List<Product>) request.getAttribute("products");
%>
<html><head><title>Admin</title></head><body>
<h3>Admin Dashboard</h3>
<a href="index.jsp">Home</a><hr/>
<ul>
<% for (Product p : products) { %>
    <li><b><%= p.getName() %></b> - Rs. <%= p.getPrice() %> - Qty: <%= p.getQty() %></li>
<% } %>
</ul>
</body></html>
