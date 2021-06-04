package com.nexos.app.repositories;

import java.sql.Date;
import java.util.List;

import com.nexos.app.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String>{
    List<Item> findByEnterDate(Date date);
    List<Item> findByCreator(int user);
        
}
