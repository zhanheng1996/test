package com.exercise.demo.service;

import com.exercise.demo.model.User;

public interface UserService {
    public User login(String username,String password);
    public int doRegister(User user);
}
