package com.paysafe.Paysafe.controller;

import com.paysafe.Paysafe.security.MyUserDetailService;
import com.paysafe.Paysafe.security.webtoken.JwtService;
import com.paysafe.Paysafe.security.webtoken.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private MyUserDetailService myUserDetailService;

    @GetMapping("/home")
    public String handleHome() {
        return "home";
    }

    @GetMapping("/login")
    public String handleLogin() {
        return "customLogin";
    }

    @GetMapping("/successPage")
    public String handleUserSuccessLogin() {
        return "successPage";
    }

    @GetMapping("/successPageAdmin")
    public String handleAdminSuccessLogin() {
        return "successPageAdmin";
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.username(), loginForm.password()));
        if (authentication.isAuthenticated())
            return jwtService.generateToken(myUserDetailService.loadUserByUsername(loginForm.username()));

        else throw new UsernameNotFoundException("Invalid username or password.");


    }
}
