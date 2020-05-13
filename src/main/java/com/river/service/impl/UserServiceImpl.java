package com.river.service.impl;

import com.river.dao.UserRepository;
import com.river.model.User;
import com.river.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        System.out.println("Getting data from DB: " + userRepository.findAll());
        return userRepository.findAll();
    }

    @Override
    public List<User> getUserByAddress(String address) {
        return userRepository.findUserByAddress(address);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
