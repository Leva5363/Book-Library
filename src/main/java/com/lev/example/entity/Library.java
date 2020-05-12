package com.lev.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "LIBRARY")
public class Library extends GeneratorIdEntity {

    @Column(name = "ID_BOOK")
    private int idBook;

    @Column(name = "AMOUNT_BOOK")
    private int amountBook;

    public Library() {
    }

    public Integer getAmountBook() {
        return amountBook;
    }


    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setAmountBook(Integer amountBook) {
        this.amountBook = amountBook;
    }

    @Override
    public String toString() {
        return "Library{" +
                "idBook=" + idBook +
                ", amountBook=" + amountBook +
                '}';
    }
}
