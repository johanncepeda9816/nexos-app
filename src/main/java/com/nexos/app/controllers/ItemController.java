package com.nexos.app.controllers;

import java.sql.Date;
import java.util.List;

import com.nexos.app.model.Item;
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

    @RequestMapping(method = RequestMethod.GET, path = { "findAll" })
    public ResponseEntity<List<Item>> findAll(){
        try {
            return ResponseEntity.ok().body(itemServices.allItems());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = { "findByDate" })
    public ResponseEntity<List<Item>> findAll(@RequestParam("date") Date date){
        try {
            return ResponseEntity.ok().body(itemServices.findByDate(date));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = { "findByName" })
    public ResponseEntity<Item> findAll(@RequestParam("name") String name){
        try {
            return ResponseEntity.ok().body(itemServices.findByName(name));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = { "findByUser" })
    public ResponseEntity<List<Item>> findAll(@RequestParam("user") int user){
        try {
            return ResponseEntity.ok().body(itemServices.findByUser(user));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
    public ResponseEntity<?> deleteItem(@RequestParam("name") String name, @RequestParam("user") int user){
        try {
            itemServices.deleteItem(name, user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
