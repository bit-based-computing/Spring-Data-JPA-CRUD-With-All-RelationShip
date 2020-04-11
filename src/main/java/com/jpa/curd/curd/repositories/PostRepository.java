package com.jpa.curd.curd.repositories;

import com.jpa.curd.curd.domains.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
