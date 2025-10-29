package com.shop.servlets;

import com.shop.dao.ProductDAO;
import com.shop.models.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private ProductDAO dao = new ProductDAO();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = dao.getAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("admin.jsp").forward(req, resp);
    }
}
