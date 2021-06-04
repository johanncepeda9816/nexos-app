package com.nexos.app.services;

import java.sql.Date;
import java.util.List;

import com.nexos.app.exceptions.AppException;
import com.nexos.app.model.Item;

public interface ItemServices {
    List<Item> allItems();
    List<Item> findByDate(Date date);
    List<Item> findByUser(int user);
    Item findByName(String name);
    void addItem(Item item) throws AppException;
    void updateItem(Item item, int user) throws AppException;
    void deleteItem(String name, int user) throws AppException;
}
