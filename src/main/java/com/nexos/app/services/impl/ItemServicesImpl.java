package com.nexos.app.services.impl;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public void deleteItem(String name) throws AppException {
        Optional<Item> item = itemRepository.findById(name);
        if(!item.isPresent())
            throw new AppException(AppException.ITEM_DO_NOT_EXISTS);
        else
            itemRepository.delete(item.get());
    }

    private String getFormatedDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return now.format(format);
    }

}
