package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class DriverController extends HttpServlet {
    DriverService driverService = new DriverService();

    public void init() {
        System.out.println("DriverController initialized");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Driver> driverList = driverService.fetchDrivers();
        request.getSession().setAttribute("driverList", driverList);
        response.sendRedirect("/display-drivers.jsp");
    }

    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

    public void destroy() {
        System.out.println("DriverController destroyed");
    }
}
