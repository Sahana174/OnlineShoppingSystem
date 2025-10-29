package com.shop.servlets;

import com.shop.dao.UserDAO;
import com.shop.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO dao = new UserDAO();
    protected void doPost(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User u = dao.login(username, password);
        if (u != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", u);
            if ("admin".equals(u.getRole())) {
                resp.sendRedirect("admin.jsp");
            } else {
                resp.sendRedirect("index.jsp");
            }
        } else {
            resp.sendRedirect("login.jsp?error=1");
        }
    }
}
