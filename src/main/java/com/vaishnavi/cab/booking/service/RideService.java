package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.repository.RideRepository;

import java.sql.SQLException;
import java.util.List;


public class RideService {
    private RideRepository repository = new RideRepository();

    public void bookRide(Ride ride) throws SQLException {
        repository.bookRide(ride);
    }

    public List<Ride> getAllRides() throws SQLException {
        return repository.getAllRides();
    }
}
