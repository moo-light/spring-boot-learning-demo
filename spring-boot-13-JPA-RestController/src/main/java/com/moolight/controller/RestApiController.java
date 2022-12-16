package com.moolight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moolight.model.User;
import com.moolight.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {
    private final UserRepository userRepository;


    public RestApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String getUsers() {
        System.out.println(userRepository.findAll());
        return userRepository.findAll().toString();
    }
}