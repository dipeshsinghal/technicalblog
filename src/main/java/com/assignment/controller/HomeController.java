package com.assignment.controller;


import com.assignment.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getAllPosts(Model model){

        Post post1 = new Post("Post A title", "Post A body", new Date());
        Post post2 = new Post("Post B title", "Post B body", new Date());
        Post post3 = new Post("Post C title", "Post C body", new Date());

        List<Post> posts = new ArrayList<>();

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        model.addAttribute("posts", posts);

        return "index";
    }
}
