package com.assignment.service;

import com.assignment.model.Post;
import com.assignment.model.User;
import com.assignment.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){

        List<Post> posts = postRepository.getAllPosts();

        return posts;
    }

    public List<Post> getUserPosts(User user){

        List<Post> posts = postRepository.getUserPosts(user);

        return posts;
    }

    public Post getOnePost(Integer postId){
        return postRepository.getOnePost(postId);
    }



    public void createPost (Post newPost, User logedInUser){
        newPost.setDate(new Date());
        newPost.setUser(logedInUser);
        postRepository.createPost(newPost);
    }

    public void editPost (Post post){
        post.setDate(new Date());
        postRepository.editPost(post);
    }

    public void deletePost (Integer postId){
        postRepository.deletePost(postId);
    }

}
