package com.tarkov.ScavCaseApp.controller;

import com.tarkov.ScavCaseApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    private String viewHomePage(Model model) {
        return "index";
    }


}
