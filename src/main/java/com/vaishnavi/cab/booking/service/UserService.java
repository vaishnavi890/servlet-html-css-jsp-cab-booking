package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserRepository repo = new UserRepository();

    public void registerUser(User user) throws SQLException {
        repo.addUser(user);
    }

    public List<User> listUsers() throws SQLException {
        return repo.getAllUsers();
    }

    public List<User> fetchAllUsers() {
        return List.of();
    }
}
