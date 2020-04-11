package com.jpa.curd.curd.services;

import com.jpa.curd.curd.domains.Post;
import com.jpa.curd.curd.exceptions.ApplicationRunTimeException;
import com.jpa.curd.curd.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Page<Post> getAllPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    public Post getPost(long postId){
        return postRepository.findById(postId).orElseThrow(()-> new ApplicationRunTimeException("Post Id " + postId + " Not Found !"));
    }

    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public Post updatePost(long postId, Post updatedPost){
        return postRepository.findById(postId).map(post -> {
            post.setTitle(updatedPost.getTitle());
            post.setDescription(updatedPost.getDescription());
            post.setContent(updatedPost.getContent());
            return postRepository.save(post);
        }).orElseThrow(()-> new ApplicationRunTimeException("Post Id " + postId + "Not Found!"));
    }

    public ResponseEntity<?> deletePost(long postId){
        return postRepository.findById(postId).map(post->{
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ApplicationRunTimeException("Post Id " + postId + " Not Found !"));
    }

}
