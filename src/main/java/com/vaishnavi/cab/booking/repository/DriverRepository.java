package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class DriverRepository {
    public void addDriver(Driver driver) throws SQLException {
        String sql = "INSERT INTO drivers (name, email, phone, cab_details) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, driver.getName());
            ps.setString(2, driver.getEmail());
            ps.setString(3, driver.getPhone());
            ps.setString(4, driver.getCabDetails());
            ps.executeUpdate();
        }
    }

    public ArrayList<Driver> getAllDrivers() throws SQLException {
        ArrayList<Driver> list = new ArrayList<>();
        String sql = "SELECT * FROM drivers";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Driver d = new Driver(
                        rs.getInt("driver_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("cab_details")
                );
                list.add(d);
            }
        }
        return list;
    }

    public void deleteDriver(int id) throws SQLException {
        String sql = "DELETE FROM drivers WHERE driver_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
