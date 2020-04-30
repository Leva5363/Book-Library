package com.lev.example.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BOOKS")
public class Books implements Serializable {


    @Id
    private int id;

    @Column(name = "ID_AUTHOR")
    private int idAuthor;

    @Column(name = "NAME")
    private String name;

    public Books() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
