package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.repository.DriverRepository;

import java.sql.SQLException;
import java.util.List;

public class DriverService {
    private DriverRepository repo = new DriverRepository();

    public void registerDriver(Driver driver) throws SQLException {
        repo.addDriver(driver);
    }

    public List<Driver> listDrivers() throws SQLException {
        return repo.getAllDrivers();
    }

    public void removeDriver(int id) throws SQLException {
        repo.deleteDriver(id);
    }

    public List<Driver> fetchDrivers() {
        return List.of();
    }
}
