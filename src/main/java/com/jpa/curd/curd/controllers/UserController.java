package com.jpa.curd.curd.controllers;

import com.jpa.curd.curd.domains.User;
import com.jpa.curd.curd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public Page<User> getAllUser(Pageable pageable){
       return userService.getAllUser(pageable);
    }
}
