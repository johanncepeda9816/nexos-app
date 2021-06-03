package com.nexos.app.services;

import com.nexos.app.AppException;
import com.nexos.app.entities.Item;

public interface ItemServices {
    void addItem(Item item) throws AppException;
    void updateItem(Item item, int user) throws AppException;
    void deleteItem(String name) throws AppException;
}
