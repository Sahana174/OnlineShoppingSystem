<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List,com.shop.models.Product" %>
<%
    List<Product> cart = (List<Product>) session.getAttribute("cart");
    if (cart == null) cart = new java.util.ArrayList<>();
    double total = cart.stream().mapToDouble(p -> p.getPrice()).sum();
%>
<html><head><title>Cart</title></head><body>
<h3>Your Cart</h3>
<a href="products">Continue shopping</a>
<hr/>
<ul>
<% for (Product p : cart) { %>
    <li><%= p.getName() %> - Rs. <%= p.getPrice() %></li>
<% } %>
</ul>
<p>Total: Rs. <%= total %></p>
<form action="checkout" method="post">
    <button type="submit">Checkout</button>
</form>
</body></html>
