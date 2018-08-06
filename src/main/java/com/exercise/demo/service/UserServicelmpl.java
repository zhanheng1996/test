package com.exercise.demo.service;

import com.exercise.demo.dao.UserDao;
import com.exercise.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServicelmpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User login(String username, String password) {
        User user = userDao.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public int doRegister(User user) {
        return userDao.doRegister(user);
    }

}
