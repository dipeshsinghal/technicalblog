package com.assignment.controller;

import com.assignment.model.User;
import com.assignment.model.UserProfile;
import com.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users/login")
    public String login() {
        return "users/login";
    }

    @RequestMapping(value = "/users/login", method= RequestMethod.POST)
    public String loginUser(User user, HttpSession session) {
        User loggedInUser = userService.loginUser(user);
        session.setAttribute("logedinuser", loggedInUser);
        return "redirect:/posts/my";
    }

    @RequestMapping("/users/registration")
    public String registration(Model model) {
        User user = new User();
        UserProfile profile = new UserProfile();
        user.setProfile(profile);

        model.addAttribute("User", user);

        return "/users/registration";
    }

    @RequestMapping(value = "/users/registration", method= RequestMethod.POST)
    public String registerUser(User newUser) {
        if( userService.registerUser(newUser) ) {
            return "/users/login";
        } else {
            return "redirect:/users/registration";
        }
    }

    @RequestMapping(value = "/users/logout", method= RequestMethod.POST)
    public String logout(User user, HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
