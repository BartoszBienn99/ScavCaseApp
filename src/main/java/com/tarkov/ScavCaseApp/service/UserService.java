package com.tarkov.ScavCaseApp.service;

import com.tarkov.ScavCaseApp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    void addUser(User user);
}
