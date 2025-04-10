package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DriverController extends HttpServlet{
    private DriverService service;

    public void init() {
        service = new DriverService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Driver> drivers = service.listDrivers();
            request.setAttribute("drivers", drivers);
            request.getRequestDispatcher("jsp/registerDriver.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Driver driver = new Driver();
        driver.setName(request.getParameter("name"));
        driver.setEmail(request.getParameter("email"));
        driver.setPhone(request.getParameter("phone"));
        driver.setCabDetails(request.getParameter("cabDetails"));

        try {
            service.registerDriver(driver);
            response.sendRedirect("driver");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        System.out.println("DriverController destroyed.");
    }
}
