package com.nexos.app.services.impl;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.nexos.app.AppException;
import com.nexos.app.entities.Item;
import com.nexos.app.entities.ModificationRegister;
import com.nexos.app.entities.User;
import com.nexos.app.repositories.ItemRepository;
import com.nexos.app.repositories.ModificationsRepository;
import com.nexos.app.repositories.UserRepository;
import com.nexos.app.services.ItemServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemServicesImpl implements ItemServices {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModificationsRepository modificationsRepository;

    @Override
    public List<Item> allItems() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> findByDate(Date date) {
        return itemRepository.findByEnterDate(date);
    }

    @Override
    public List<Item> findByUser(int user) {
        return findByUser(user);
    }

    @Override
    public Item findByName(String name) {
        return itemRepository.findById(name).get();
    }

    @Override
    public void addItem(Item item) throws AppException {
        Optional<User> user = userRepository.findById(item.getCreatorId());
        Optional<Item> existingItem = itemRepository.findById(item.getName());
        if (!user.isPresent())
            throw new AppException(AppException.USER_NOT_FOUND);

        else if (existingItem.isPresent())
            throw new AppException(AppException.ITEM_ALREADY_EXITS);

        else {
            item.setModified(false);
            item.setEnterDate(Date.valueOf(getFormatedDate()));
            itemRepository.save(item);
        }

    }

    @Override
    public void updateItem(Item item, int user) throws AppException {

        Optional<Item> existingItem = itemRepository.findById(item.getName());
        if (!existingItem.isPresent()) {
            addItem(item);
            System.out.println("Se ha creado un item nuevo");
            throw new AppException(AppException.ITEM_DO_NOT_EXISTS);
        } else {
            item.setModified(true);
            itemRepository.save(item);

            ModificationRegister modificationRegister = new ModificationRegister(user, item.getName(),
                    Date.valueOf(getFormatedDate()));
            modificationsRepository.save(modificationRegister);
        }
    }

    @Override
    public void deleteItem(String name, int user) throws AppException {
        Optional<Item> item = itemRepository.findById(name);
        if(!item.isPresent())
            throw new AppException(AppException.ITEM_DO_NOT_EXISTS);
        else{
            Optional<User> userExists = userRepository.findById(item.get().getCreatorId());
            if(userExists.isPresent() && (user == item.get().getCreatorId()))
                itemRepository.delete(item.get());
            else
                throw new AppException(AppException.ONLY_CREATOR_CAN_DELETE_ITEM);
        }
    }

    private String getFormatedDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return now.format(format);
    }
}
