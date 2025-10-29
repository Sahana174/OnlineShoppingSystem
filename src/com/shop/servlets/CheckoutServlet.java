package com.shop.servlets;

import com.shop.models.User;
import com.shop.utils.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        User u = (User) session.getAttribute("user");
        List<com.shop.models.Product> cart = (List<com.shop.models.Product>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            resp.sendRedirect("cart.jsp?empty=1");
            return;
        }
        double total = cart.stream().mapToDouble(p -> p.getPrice()).sum();
        try (Connection con = DBConnection.getConnection()) {
            String insertOrder = "INSERT INTO orders (user_id, total) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(insertOrder, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, u.getId());
            ps.setDouble(2, total);
            ps.executeUpdate();
            java.sql.ResultSet keys = ps.getGeneratedKeys();
            int orderId = 0;
            if (keys.next()) orderId = keys.getInt(1);
            String insertItem = "INSERT INTO order_items (order_id, product_id, qty, price) VALUES (?, ?, ?, ?)";
            PreparedStatement psi = con.prepareStatement(insertItem);
            for (com.shop.models.Product p : cart) {
                psi.setInt(1, orderId);
                psi.setInt(2, p.getId());
                psi.setInt(3, 1);
                psi.setDouble(4, p.getPrice());
                psi.addBatch();
            }
            psi.executeBatch();
            session.removeAttribute("cart");
            resp.sendRedirect("index.jsp?ordered=1");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("cart.jsp?error=1");
        }
    }
}
