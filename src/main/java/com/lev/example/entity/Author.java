package com.lev.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "AUTHOR")
public class Author extends GeneratorIdEntity {

    @Column(name = "NAME")
    private String name;

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
