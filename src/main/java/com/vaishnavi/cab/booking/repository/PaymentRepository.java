package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class PaymentRepository {
    public void makePayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO payments (ride_id, user_id, amount, payment_method, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, payment.getRideId());
            ps.setInt(2, payment.getUserId());
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getPaymentMethod());
            ps.setString(5, payment.getStatus());
            ps.executeUpdate();
        }
    }

    public ArrayList<Payment> getAllPayments() throws SQLException {
        ArrayList<Payment> list = new ArrayList<>();
        String sql = "SELECT * FROM payments";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Payment p = new Payment(
                        rs.getInt("payment_id"),
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("payment_method"),
                        rs.getString("status")
                );
                list.add(p);
            }
        }
        return list;
    }
}
