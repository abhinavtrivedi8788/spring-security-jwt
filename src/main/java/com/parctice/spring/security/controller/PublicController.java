package com.parctice.spring.security.controller;

import com.parctice.spring.security.entity.Users;
import com.parctice.spring.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> publicMethod(@RequestBody Users users) {
        userService.saveUser(users);
        return new ResponseEntity<>(userService.saveUser(users), HttpStatus.CREATED);
    }

    @GetMapping("/authenticate")
    public String securedMethod() {
        return "secured";
    }
}
