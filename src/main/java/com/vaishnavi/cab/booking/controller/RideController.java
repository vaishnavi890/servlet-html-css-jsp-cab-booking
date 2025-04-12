package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RideController extends HttpServlet {
    RideService rideService = new RideService();

    public void init() {
        System.out.println("RideController initialized");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ride> rideList = rideService.fetchRides();
        request.getSession().setAttribute("rideList", rideList);
        response.sendRedirect("/display-rides.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(request.getParameter("userId"));
            int driverId = Integer.parseInt(request.getParameter("driverId"));
            String pickup = request.getParameter("pickup");
            String dropoff = request.getParameter("dropoff");

            Ride ride = new Ride(0, userId, driverId, pickup, dropoff, 0, "");
            rideService.bookRide(ride);
            response.sendRedirect("/ride-success.jsp");

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("/error.jsp");
        }
    }

    public void destroy() {
        System.out.println("RideController destroyed");
    }
}
