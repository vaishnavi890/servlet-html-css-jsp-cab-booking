package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RatingController extends HttpServlet {
    RatingService service = new RatingService();

    public void init() {
        System.out.println("RatingController initialized");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Rating> ratingList = service.getRatings();
        request.getSession().setAttribute("ratingList", ratingList);
        response.sendRedirect("/display-ratings.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int rideId = Integer.parseInt(request.getParameter("rideId"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            int driverId = Integer.parseInt(request.getParameter("driverId"));
            int ratingValue = Integer.parseInt(request.getParameter("rating"));
            String review = request.getParameter("review");

            Rating rating = new Rating(0, rideId, userId, driverId, ratingValue, review);
            service.saveRating(rating);

            double avg = service.calculateAverage(driverId);
            request.getSession().setAttribute("avgRating", avg);
            response.sendRedirect("/display-ratings.jsp");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("/error.jsp");
        }
    }

    public void destroy() {
        System.out.println("RatingController destroyed");
    }
}

