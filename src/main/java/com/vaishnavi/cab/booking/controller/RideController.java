package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class RideController extends HttpServlet{
    private RideService service;

    public void init() {
        service = new RideService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Ride> rides = service.getAllRides();
            request.setAttribute("rides", rides);
            request.getRequestDispatcher("jsp/bookRide.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Ride ride = new Ride();
        ride.setUserId(Integer.parseInt(request.getParameter("userId")));
        ride.setDriverId(Integer.parseInt(request.getParameter("driverId")));
        ride.setPickupLocation(request.getParameter("pickup"));
        ride.setDropoffLocation(request.getParameter("dropoff"));
        ride.setFare(Double.parseDouble(request.getParameter("fare")));
        ride.setStatus("Booked");

        try {
            service.bookRide(ride);
            response.sendRedirect("ride");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        System.out.println("RideController destroyed.");
    }
}
