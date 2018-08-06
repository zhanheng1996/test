package com.exercise.demo.controller;

import com.exercise.demo.model.User;
import com.exercise.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = {"/loginCheck"})
    public String login(@Param("username") String username, @Param("password") String password) {
        User user = userService.login(username, password);
        if (user != null) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping(path = {"/doRegister"})
    public String doRegister(@Param("username") String username,
                             @Param("password") String password,
                             @Param("conPassword") String conPassword) {
        if (!password.equals(conPassword)) {
            System.out.println("aaa" + conPassword + password);
            return "register";
        }
        User user = new User(-1, username, password);
        userService.doRegister(user);
        return "login";
    }

    @RequestMapping(path = {"/login"})
    public String login() {
        return "login";
    }

    @RequestMapping(path = {"/register"})
    public String register() {
        return "register";
    }

}
