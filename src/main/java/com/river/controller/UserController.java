package com.river.controller;

import com.river.model.User;
import com.river.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/save")
    public User saveUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping(value = "/getUsers")
    public List<User> findAllUser(){
        return userService.getUsers();
    }

    @GetMapping(value = "getUserByAddress/{address}")
    public List<User> findUserByAddress(@PathVariable String address){
        return userService.getUserByAddress(address);
    }

    @DeleteMapping(value = "/remove")
    public User removeUser(@RequestBody User user){
        userService.deleteUser(user);
        return user;
    }
}
