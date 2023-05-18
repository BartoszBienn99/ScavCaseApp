package com.tarkov.ScavCaseApp.service;

import com.tarkov.ScavCaseApp.model.User;
import com.tarkov.ScavCaseApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        this.userRepository.save(user);

    }
}
