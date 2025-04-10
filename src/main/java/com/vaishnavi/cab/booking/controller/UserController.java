package com.vaishnavi.cab.booking.controller;

import jakarta.servlet.http.HttpServlet;
import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

public class UserController extends HttpServlet {
    private UserService service = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User user = new User();
            user.setName(request.getParameter("name"));
            user.setEmail(request.getParameter("email"));
            user.setPhone(request.getParameter("phone"));
            service.registerUser(user);
            response.sendRedirect("jsp/registerUser.jsp?status=success");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("jsp/registerUser.jsp?status=fail");
        }
    }
}
