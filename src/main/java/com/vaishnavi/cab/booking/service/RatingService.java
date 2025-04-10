package com.vaishnavi.cab.booking.service;


import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.repository.RatingRepository;

import java.sql.SQLException;
import java.util.List;

    public class RatingService {
        private RatingRepository repo = new RatingRepository();

        public void addRating(Rating rating) throws SQLException {
            repo.addRating(rating);
        }

        public List<Rating> getAllRatings() throws SQLException {
            return repo.getAllRatings();
        }
}
