package com.tarkov.ScavCaseApp.service;

import com.tarkov.ScavCaseApp.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
}
