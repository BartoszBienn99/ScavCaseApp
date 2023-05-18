package com.tarkov.ScavCaseApp.controller;

import com.tarkov.ScavCaseApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public String
}
