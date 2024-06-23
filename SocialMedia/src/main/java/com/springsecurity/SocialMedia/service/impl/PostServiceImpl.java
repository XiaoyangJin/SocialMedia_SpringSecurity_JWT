package com.springsecurity.SocialMedia.service.impl;

import com.springsecurity.SocialMedia.entity.Post;
import com.springsecurity.SocialMedia.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PostServiceImpl implements PostService {

    private final List<Post> posts = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public PostServiceImpl(){
    }

    @Override
    public List<Post> getAllPost() {
        return posts;
    }

    @Override
    public Post getPostById(Long id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Post createPost(Post post) {
        post.setId(counter.incrementAndGet());
        posts.add(post);
        return post;
    }

    @Override
    public Post updatePost(Long id, Post post) {
        Post existingPost = getPostById(id);
        if (existingPost != null) {
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
        }
        return existingPost;
    }

    @Override
    public void deletePost(Long id) {
        posts.removeIf(post -> post.getId().equals(id));
    }
}
