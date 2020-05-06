package com.lev.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "READER")
public class Reader extends GeneratorIdEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "LASTNAME")
    private String LastName;

    public Reader() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
