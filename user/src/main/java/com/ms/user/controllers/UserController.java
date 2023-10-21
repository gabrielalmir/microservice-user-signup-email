package com.ms.user.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.models.User;
import com.ms.user.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

    final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        var user = new User();
        BeanUtils.copyProperties(userRecordDto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
}
