package com.jpa.curd.curd.services;

import com.jpa.curd.curd.domains.User;
import com.jpa.curd.curd.exceptions.ApplicationRunTimeException;
import com.jpa.curd.curd.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Page<User> getAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new ApplicationRunTimeException("User Id " + userId + " Not Found!"));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User updatedUser) {
        return userRepository.findById(userId).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }).orElseThrow(() -> new ApplicationRunTimeException("user Id " + userId + " Not Found!"));
    }

    public ResponseEntity<?> deleteUser(Long userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ApplicationRunTimeException("user Id " + userId + " Not Found!"));
    }

}
