package com.jpa.curd.curd.services;

import com.jpa.curd.curd.domains.Comment;
import com.jpa.curd.curd.exceptions.ApplicationRunTimeException;
import com.jpa.curd.curd.repositories.CommentRepository;
import com.jpa.curd.curd.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public Page<Comment> getAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    public Page<Comment> getAllCommentsByPostId(long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable);
    }

    public Comment saveComment(long postId, Comment comment) {
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ApplicationRunTimeException("Post Id " + postId + "Not Found!"));
    }

    public Comment updateComment(long postId, long commentId, Comment commentRequest) {
        if (!postRepository.existsById(postId)) {
            throw new ApplicationRunTimeException("Post Id " + postId + " Not Found!");
        }
        return commentRepository.findById(commentId).map(comment -> {
            comment.setText(commentRequest.getText());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ApplicationRunTimeException("Comment Id " + commentId + " Not Found!"));
    }

    public ResponseEntity<?> deleteComment(long postId, long commentId) {
        return commentRepository.findByIdAndPostId(commentId, postId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ApplicationRunTimeException("Comment Not found"));
    }

}
