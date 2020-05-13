package com.river.service;

import com.river.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public List<User> getUsers();
    public List<User> getUserByAddress(String address);
    public void deleteUser(User user);
}
