package com.jpa.curd.curd.repositories;

import com.jpa.curd.curd.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
