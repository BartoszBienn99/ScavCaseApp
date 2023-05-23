package com.tarkov.ScavCaseApp.service;

import com.tarkov.ScavCaseApp.model.User;
import com.tarkov.ScavCaseApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = userRepository.findByLogin(username);

        if (user == null)
            throw new UsernameNotFoundException("Nieprawidłowa nazwa użytkownika, lub hasło");

        return user;
    }


}
