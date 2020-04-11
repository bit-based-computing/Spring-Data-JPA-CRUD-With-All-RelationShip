package com.jpa.curd.curd.controllers;

import com.jpa.curd.curd.domains.Comment;
import com.jpa.curd.curd.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public Page<Comment> getAllComments(Pageable pageable) {
        return commentService.getAllComments(pageable);
    }

    @GetMapping("/{postId}/comments")
    public Page<Comment> getAllCommentsByPostId(@PathVariable long postId, Pageable pageable) {
        return commentService.getAllCommentsByPostId(postId, pageable);
    }

    @PostMapping("/{postId}/comments")
    public Comment saveComment(@PathVariable long postId, @Valid @RequestBody Comment comment) {
        return commentService.saveComment(postId, comment);
    }

    @PutMapping("/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable long postId, @PathVariable long commentId, @Valid @RequestBody Comment comment) {
        return commentService.updateComment(postId, commentId, comment);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable long postId, @PathVariable long commentId) {
        return commentService.deleteComment(postId, commentId);
    }


}
