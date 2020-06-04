package com.lev.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book extends GeneratorIdEntity {

    @Column(name = "ID_AUTHOR")
    private int idAuthor;

    @Column(name = "NAME")
    private String name;

    public Book() {
    }

    public Book(int idAuthor, String name) {
        super();
        this.idAuthor = idAuthor;
        this.name = name;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idAuthor=" + idAuthor +
                ", name='" + name + '\'' +
                '}';
    }
}
