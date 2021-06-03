package com.nexos.app.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "items")
@Entity
public class Item implements Serializable{
    
    @Id
    private String name;
    @Column(name = "product")
    private String product;
    @Column(name = "amount")
    private int amount;
    @Column(name = "enterDate")
    private Date enterDate;
    @Column(name = "user")
    private User user;

    public Item() {
    }

    public Item(String name, String product, int amount, Date enterDate, User user) {
        this.name = name;
        this.product = product;
        this.amount = amount;
        this.enterDate = enterDate;
        this.user = user;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getEnterDate() {
        return this.enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", product='" + getProduct() + "'" +
            ", amount='" + getAmount() + "'" +
            ", enterDate='" + getEnterDate() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

}
