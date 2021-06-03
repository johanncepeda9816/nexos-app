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
    @Column(name = "name")
    private String name;
    @Column(name = "product")
    private String product;
    @Column(name = "amount")
    private int amount;
    @Column(name = "enter_date")
    private Date enterDate;
    @Column(name = "creator")
    private int creatorId;
    @Column(name = "modified")
    private boolean modified;

    public Item() {
    }

    public Item(String name, String product, int amount, Date enterDate, int creatorId) {
        this.name = name;
        this.product = product;
        this.amount = amount;
        this.enterDate = enterDate;
        this.creatorId = creatorId;
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

    public int getCreatorId() {
        return this.creatorId;
    }

    public boolean isModified() {
        return this.modified;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getUser() {
        return this.creatorId;
    }

    public void setUser(int user) {
        this.creatorId = user;
    }

    public boolean getModified() {
        return this.modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", product='" + getProduct() + "'" +
            ", amount='" + getAmount() + "'" +
            ", enterDate='" + getEnterDate() + "'" +
            ", creatorId='" + getCreatorId() + "'" +
            ", modified='" + getModified() + "'" +
            "}";
    }
    
}
