package com.assignment.service;

import com.assignment.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    public List<Post> getallPpost(){
        Post post1 = new Post("Post A title", "Post A body", new Date());
        Post post2 = new Post("Post B title", "Post B body", new Date());
        Post post3 = new Post("Post C title", "Post C body", new Date());

        List<Post> posts = new ArrayList<>();

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        return posts;
    }
}
