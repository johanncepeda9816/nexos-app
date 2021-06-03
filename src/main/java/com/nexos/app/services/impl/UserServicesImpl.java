package com.nexos.app.services.impl;

import java.util.List;

import com.nexos.app.entities.User;
import com.nexos.app.repositories.UserRepository;
import com.nexos.app.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {

    }

}
