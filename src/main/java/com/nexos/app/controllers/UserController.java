package com.nexos.app.controllers;

import java.util.List;

import com.nexos.app.entities.User;
import com.nexos.app.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/v1/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @RequestMapping(method = RequestMethod.GET, path = { "allUsers" })
    public ResponseEntity<List<User>> getAllUsers(){
        try {
            List<User> users = userServices.getAllUsers();
            return ResponseEntity.ok().body(users);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = { "addUser" })
    public ResponseEntity<?> addUser(@RequestBody User user){
        try {
            userServices.addUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }

    @RequestMapping(method = RequestMethod.PUT, path = { "updateUser" })
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try {
            userServices.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
