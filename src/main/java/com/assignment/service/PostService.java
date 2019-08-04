package com.assignment.service;

import com.assignment.model.Post;
import com.assignment.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getallPpost(){

        List<Post> posts = postRepository.getAllPost();

        return posts;
    }
}
