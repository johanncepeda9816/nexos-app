package com.nexos.app.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private PositionType position;

    @Column(name = "enter_date")
    private Date enterDate;

    public User() {
    }

    public User(String name, int age, PositionType position, Date enterDate) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.enterDate = enterDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PositionType getPosition() {
        return this.position;
    }

    public void setPosition(PositionType position) {
        this.position = position;
    }

    public Date getEnterDate() {
        return this.enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", position='" + getPosition() + "'" +
            ", enterDate='" + getEnterDate() + "'" +
            "}";
    }

}
