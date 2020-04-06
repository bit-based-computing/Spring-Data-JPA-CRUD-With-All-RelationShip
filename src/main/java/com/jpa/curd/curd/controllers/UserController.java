package com.jpa.curd.curd.controllers;

import com.jpa.curd.curd.domains.User;
import com.jpa.curd.curd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public Page<User> getAllUser(Pageable pageable){
       return userService.getAllUser(pageable);
    }

    @PostMapping
    public User saveUser(@Valid @RequestBody User user){
        return  userService.saveUser(user);
    }
}
