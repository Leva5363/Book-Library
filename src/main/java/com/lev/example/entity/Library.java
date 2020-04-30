package com.lev.example.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LIBRARY")
public class Library implements Serializable {

    @Id
    private int id;


    @Column(name = "ID_BOOK")
    private int idBook;

    @Column(name = "AMOUNT_BOOK")
    private String amountBook;

    public Library() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAmountBook() {
        return amountBook;
    }


    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setAmountBook(String amountBook) {
        this.amountBook = amountBook;


    }
}
