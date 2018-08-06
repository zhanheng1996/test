package com.exercise.demo.dao;

import com.exercise.demo.model.User;

public interface UserDao {

    User findUserByUsername(String username);
    int doRegister(User user);
}
