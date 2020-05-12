package com.lev.example.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RECORD")
public class Record extends GeneratorIdEntity {

    @Column(name = "ID_READER")
    private int idReader;

    @Column(name = "ID_BOOK")
    private int idBook;

    @Column(name = "DATE_TAKE")
    private Date dateTake;

    @Column(name = "DATE_RETURN")
    private Date returnDate;

    public Record() {
    }

    public Record(int idReader, int idBook, Date dateTake, Date returnDate) {
        super();
        this.idReader = idReader;
        this.idBook = idBook;
        this.dateTake = dateTake;
        this.returnDate = returnDate;
    }

    public int getIdReader() {
        return idReader;
    }

    public void setIdReader(int idReader) {
        this.idReader = idReader;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public Date getDateTake() {
        return dateTake;
    }

    public void setDateTake(Date dateTake) {
        this.dateTake = dateTake;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Record{" +
                "idReader=" + idReader +
                ", idBook=" + idBook +
                ", dateTake=" + dateTake +
                ", returnDate=" + returnDate +
                '}';
    }
}
