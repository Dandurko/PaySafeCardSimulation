package com.paysafe.Paysafe.controller;

import com.paysafe.Paysafe.security.MyUserDetailService;
import com.paysafe.Paysafe.security.webtoken.JwtService;
import com.paysafe.Paysafe.security.webtoken.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {



    @GetMapping("/home")
    public String handleHome() {
        return "home";
    }

    @GetMapping("/login")
    public String handleLogin() {
        return "customLogin";
    }

    @GetMapping("/user/successPage")
    public String handleUserSuccessLogin() {
        return "successPage";
    }

    @GetMapping("/admin/successPage")
    public String handleAdminSuccessLogin() {
        return "successPageAdmin";
    }

}
