package com.jpa.curd.curd.services;

import com.jpa.curd.curd.domains.User;
import com.jpa.curd.curd.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Page<User> getAllUser(Pageable pageable){
        return userRepository.findAll(pageable);
    }

}
