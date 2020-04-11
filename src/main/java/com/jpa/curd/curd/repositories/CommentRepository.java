package com.jpa.curd.curd.repositories;

import com.jpa.curd.curd.domains.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
