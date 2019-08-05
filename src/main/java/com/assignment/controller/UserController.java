package com.assignment.controller;

import com.assignment.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }

    @RequestMapping(value = "users/login", method= RequestMethod.POST)
    public String loginUser(User user) {
        System.out.println("******"+user.getUsername()+"**********");
        System.out.println("******"+user.getPassword()+"******");
        return "redirect:/";
    }

    @RequestMapping("users/registration")
    public String registration() {
        return "users/registration";
    }

    @RequestMapping(value = "users/registration", method= RequestMethod.POST)
    public String registerUser(User user) {
        System.out.println("******"+user.getUsername()+"**********");
        System.out.println("******"+user.getPassword()+"******");
        //System.out.println(user.getProfile().getFullName());
        //System.out.println(user.getProfile().getEmailAddress());
        //System.out.println(user.getProfile().getMobileNumber());
        return "redirect:/users/login";
    }
}
