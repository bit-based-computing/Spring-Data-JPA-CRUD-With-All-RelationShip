package com.jpa.curd.curd.repositories;

import com.jpa.curd.curd.domains.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


public interface CommentRepository extends JpaRepository<Comment, Long> {
            Page<Comment> findByPostId(long postId, Pageable pageable);
            Optional<Comment> findByIdAndPostId(long id, long postId);
}
