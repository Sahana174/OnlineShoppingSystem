<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    com.shop.models.User u = (com.shop.models.User) session.getAttribute("user");
%>
<html>
<head><title>Online Shop</title></head>
<body>
<h2>Welcome to Online Shop</h2>
<% if (u == null) { %>
    <a href="login.jsp">Login</a> | <a href="register.jsp">Register</a>
<% } else { %>
    Hello, <b><%= u.getUsername() %></b> | <a href="logout.jsp">Logout</a>
    <% if ("admin".equals(u.getRole())) { %> | <a href="admin.jsp">Admin</a><% } %>
<% } %>
<hr/>
<a href="products">Browse Products</a> | <a href="cart.jsp">Cart</a>
</body>
</html>
