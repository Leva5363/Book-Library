package com.lev.example.entity;

public class AddNewRecordEntity {


    private int idReader;


    private int idBook;


    private String dateTake;


    private String returnDate;

    public AddNewRecordEntity() {
    }

    public AddNewRecordEntity(int idReader, int idBook, String dateTake, String returnDate) {
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

    public String getDateTake() {
        return dateTake;
    }

    public void setDateTake(String dateTake) {
        this.dateTake = dateTake;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
