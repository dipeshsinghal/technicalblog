package com.assignment.controller;

import com.assignment.model.Post;
import com.assignment.model.User;
import com.assignment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/posts/my")
    public String getUserPosts(Model model, HttpSession httpSession){

        //List<Post> posts = postService.getAllPosts();

        User loggedInUser = (User)httpSession.getAttribute("logedinuser");
        List<Post> posts = postService.getUserPosts(loggedInUser);

        model.addAttribute("posts", posts);

        return "posts/my";
    }

    @RequestMapping(value = "/posts/create")
    public String createPost(Model model) {
        Post post = new Post();
        model.addAttribute("Post", post);
        return "posts/create";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String newPost(Post newPost, HttpSession httpSession) {
        User logedInUser = (User)httpSession.getAttribute("logedinuser");
        postService.createPost(newPost, logedInUser);
        return "redirect:/posts/my";
    }
}
