package com.ms.user.services;

import org.springframework.stereotype.Service;

import com.ms.user.models.User;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    final UserRepository userRepository;
    final UserProducer userProducer;

    UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public User save(User user) {
        var userModel = userRepository.save(user);
        userProducer.publishMessageEmail(userModel);
        return userModel;
    }
}
