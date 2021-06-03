package com.nexos.app.controllers;

import com.nexos.app.entities.Item;
import com.nexos.app.services.ItemServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/v1/item")
public class ItemController {

    @Autowired
    ItemServices itemServices;

    @RequestMapping(method = RequestMethod.POST, path = { "addItem" })
    public ResponseEntity<?> addItem(@RequestBody Item item){
        try {
            itemServices.addItem(item);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = { "updateItem" })
    public ResponseEntity<?> updateItem(@RequestBody Item item, @RequestParam("user") int user){
        try {
            itemServices.updateItem(item, user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = { "deleteItem" })
    public ResponseEntity<?> deleteItem(@RequestParam("name") String name){
        try {
            itemServices.deleteItem(name);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
