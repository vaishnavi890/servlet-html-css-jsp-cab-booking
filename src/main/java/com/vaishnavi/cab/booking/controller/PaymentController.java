package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PaymentController extends HttpServlet {
    PaymentService service = new PaymentService();

    public void init() {
        System.out.println("PaymentController initialized");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payment> paymentList = service.fetchPayments();
        request.getSession().setAttribute("paymentList", paymentList);
        response.sendRedirect("/display-payments.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int rideId = Integer.parseInt(request.getParameter("rideId"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            double amount = Double.parseDouble(request.getParameter("amount"));
            String method = request.getParameter("method");

            Payment p = new Payment(0, rideId, userId, amount, method, "");
            service.makePayment(p);
            response.sendRedirect("/payment-success.jsp");

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("/error.jsp");
        }
    }

    public void destroy() {
        System.out.println("PaymentController destroyed");
    }
}
