package com.nexos.app.services;

import java.util.List;

import com.nexos.app.model.User;

public interface UserServices {

    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
}
