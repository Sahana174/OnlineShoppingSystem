package com.shop.servlets;

import com.shop.dao.ProductDAO;
import com.shop.models.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private ProductDAO dao = new ProductDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("productId");
        int productId = Integer.parseInt(pid);
        List<Product> cart = (List<Product>) req.getSession().getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();
        // simple: find product and add to cart (quantity 1)
        for (Product p : dao.getAll()) {
            if (p.getId() == productId) {
                cart.add(p);
                break;
            }
        }
        req.getSession().setAttribute("cart", cart);
        resp.sendRedirect("cart.jsp");
    }
}
