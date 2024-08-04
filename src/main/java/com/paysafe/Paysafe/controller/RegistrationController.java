package com.paysafe.Paysafe.controller;

import com.paysafe.Paysafe.model.MyUser;
import com.paysafe.Paysafe.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private MyUserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register/user")
    public MyUser createUser(@RequestBody MyUser user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

}
