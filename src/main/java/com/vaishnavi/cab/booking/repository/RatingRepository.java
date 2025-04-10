package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class RatingRepository {

    public void addRating(Rating rating) throws SQLException {
        String sql = "INSERT INTO ratings (ride_id, user_id, driver_id, rating, review) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, rating.getRideId());
            ps.setInt(2, rating.getUserId());
            ps.setInt(3, rating.getDriverId());
            ps.setInt(4, rating.getRating());
            ps.setString(5, rating.getReview());
            ps.executeUpdate();
        }
    }

    public ArrayList<Rating> getAllRatings() throws SQLException {
        ArrayList<Rating> list = new ArrayList<>();
        String sql = "SELECT * FROM ratings";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Rating r = new Rating(
                        rs.getInt("rating_id"),
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getInt("driver_id"),
                        rs.getInt("rating"),
                        rs.getString("review")
                );
                list.add(r);
            }
        }
        return list;
    }
}