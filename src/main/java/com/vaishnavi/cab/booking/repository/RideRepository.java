package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class RideRepository {
    public void bookRide(Ride ride) throws SQLException {
        String sql = "INSERT INTO rides (user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ride.getUserId());
            ps.setInt(2, ride.getDriverId());
            ps.setString(3, ride.getPickupLocation());
            ps.setString(4, ride.getDropoffLocation());
            ps.setDouble(5, ride.getFare());
            ps.setString(6, ride.getStatus());
            ps.executeUpdate();
        }
    }

    public ArrayList<Ride> getAllRides() throws SQLException {
        ArrayList<Ride> list = new ArrayList<>();
        String sql = "SELECT * FROM rides";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Ride r = new Ride(
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getInt("driver_id"),
                        rs.getString("pickup_location"),
                        rs.getString("dropoff_location"),
                        rs.getDouble("fare"),
                        rs.getString("status")
                );
                list.add(r);
            }
        }
        return list;
    }
}
