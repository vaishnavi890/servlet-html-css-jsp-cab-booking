package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/rating")
public class RatingController extends HttpServlet {
    private RatingService service;

    public void init() {
        service = new RatingService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Rating> ratings = service.getAllRatings();
            request.setAttribute("ratings", ratings);
            request.getRequestDispatcher("jsp/rating.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Rating rating = new Rating();
        rating.setRideId(Integer.parseInt(request.getParameter("rideId")));
        rating.setUserId(Integer.parseInt(request.getParameter("userId")));
        rating.setDriverId(Integer.parseInt(request.getParameter("driverId")));
        rating.setRating(Integer.parseInt(request.getParameter("rating")));
        rating.setReview(request.getParameter("review"));

        try {
            service.addRating(rating);
            response.sendRedirect("rating");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        System.out.println("RatingController destroyed.");
    }

}
