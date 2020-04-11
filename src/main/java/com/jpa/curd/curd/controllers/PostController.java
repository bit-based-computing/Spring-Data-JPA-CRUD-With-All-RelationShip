package com.jpa.curd.curd.controllers;

import com.jpa.curd.curd.domains.Post;
import com.jpa.curd.curd.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public Page<Post> getAllPosts(Pageable pageable){
        return postService.getAllPosts(pageable);
    }

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable long postId){
       return postService.getPost(postId);
    }

    @PostMapping
    public Post savePost(@Valid @RequestBody Post post){
        return postService.savePost(post);
    }

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable long postId, @Valid @RequestBody Post post){
        return postService.updatePost(postId, post);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable long postId){
        return postService.deletePost(postId);
    }

}
