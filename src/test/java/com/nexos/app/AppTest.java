package com.nexos.app;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.nexos.app.exceptions.AppException;
import com.nexos.app.model.Item;
import com.nexos.app.repositories.ItemRepository;
import com.nexos.app.services.ItemServices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AppTest {

    @Autowired
    ItemServices itemServices;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void shouldToCreateItem(){
        try {
            Item item = new Item("Empaques", "Empaques de culata Aveo", 20, Date.valueOf(getFormatedDate()), 1);
            itemServices.addItem(item);
            assertEquals(item.getName(), itemServices.findByName("Empaques").getName());
        } catch (AppException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void shouldToUpdateItem(){
        try {
            Item item = new Item("Empaques", "Empaques de culata Aveo Family", 25, Date.valueOf(getFormatedDate()), 1);
            itemServices.updateItem(item, 1);
            assertEquals(item.getName(), itemServices.findByName("Empaques").getName());
        } catch (AppException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void shouldDoNotCreateTwoItemsWithSameName(){
        try {
            Item item = new Item("Empaques", "Empaques de culata Aveo Family", 25, Date.valueOf(getFormatedDate()), 1);
            Item item2 = new Item("Empaques", "Empaques de culata Aveo Family", 25, Date.valueOf(getFormatedDate()), 1);
            itemServices.addItem(item);
            itemServices.addItem(item2);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void shouldCreateItemIfUserTryToUpdateSomeThatNotExists(){
        try {
            Item item = new Item("Empaques", "Empaques de culata Aveo Family", 25, Date.valueOf(getFormatedDate()), 1);
            itemServices.updateItem(item, 1);
            assertEquals(item.getName(), itemServices.findByName("Empaques").getName());
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void shouldNotUpdateAnItemIfRequestUserIsNotTheCreator(){
        try {
            Item item = new Item("Empaques", "Empaques de culata Aveo Family", 25, Date.valueOf(getFormatedDate()), 1);
            itemServices.updateItem(item, 2);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void shouldCreateItemWithDateBeforeOEqualsNow(){
        try {
            Item item = new Item("Empaques", "Empaques de culata Aveo Family", 25, Date.valueOf(getFormatedDate()), 1);
            itemServices.addItem(item);
            boolean equalDate = item.getEnterDate().compareTo(Date.valueOf(getFormatedDate()))  == 0 ? true : false;
            Assert.assertTrue(equalDate);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void shouldToDeleteItem(){
        try {
            Item item = new Item("Empaques", "Empaques de culata Aveo Family", 25, Date.valueOf(getFormatedDate()), 1);
            itemServices.deleteItem(item.getName(), 1);
            assertEquals(null, itemServices.findByName("Empaques").getName());
        } catch (AppException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    private String getFormatedDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return now.format(format);
    }
}
