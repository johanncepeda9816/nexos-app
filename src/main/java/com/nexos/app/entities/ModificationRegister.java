package com.nexos.app.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "modifications")
@Entity
public class ModificationRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "modifier")
    private int modifiedBy;

    @Column(name = "item")
    private String item;

    @Column(name = "date")
    private Date date;
    

    public ModificationRegister() {
    }

    public ModificationRegister(int modifiedBy, String item, Date date) {
        this.modifiedBy = modifiedBy;
        this.item = item;
        this.date = date;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", modifiedBy='" + getModifiedBy() + "'" +
            ", item='" + getItem() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }

}
