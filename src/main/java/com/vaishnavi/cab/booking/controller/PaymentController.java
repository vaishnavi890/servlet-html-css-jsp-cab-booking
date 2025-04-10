package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/payment")
public class PaymentController extends HttpServlet {
    private PaymentService service;

    public void init() {
        service = new PaymentService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Payment> payments = service.getAllPayments();
            request.setAttribute("payments", payments);
            request.getRequestDispatcher("jsp/payment.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Payment payment = new Payment();
        payment.setRideId(Integer.parseInt(request.getParameter("rideId")));
        payment.setUserId(Integer.parseInt(request.getParameter("userId")));
        payment.setAmount(Double.parseDouble(request.getParameter("amount")));
        payment.setPaymentMethod(request.getParameter("method"));
        payment.setStatus("Paid");

        try {
            service.makePayment(payment);
            response.sendRedirect("payment");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        System.out.println("PaymentController destroyed.");
    }

}
