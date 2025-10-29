package com.shop.servlets;

import com.shop.dao.UserDAO;
import com.shop.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDAO dao = new UserDAO();
    protected void doPost(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setRole("user");
        boolean ok = dao.register(u);
        if (ok) {
            resp.sendRedirect("login.jsp?msg=registered");
        } else {
            resp.sendRedirect("register.jsp?error=1");
        }
    }
}
