package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.repository.PaymentRepository;

import java.sql.SQLException;
import java.util.List;


public class PaymentService {
    private PaymentRepository repository = new PaymentRepository();

    public void makePayment(Payment payment) throws SQLException {
        repository.makePayment(payment);
    }

    public List<Payment> getAllPayments() throws SQLException {
        return repository.getAllPayments();
    }

    public List<Payment> fetchPayments() {
        return List.of();
    }
}
