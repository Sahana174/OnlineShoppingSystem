<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List,com.shop.models.Product" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>
<html><head><title>Products</title></head><body>
<h3>Products</h3>
<a href="index.jsp">Home</a>
<hr/>
<ul>
<% for (Product p : products) { %>
    <li>
        <b><%= p.getName() %></b> - Rs. <%= p.getPrice() %> <br/>
        <form action="cart" method="post" style="display:inline;">
            <input type="hidden" name="productId" value="<%= p.getId() %>"/>
            <button>Add to cart</button>
        </form>
    </li>
<% } %>
</ul>
</body></html>
