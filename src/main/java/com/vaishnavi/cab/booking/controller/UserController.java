package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class UserController extends HttpServlet {
    UserService userService = new UserService();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<User> users = userService.fetchAllUsers();
        req.getSession().setAttribute("userList", users);
        res.sendRedirect("/display-users.jsp");
    }

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        this.doGet(req, res);
    }

    public void destroy() {
        System.out.println("Servlet destroyed...");
    }
}
