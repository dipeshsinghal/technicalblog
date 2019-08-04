package com.assignment.controller;


import com.assignment.model.Post;
import com.assignment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model){

        List<Post> posts = postService.getallPpost();

        model.addAttribute("posts", posts);

        return "index";
    }
}
