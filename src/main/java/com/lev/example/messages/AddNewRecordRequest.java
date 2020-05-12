package com.lev.example.messages;

public class AddNewRecordRequest {
    private int idReader;
    private int idBook;
    private String dateTake;

    public AddNewRecordRequest() {
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

    @Override
    public String toString() {
        return "AddNewRecordRequest{" +
                "idReader=" + idReader +
                ", idBook=" + idBook +
                ", dateTake='" + dateTake + '\'' +
                '}';
    }
}
